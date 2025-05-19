package practical14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComprehensiveSwingDemo extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JTextArea outputArea;
    
    public ComprehensiveSwingDemo() {
        super("Comprehensive Swing Demo");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        tabbedPane = new JTabbedPane();
        
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        outputScrollPane.setBorder(BorderFactory.createTitledBorder("Output"));
        
        tabbedPane.addTab("Colors", createColorPanel());
        tabbedPane.addTab("Events", createEventPanel());
        tabbedPane.addTab("Information", createInfoPanel());
        tabbedPane.addTab("Banner", createBannerPanel());
        
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        mainPanel.add(outputScrollPane, BorderLayout.SOUTH);
        
        add(mainPanel);
        
        setJMenuBar(createMenuBar());
    }
    
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        
        JMenuItem clearItem = new JMenuItem("Clear Output", KeyEvent.VK_C);
        clearItem.addActionListener(e -> outputArea.setText(""));
        
        JMenuItem exitItem = new JMenuItem("Exit", KeyEvent.VK_X);
        exitItem.addActionListener(e -> System.exit(0));
        
        fileMenu.add(clearItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        
        JMenuItem aboutItem = new JMenuItem("About", KeyEvent.VK_A);
        aboutItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Comprehensive Swing Demo\nJava Practical Exercise 14\nVersion 1.0",
                "About", JOptionPane.INFORMATION_MESSAGE);
        });
        
        helpMenu.add(aboutItem);
        
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        
        return menuBar;
    }
    
    private JPanel createColorPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(Color.WHITE);
        colorPanel.setBorder(BorderFactory.createEtchedBorder());
        colorPanel.setPreferredSize(new Dimension(400, 200));
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        String[] colorNames = {"Red", "Green", "Blue", "Yellow", "Pink", "Cyan"};
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.PINK, Color.CYAN};
        
        for (int i = 0; i < colorNames.length; i++) {
            final int index = i;
            JButton button = new JButton(colorNames[i]);
            button.setBackground(colors[i]);
            button.setForeground(index < 3 ? Color.WHITE : Color.BLACK);
            
            button.addActionListener(e -> {
                colorPanel.setBackground(colors[index]);
                outputArea.append("Background color changed to " + colorNames[index] + "\n");
            });
            
            buttonPanel.add(button);
        }
        
        panel.add(colorPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createEventPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel eventArea = new JPanel();
        eventArea.setBorder(BorderFactory.createEtchedBorder());
        eventArea.setPreferredSize(new Dimension(400, 200));
        
        eventArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                outputArea.append("Mouse clicked at: (" + e.getX() + ", " + e.getY() + ")\n");
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                eventArea.setBackground(Color.LIGHT_GRAY);
                outputArea.append("Mouse entered the event area\n");
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                eventArea.setBackground(UIManager.getColor("Panel.background"));
                outputArea.append("Mouse exited the event area\n");
            }
        });
        
        JTextField keyField = new JTextField(20);
        keyField.setBorder(BorderFactory.createTitledBorder("Type here to test key events"));
        
        keyField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                outputArea.append("Key typed: " + e.getKeyChar() + "\n");
            }
        });
        
        panel.add(eventArea, BorderLayout.CENTER);
        panel.add(keyField, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createInfoPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JTextArea infoArea = new JTextArea();
        infoArea.setEditable(false);
        infoArea.setFont(new Font("Arial", Font.PLAIN, 14));
        infoArea.setBorder(BorderFactory.createEtchedBorder());
        JScrollPane scrollPane = new JScrollPane(infoArea);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        JButton personalButton = new JButton("Personal Info");
        personalButton.addActionListener(e -> {
            StringBuilder info = new StringBuilder();
            info.append("PERSONAL INFORMATION\n");
            info.append("====================\n\n");
            info.append("Name: John Doe\n");
            info.append("Course: B.Tech Computer Science\n");
            info.append("Roll No: CS2023001\n");
            info.append("College: ABC Institute of Technology\n");
            
            infoArea.setText(info.toString());
            outputArea.append("Displayed personal information\n");
        });
        
        JButton academicButton = new JButton("Academic Info");
        academicButton.addActionListener(e -> {
            StringBuilder info = new StringBuilder();
            info.append("ACADEMIC INFORMATION\n");
            info.append("====================\n\n");
            info.append("CGPA: 9.2\n");
            info.append("Semester: Fall 2024\n");
            info.append("Specialization: Artificial Intelligence\n");
            info.append("Projects Completed: 8\n");
            
            infoArea.setText(info.toString());
            outputArea.append("Displayed academic information\n");
        });
        
        buttonPanel.add(personalButton);
        buttonPanel.add(academicButton);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createBannerPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        ScrollingBanner banner = new ScrollingBanner("Welcome to the Comprehensive Swing Demo - Java Practical Exercise 14");
        
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            banner.startScrolling();
            outputArea.append("Banner scrolling started\n");
        });
        
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> {
            banner.stopScrolling();
            outputArea.append("Banner scrolling stopped\n");
        });
        
        JTextField messageField = new JTextField(20);
        messageField.setBorder(BorderFactory.createTitledBorder("New Message"));
        
        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> {
            String newMessage = messageField.getText().trim();
            if (!newMessage.isEmpty()) {
                banner.setMessage(newMessage);
                outputArea.append("Banner message updated\n");
            }
        });
        
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(messageField);
        controlPanel.add(updateButton);
        
        panel.add(banner, BorderLayout.CENTER);
        panel.add(controlPanel, BorderLayout.SOUTH);
        
        banner.startScrolling();
        
        return panel;
    }
    
    private class ScrollingBanner extends JPanel implements Runnable {
        private String message;
        private Thread scrollThread;
        private boolean isScrolling;
        private int xPos;
        private final Font bannerFont;
        
        public ScrollingBanner(String message) {
            this.message = message;
            this.isScrolling = false;
            this.xPos = getWidth();
            this.bannerFont = new Font("Arial", Font.BOLD, 20);
            
            setBackground(Color.BLACK);
            setPreferredSize(new Dimension(600, 100));
        }
        
        public void setMessage(String message) {
            this.message = message;
            repaint();
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
                xPos -= 2;
                
                FontMetrics metrics = getFontMetrics(bannerFont);
                int messageWidth = metrics.stringWidth(message);
                if (xPos < -messageWidth) {
                    xPos = getWidth();
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
            
            FontMetrics metrics = g2d.getFontMetrics();
            int textY = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
            
            g2d.drawString(message, xPos, textY);
        }
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            ComprehensiveSwingDemo app = new ComprehensiveSwingDemo();
            app.setVisible(true);
        });
    }
}
