package com.example.APJ2_Ass2_Chess.models;

import javax.swing.*;

public class MessageList extends JPanel {
    public MessageList() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }
    public void addMessage(String message) {
        JLabel lb = new JLabel();
        lb.setText(message);
        add(lb);
        validate();
    }
    public void appendTo(JPanel frame) {
        frame.add(new JScrollPane(this));
    }
}