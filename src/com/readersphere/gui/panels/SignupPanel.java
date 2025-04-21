package com.readersphere.gui.panels;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.readersphere.ReaderSphereFrame;
import com.readersphere.controller.UserController;

public class SignupPanel extends JPanel {
  public SignupPanel(ReaderSphereFrame frame, UserController userController) {
      setLayout(new GridLayout(4, 2, 10, 10));
      JTextField username = new JTextField();
      JTextField email = new JTextField();
      JPasswordField password = new JPasswordField();
      JButton signupBtn = new JButton("Sign Up");

      add(new JLabel("Username:")); add(username);
      add(new JLabel("Email:")); add(email);
      add(new JLabel("Password:")); add(password);
      add(new JLabel("")); add(signupBtn);

      signupBtn.addActionListener(e -> {
          if (userController.register(username.getText(), email.getText(), new String(password.getPassword()))) {
              JOptionPane.showMessageDialog(this, "Registered successfully!");
              frame.launchMainApp(); // Go to main app
          } else {
              JOptionPane.showMessageDialog(this, "Username taken.");
          }
      });
  }
}
