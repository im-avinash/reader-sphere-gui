package com.readersphere.gui.dialogs;

import javax.swing.*;

import com.readersphere.model.*;

import java.awt.*;

public class AddReviewDialog extends JDialog {

    public AddReviewDialog(JFrame parent, Book book) {
        super(parent, "✍️ Review: " + book.getTitle(), true);
        setSize(450, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // Title
        JLabel heading = new JLabel("Write a Review for \"" + book.getTitle() + "\"", SwingConstants.CENTER);
        heading.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        // Review panel
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        // Rating stars
        JPanel ratingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel ratingLabel = new JLabel("⭐ Rating:");
        JComboBox<Integer> ratingDropdown = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        ratingDropdown.setSelectedIndex(4);
        ratingPanel.add(ratingLabel);
        ratingPanel.add(ratingDropdown);
        centerPanel.add(ratingPanel, BorderLayout.NORTH);

        // Review text
        JTextArea reviewArea = new JTextArea(6, 30);
        reviewArea.setWrapStyleWord(true);
        reviewArea.setLineWrap(true);
        JScrollPane reviewScroll = new JScrollPane(reviewArea);
        centerPanel.add(reviewScroll, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton submitButton = new JButton("✅ Submit");
        JButton cancelButton = new JButton("❌ Cancel");

        submitButton.addActionListener(e -> {
            String review = reviewArea.getText().trim();
            int rating = (int) ratingDropdown.getSelectedItem();

            if (review.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please write a review before submitting.");
                return;
            }

            // You can now save review/rating to your backend or local list
            JOptionPane.showMessageDialog(this, "Thanks for your review!");
            dispose();
        });

        cancelButton.addActionListener(e -> dispose());

        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
