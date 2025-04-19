package com.readersphere.gui.components;

import javax.swing.*;

import com.readersphere.model.*;

import java.awt.*;

public class PostCard extends JPanel {

    public PostCard(Post post) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10),
            BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)
        ));
        setBackground(Color.WHITE);

        JLabel userLabel = new JLabel("<html><b>" + post.getUsername() + "</b></html>");
        JTextArea content = new JTextArea(post.getContent());
        content.setLineWrap(true);
        content.setWrapStyleWord(true);
        content.setEditable(false);
        content.setBackground(Color.WHITE);

        JPanel stats = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        stats.setBackground(Color.WHITE);
        stats.add(new JLabel("❤️ " + post.getLikes()));
        stats.add(new JLabel("💬 " + post.getComments()));

        add(userLabel, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);
        add(stats, BorderLayout.SOUTH);
    }
}
