package com.readersphere.gui.panels;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {

    public SettingsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel title = new JLabel("⚙️ Settings");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);
        add(Box.createRigidArea(new Dimension(0, 20)));

        // Account Info
        JPanel accountPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        accountPanel.setBorder(BorderFactory.createTitledBorder("Account Settings"));

        JTextField usernameField = new JTextField("JohnDoe");
        JTextField emailField = new JTextField("john@example.com");
        JPasswordField passwordField = new JPasswordField("password");

        accountPanel.add(new JLabel("Username:"));
        accountPanel.add(usernameField);
        accountPanel.add(new JLabel("Email:"));
        accountPanel.add(emailField);
        accountPanel.add(new JLabel("Password:"));
        accountPanel.add(passwordField);

        add(accountPanel);
        add(Box.createRigidArea(new Dimension(0, 20)));

        // Appearance
        JPanel appearancePanel = new JPanel();
        appearancePanel.setBorder(BorderFactory.createTitledBorder("Appearance"));
        JCheckBox darkModeCheck = new JCheckBox("Enable Dark Mode");
        appearancePanel.add(darkModeCheck);
        add(appearancePanel);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton saveButton = new JButton("💾 Save Changes");
        JButton logoutButton = new JButton("🚪 Log Out");

        saveButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Settings saved successfully!");
        });

        logoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Logged out.");
            // Hook here: switch back to login screen if you have one
        });

        buttonPanel.add(saveButton);
        buttonPanel.add(logoutButton);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(buttonPanel);
    }
}
