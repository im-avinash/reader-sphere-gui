package com.readersphere.gui;

import javax.swing.*;
import java.awt.*;

public class MainContentPanel extends JPanel {
    private CardLayout cardLayout;

    public MainContentPanel(CardLayout cardLayout) {
        this.cardLayout = cardLayout;

        setLayout(cardLayout);

    }

    public void showView(String name) {
        cardLayout.show(this, name);
    }
}
