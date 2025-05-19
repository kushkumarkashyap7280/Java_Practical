package practical13;

import javax.swing.*;
import java.awt.*;

public class ScrollingBannerDemo extends JFrame {
    private BannerPanel bannerPanel;

    public ScrollingBannerDemo() {
        super("Scrolling Banner Demo");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        bannerPanel = new BannerPanel("Welcome to Java Programming - This is a scrolling banner demonstration");

        add(bannerPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        startButton.addActionListener(e -> bannerPanel.startScrolling());
        stopButton.addActionListener(e -> bannerPanel.stopScrolling());

        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScrollingBannerDemo app = new ScrollingBannerDemo();
            app.setVisible(true);
            app.bannerPanel.startScrolling();
        });
    }

    private class BannerPanel extends JPanel implements Runnable {
        private String message;
        private Thread scrollThread;
        private boolean isScrolling;
        private int xPos;
        private final int yPos;
        private final Font bannerFont;

        public BannerPanel(String message) {
            this.message = message;
            this.isScrolling = false;
            this.xPos = -300;
            this.bannerFont = new Font("Arial", Font.BOLD, 24);

            FontMetrics metrics = getFontMetrics(bannerFont);
            yPos = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();

            setBackground(Color.BLACK);
            setPreferredSize(new Dimension(600, 100));
        }

        public void startScrolling() {
            if (!isScrolling) {
                isScrolling = true;
                scrollThread = new Thread(this);
                scrollThread.start();
            }
        }

        public void stopScrolling() {
            isScrolling = false;
            if (scrollThread != null) {
                scrollThread.interrupt();
                scrollThread = null;
            }
        }

        @Override
        public void run() {
            while (isScrolling) {
                xPos += 2;

                FontMetrics metrics = getFontMetrics(bannerFont);
                int messageWidth = metrics.stringWidth(message);
                if (xPos > getWidth()) {
                    xPos = -messageWidth;
                }

                repaint();

                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setFont(bannerFont);
            g2d.setColor(Color.YELLOW);

            g2d.drawString(message, xPos, yPos);
        }
    }
}
