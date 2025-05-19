package practical9;

import javax.swing.*;
import java.awt.*;

public class PinkBackgroundFrame extends JFrame {

    public PinkBackgroundFrame() {
        super("Pink Background Demo");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel("Hello, this is a frame with a pink background!", JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 18));
        messageLabel.setForeground(Color.DARK_GRAY);

        panel.add(messageLabel, BorderLayout.CENTER);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PinkBackgroundFrame app = new PinkBackgroundFrame();
            app.setVisible(true);
        });
    }
}
