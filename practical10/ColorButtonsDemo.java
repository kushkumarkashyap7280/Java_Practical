package practical10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorButtonsDemo extends JFrame {
    private JPanel mainPanel;

    public ColorButtonsDemo() {
        super("Color Buttons Demo");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BorderLayout());

        JLabel instructionLabel = new JLabel("Click a button to change the background color", JLabel.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(instructionLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JButton redButton = new JButton("Red");
        redButton.setFont(new Font("Arial", Font.BOLD, 14));
        redButton.setBackground(Color.RED);
        redButton.setForeground(Color.WHITE);
        redButton.setFocusPainted(false);

        JButton blueButton = new JButton("Blue");
        blueButton.setFont(new Font("Arial", Font.BOLD, 14));
        blueButton.setBackground(Color.BLUE);
        blueButton.setForeground(Color.WHITE);
        blueButton.setFocusPainted(false);

        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setBackground(Color.RED);
            }
        });

        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setBackground(Color.BLUE);
            }
        });

        buttonPanel.add(redButton);
        buttonPanel.add(blueButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ColorButtonsDemo app = new ColorButtonsDemo();
            app.setVisible(true);
        });
    }
}
