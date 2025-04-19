package com.readersphere;


import javax.swing.*;
import java.awt.*;

import com.readersphere.controller.NavigationController;
import com.readersphere.gui.MainContentPanel;
import com.readersphere.gui.NavigationPanel;
import com.readersphere.gui.panels.CommunityPanel;
import com.readersphere.gui.panels.DiscoverPanel;
import com.readersphere.gui.panels.HomePanel;
import com.readersphere.gui.panels.LibraryPanel;
import com.readersphere.gui.panels.ProfilePanel;
import com.readersphere.gui.panels.SettingsPanel;

public class ReaderSphereMainFrame extends JFrame {

    private NavigationPanel navigationPanel;
    private MainContentPanel mainContentPanel;
    private NavigationController navigation;

    public ReaderSphereMainFrame() {
        setTitle("ReaderSphere");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        CardLayout layout = new CardLayout();
        navigationPanel = new NavigationPanel(this);
        mainContentPanel = new MainContentPanel();

        // Set up NavigationController
        navigation = new NavigationController(mainContentPanel, layout);

        // Register views (you can swap out with your real panel classes)
        navigation.registerPanel("Home", new HomePanel());
        navigation.registerPanel("Profile", new ProfilePanel());
        navigation.registerPanel("Library", new LibraryPanel());
        navigation.registerPanel("Community", new CommunityPanel());
        navigation.registerPanel("Discover", new DiscoverPanel());
        navigation.registerPanel("Settings", new SettingsPanel());

        // Add the main content area to the center of the JFrame
        add(navigationPanel, BorderLayout.NORTH); // or BorderLayout.WEST for sidebar
        add(mainContentPanel, BorderLayout.CENTER);
    }

    public void switchView(String viewName) {
        mainContentPanel.showView(viewName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReaderSphereMainFrame frame = new ReaderSphereMainFrame();
            frame.setVisible(true);
        });
    }
}
