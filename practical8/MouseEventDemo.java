package practical8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends JFrame {
    private JPanel mainPanel;
    private JLabel statusLabel;
    private JFrame childFrame;

    public MouseEventDemo() {
        super("Mouse Event Demo");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setLayout(new BorderLayout());

        statusLabel = new JLabel("Move your mouse over this panel", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(statusLabel, BorderLayout.CENTER);

        childFrame = new JFrame("Child Frame");
        childFrame.setSize(300, 200);
        childFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        childFrame.setLocationRelativeTo(this);

        JLabel childLabel = new JLabel("This is the child frame", JLabel.CENTER);
        childLabel.setFont(new Font("Arial", Font.BOLD, 14));
        childFrame.add(childLabel);

        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                statusLabel.setText("Mouse Clicked at: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                statusLabel.setText("Mouse Entered the panel");
                childFrame.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                statusLabel.setText("Mouse Exited the panel");
                childFrame.setVisible(false);
            }
        });

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MouseEventDemo app = new MouseEventDemo();
            app.setVisible(true);
        });
    }
}
