package practical11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyEventDemo extends JFrame {
    private JTextArea statusArea;
    private JTextField inputField;

    public KeyEventDemo() {
        super("Key Event Demo");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel instructionLabel = new JLabel("Type in the text field below:", JLabel.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(instructionLabel, BorderLayout.NORTH);

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(inputField, BorderLayout.CENTER);

        statusArea = new JTextArea(10, 30);
        statusArea.setEditable(false);
        statusArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(statusArea);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                statusArea.append("Typed character is: " + e.getKeyChar() + "\n");
            }
        });

        add(mainPanel);

        inputField.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KeyEventDemo app = new KeyEventDemo();
            app.setVisible(true);
        });
    }
}
