package com.readersphere.gui.panels;

import javax.swing.*;

import com.readersphere.model.*;

import java.awt.*;

public class BookDetailsDialog extends JDialog {

    public BookDetailsDialog(JFrame parent, Book book) {
        super(parent, "📖 Book Details", true);
        setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(parent);

        JLabel titleLabel = new JLabel("<html><h2>" + book.getTitle() + "</h2></html>", SwingConstants.CENTER);
        JLabel authorLabel = new JLabel("<html><i>" + book.getAuthor() + "</i></html>", SwingConstants.CENTER);
        JLabel ratingLabel = new JLabel("⭐ Rating: " + book.getRating(), SwingConstants.CENTER);

        JTextArea descriptionArea = new JTextArea("This is a placeholder for the book's description.");
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dispose());

        JPanel footer = new JPanel();
        footer.add(closeBtn);

        add(titleLabel, BorderLayout.NORTH);
        add(authorLabel, BorderLayout.BEFORE_FIRST_LINE);
        add(scrollPane, BorderLayout.CENTER);
        add(ratingLabel, BorderLayout.SOUTH);
        add(footer, BorderLayout.PAGE_END);
    }
}
