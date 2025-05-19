package practical12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InfoButtonsDemo extends JFrame {
    private JTextArea infoArea;

    public InfoButtonsDemo() {
        super("Information Display Demo");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel instructionLabel = new JLabel("Click a button to display information", JLabel.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(instructionLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JButton buttonA = new JButton("A");
        buttonA.setFont(new Font("Arial", Font.BOLD, 14));
        buttonA.setPreferredSize(new Dimension(80, 40));
        buttonA.setToolTipText("Display Personal Information");

        JButton buttonB = new JButton("B");
        buttonB.setFont(new Font("Arial", Font.BOLD, 14));
        buttonB.setPreferredSize(new Dimension(80, 40));
        buttonB.setToolTipText("Display CGPA Information");

        infoArea = new JTextArea(10, 30);
        infoArea.setEditable(false);
        infoArea.setFont(new Font("Arial", Font.PLAIN, 14));
        infoArea.setBorder(BorderFactory.createEtchedBorder());
        JScrollPane scrollPane = new JScrollPane(infoArea);

        buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPersonalInfo();
            }
        });

        buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayCGPAInfo();
            }
        });

        buttonPanel.add(buttonA);
        buttonPanel.add(buttonB);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void displayPersonalInfo() {
        StringBuilder info = new StringBuilder();
        info.append("PERSONAL INFORMATION\n");
        info.append("====================\n\n");
        info.append("Name: John Doe\n");
        info.append("Course: B.Tech Computer Science\n");
        info.append("Roll No: CS2023001\n");
        info.append("College: ABC Institute of Technology\n");

        infoArea.setText(info.toString());
    }

    private void displayCGPAInfo() {
        StringBuilder info = new StringBuilder();
        info.append("CGPA INFORMATION\n");
        info.append("================\n\n");
        info.append("Previous Semester CGPA: 9.2\n");
        info.append("Semester: Fall 2024\n");

        infoArea.setText(info.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InfoButtonsDemo app = new InfoButtonsDemo();
            app.setVisible(true);
        });
    }
}
