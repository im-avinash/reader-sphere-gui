package com.readersphere.gui.dialogs;

import javax.swing.*;

import com.readersphere.model.*;

import java.awt.*;

public class BookDetailsDialog extends JDialog {

    public BookDetailsDialog(JFrame parent, Book book) {
        super(parent, "📖 " + book.getTitle(), true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("<html><h2>" + book.getTitle() + "</h2></html>");
        JLabel authorLabel = new JLabel("<html><i>" + book.getAuthor() + "</i></html>");
        JLabel ratingLabel = new JLabel("⭐ " + book.getRating());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        topPanel.add(titleLabel);
        topPanel.add(authorLabel);
        topPanel.add(ratingLabel);

        // Description placeholder
        JTextArea description = new JTextArea("This is a mock description for the book.\n\n" +
                "In the real version, you'd fetch this from your backend or a book API.");
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        description.setEditable(false);
        description.setBorder(BorderFactory.createTitledBorder("Description"));

        // Action buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(new JButton("📥 Add to Library"));
        buttonPanel.add(new JButton("✍️ Write Review"));
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        buttonPanel.add(closeButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(description), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        JButton reviewButton = new JButton("✍️ Write Review");
        reviewButton.addActionListener(e -> {
            new AddReviewDialog((JFrame) SwingUtilities.getWindowAncestor(this), book).setVisible(true);
        });
        buttonPanel.add(reviewButton);

    }
}
