package com.readersphere.gui.panels;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ProfilePanel extends JPanel {

    public ProfilePanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("👤 Your Profile", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Profile info
        JPanel profileInfo = new JPanel(new BorderLayout());
        JLabel avatar = new JLabel("🧑", SwingConstants.CENTER);
        avatar.setFont(new Font("SansSerif", Font.PLAIN, 72));
        avatar.setPreferredSize(new Dimension(100, 100));

        JPanel userDetails = new JPanel();
        userDetails.setLayout(new BoxLayout(userDetails, BoxLayout.Y_AXIS));
        userDetails.add(new JLabel("<html><h2>John Doe</h2></html>"));
        userDetails.add(new JLabel("<html><i>“Book lover. Sci-fi nerd. Always reading.”</i></html>"));

        profileInfo.add(avatar, BorderLayout.WEST);
        profileInfo.add(userDetails, BorderLayout.CENTER);

        add(profileInfo, BorderLayout.CENTER);

        // Stats + Favorites
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        JLabel stats = new JLabel("📚 Books Read: 42     ✍️ Reviews: 18");
        stats.setFont(new Font("SansSerif", Font.PLAIN, 16));
        bottomPanel.add(stats);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel favoritesLabel = new JLabel("❤️ Favorite Books:");
        favoritesLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        bottomPanel.add(favoritesLabel);

        List<String> favorites = List.of("Dune", "Circe", "Atomic Habits");
        for (String book : favorites) {
            bottomPanel.add(new JLabel("• " + book));
        }

        add(bottomPanel, BorderLayout.SOUTH);
    }
}
