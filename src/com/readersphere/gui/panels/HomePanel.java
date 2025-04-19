package com.readersphere.gui.panels;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

  public HomePanel() {
    setLayout(new BorderLayout());
    JLabel welcomeLabel = new JLabel("Welcome to Reader Sphere!", SwingConstants.CENTER);
    welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
    add(welcomeLabel, BorderLayout.NORTH);

    // Placeholder for trending books and friend activity
    JPanel centerPanel = new JPanel(new GridLayout(1, 2));
    centerPanel.add(new JLabel("📚 Trending Books", SwingConstants.CENTER));
    centerPanel.add(new JLabel("👥 Friend Activity", SwingConstants.CENTER));
    add(centerPanel, BorderLayout.CENTER);
  }
}
