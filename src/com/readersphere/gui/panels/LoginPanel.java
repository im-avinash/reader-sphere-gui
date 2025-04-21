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

public class LoginPanel extends JPanel {
  public LoginPanel(ReaderSphereFrame frame, UserController userController) {
      setLayout(new GridLayout(3, 2, 10, 10));
      JTextField username = new JTextField();
      JPasswordField password = new JPasswordField();
      JButton loginBtn = new JButton("Login");

      add(new JLabel("Username:")); add(username);
      add(new JLabel("Password:")); add(password);
      add(new JLabel("")); add(loginBtn);

      loginBtn.addActionListener(e -> {
          if (userController.login(username.getText(), new String(password.getPassword()))) {
              frame.launchMainApp(); // Show main app
          } else {
              JOptionPane.showMessageDialog(this, "Invalid login");
          }
      });
  }
}
