package com.readersphere.controller;

import javax.swing.*;
import java.awt.*;

import java.util.HashMap;
import java.util.Map;

public class NavigationController {
    private final JPanel mainContentPanel;
    private final CardLayout cardLayout;
    private final Map<String, JPanel> viewMap;

    public NavigationController(JPanel mainContentPanel, CardLayout cardLayout) {
        this.mainContentPanel = mainContentPanel;
        this.cardLayout = cardLayout;
        this.viewMap = new HashMap<>();
    }

    public void registerPanel(String name, JPanel panel) {
        viewMap.put(name, panel);
        mainContentPanel.add(panel, name);
    }

    public void showPanel(String name) {
        if (viewMap.containsKey(name)) {
            cardLayout.show(mainContentPanel, name);
        } else {
            System.err.println("Panel not found: " + name);
        }
    }

    public JPanel getPanel(String name) {
        return viewMap.get(name);
    }
}
