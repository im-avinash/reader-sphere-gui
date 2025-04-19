package com.readersphere.gui.components;

import javax.swing.*;

import com.readersphere.gui.dialogs.*;
import com.readersphere.model.Book;

import java.awt.*;


public class BookCard extends JPanel {

    public BookCard(Book book) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(200, 250));

        JLabel titleLabel = new JLabel("<html><b>" + book.getTitle() + "</b></html>");
        JLabel authorLabel = new JLabel("<html><i>" + book.getAuthor() + "</i></html>");
        JLabel ratingLabel = new JLabel("⭐ " + book.getRating());

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        infoPanel.setBackground(Color.WHITE);
        infoPanel.add(titleLabel);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        infoPanel.add(authorLabel);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        infoPanel.add(ratingLabel);

        // Placeholder for book cover image
        JLabel imageLabel = new JLabel("📘", SwingConstants.CENTER);
        imageLabel.setFont(new Font("SansSerif", Font.PLAIN, 64));
        imageLabel.setPreferredSize(new Dimension(200, 100));

        add(imageLabel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);
        // Inside BookCard.java constructor, after creating the layout...
addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        SwingUtilities.invokeLater(() -> {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(BookCard.this);
            new BookDetailsDialog(topFrame, book).setVisible(true);
        });
    }
});

    }
}
