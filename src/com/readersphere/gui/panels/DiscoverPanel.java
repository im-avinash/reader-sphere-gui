package com.readersphere.gui.panels;

import javax.swing.*;

import com.readersphere.gui.components.*;
import com.readersphere.model.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DiscoverPanel extends JPanel {

    private JPanel booksPanel;

    public DiscoverPanel() {
        setLayout(new BorderLayout());

        // Top Search + Filters Bar
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topBar.add(new JLabel("🔍 Search:"));
        topBar.add(new JTextField(20));
        topBar.add(new JLabel("Genre:"));
        String[] genres = {"All", "Fiction", "Non-fiction", "Fantasy", "Sci-fi", "Romance"};
        topBar.add(new JComboBox<>(genres));

        add(topBar, BorderLayout.NORTH);

        // Scrollable Book Cards Area
        booksPanel = new JPanel();
        booksPanel.setLayout(new GridLayout(0, 3, 15, 15)); // 3 columns
        JScrollPane scrollPane = new JScrollPane(booksPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        // Mock data
        List<Book> mockBooks = getMockBooks();
        for (Book book : mockBooks) {
            booksPanel.add(new BookCard(book));
        }
    }

    private List<Book> getMockBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Midnight Library", "Matt Haig", 4.3));
        books.add(new Book("Project Hail Mary", "Andy Weir", 4.5));
        books.add(new Book("Where the Crawdads Sing", "Delia Owens", 4.4));
        books.add(new Book("Atomic Habits", "James Clear", 4.6));
        books.add(new Book("Circe", "Madeline Miller", 4.3));
        books.add(new Book("The Silent Patient", "Alex Michaelides", 4.2));
        return books;
    }
}
