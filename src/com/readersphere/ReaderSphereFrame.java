package com.readersphere;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.readersphere.controller.UserController;
import com.readersphere.gui.ReaderSphereMainPanel;
import com.readersphere.gui.panels.LoginPanel;
import com.readersphere.gui.panels.SignupPanel;
import com.readersphere.gui.panels.WelcomePanel;

public class ReaderSphereFrame extends JFrame {
    private final CardLayout layout = new CardLayout();
    private final JPanel mainContentPanel = new JPanel(layout);
    private final UserController userController = new UserController();

    public ReaderSphereFrame() {
        setTitle("📚 BookConnect");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panels
        WelcomePanel welcomePanel = new WelcomePanel(this);
        LoginPanel loginPanel = new LoginPanel(this, userController);
        SignupPanel signupPanel = new SignupPanel(this, userController);
        ReaderSphereMainPanel readerSphereMainPanel = new ReaderSphereMainPanel(this, userController);

        // Register with CardLayout
        mainContentPanel.add(welcomePanel, "Welcome");
        mainContentPanel.add(loginPanel, "Login");
        mainContentPanel.add(signupPanel, "Signup");
        mainContentPanel.add(readerSphereMainPanel, "ReaderSphereMainPanel");

        add(mainContentPanel, BorderLayout.CENTER);

        layout.show(mainContentPanel, "Welcome");
    }

    // Called by children to switch views
    public void showPanel(String name) {
        layout.show(mainContentPanel, name);
    }

    public void launchMainApp() {
        showPanel("ReaderSphereMainPanel");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReaderSphereFrame mainFrame = new ReaderSphereFrame();
            mainFrame.setVisible(true);
        });
    }
}
