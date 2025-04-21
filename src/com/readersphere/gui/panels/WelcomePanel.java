package com.readersphere.gui.panels;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.readersphere.ReaderSphereFrame;

public class WelcomePanel extends JPanel {
  public WelcomePanel(ReaderSphereFrame frame) {
    setLayout(new BorderLayout());

    JLabel label = new JLabel("Welcome to BookConnect", SwingConstants.CENTER);
    label.setFont(new Font("Arial", Font.BOLD, 22));

    JButton loginBtn = new JButton("Login");
    JButton signupBtn = new JButton("Sign Up");

    JPanel buttons = new JPanel();
    buttons.add(loginBtn);
    buttons.add(signupBtn);

    add(label, BorderLayout.NORTH);
    add(buttons, BorderLayout.CENTER);

    loginBtn.addActionListener(e -> frame.showPanel("Login"));
    signupBtn.addActionListener(e -> frame.showPanel("Signup"));
  }
}
