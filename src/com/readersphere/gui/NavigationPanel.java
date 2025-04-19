package com.readersphere.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.readersphere.ReaderSphereMainFrame;

public class NavigationPanel extends JPanel{
  public NavigationPanel(ReaderSphereMainFrame parentFrame) {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        setBackground(new Color(230, 230, 250)); // light lavender

        
        String[] views = {"Home", "Discover", "Library", "Community", "Profile","Settings"};
        for (String view : views) {
            JButton btn = new JButton(view);
            btn.addActionListener(event -> parentFrame.switchView(view));
            add(btn);
        }
    }
}
