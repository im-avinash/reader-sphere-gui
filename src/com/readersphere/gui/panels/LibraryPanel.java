package com.readersphere.gui.panels;

import javax.swing.*;

import com.readersphere.gui.components.*;
import com.readersphere.model.*;

import java.awt.*;
import java.util.List;

public class LibraryPanel extends JPanel {

    public LibraryPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("📚 My Library", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Reading", createBookshelf(getMockBooks("reading")));
        tabbedPane.addTab("Want to Read", createBookshelf(getMockBooks("want")));
        tabbedPane.addTab("Finished", createBookshelf(getMockBooks("finished")));

        add(tabbedPane, BorderLayout.CENTER);
    }

    private JScrollPane createBookshelf(List<Book> books) {
        JPanel panel = new JPanel(new GridLayout(0, 3, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (Book book : books) {
            panel.add(new BookCard(book));
        }
        return new JScrollPane(panel);
    }

    private List<Book> getMockBooks(String type) {
        return switch (type) {
            case "reading" -> List.of(
                    new Book("The Hobbit", "J.R.R. Tolkien", 4.7),
                    new Book("Dune", "Frank Herbert", 4.5));
            case "want" -> List.of(
                    new Book("1984", "George Orwell", 4.6),
                    new Book("The Name of the Wind", "Patrick Rothfuss", 4.4));
            case "finished" -> List.of(
                    new Book("To Kill a Mockingbird", "Harper Lee", 4.8),
                    new Book("The Great Gatsby", "F. Scott Fitzgerald", 4.2));
            default -> List.of();
        };
    }
}
