package com.readersphere.gui.panels;

import javax.swing.*;

import com.readersphere.gui.components.*;
import com.readersphere.model.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CommunityPanel extends JPanel {

    private JPanel feedPanel;

    public CommunityPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("👥 BookConnect Community", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // New post section
        JPanel postBox = new JPanel(new BorderLayout());
        JTextField postInput = new JTextField();
        JButton postButton = new JButton("✍️ Post");
        postBox.add(postInput, BorderLayout.CENTER);
        postBox.add(postButton, BorderLayout.EAST);
        postBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(postBox, BorderLayout.SOUTH);

        // Feed
        feedPanel = new JPanel();
        feedPanel.setLayout(new BoxLayout(feedPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(feedPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        // Mock posts
        List<Post> mockPosts = getMockPosts();
        for (Post post : mockPosts) {
            feedPanel.add(new PostCard(post));
        }

        // Add new post action
        postButton.addActionListener(e -> {
            String content = postInput.getText().trim();
            if (!content.isEmpty()) {
                Post newPost = new Post("You", content, 0, 0);
                feedPanel.add(new PostCard(newPost), 0);
                postInput.setText("");
                feedPanel.revalidate();
                feedPanel.repaint();
            }
        });
    }

    private List<Post> getMockPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Alice", "Just finished *Circe* — magical!", 12, 4));
        posts.add(new Post("Ben", "Anyone read *Project Hail Mary*? Thoughts?", 5, 2));
        posts.add(new Post("Clara", "*Dune* blew my mind. Spice must flow!", 8, 3));
        return posts;
    }
}
