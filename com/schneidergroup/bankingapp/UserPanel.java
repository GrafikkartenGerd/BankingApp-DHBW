package com.schneidergroup.bankingapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel extends JFrame {
    private JTextField amountField;
    private JButton sendButton;
    private JButton receiveButton;
    private JLabel balanceLabel;

    private double balance = 1000.0; // Anfangssaldo

    public UserPanel() {
        setTitle("User Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10)); // 4 rows, 1 column, 10-pixel gap

        createAndAddComponents();

        pack();
        setLocationRelativeTo(null); // Zentrieren der UI auf dem Bildschirm
        setVisible(true);
    }

    private void createAndAddComponents() {
        balanceLabel = new JLabel("Balance: $" + balance);

        amountField = new JTextField(20);

        sendButton = new JButton("Send Money");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = amountField.getText();
                double amount = Double.parseDouble(amountStr);

                if (amount <= balance) {
                    balance -= amount;
                    balanceLabel.setText("Balance: $" + balance);
                    JOptionPane.showMessageDialog(UserPanel.this, "Money sent successfully!");
                } else {
                    JOptionPane.showMessageDialog(UserPanel.this, "Insufficient balance!", "Error", JOptionPane.ERROR_MESSAGE);
                }

                amountField.setText(""); // Leere das Textfeld
            }
        });

        receiveButton = new JButton("Receive Money");
        receiveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = amountField.getText();
                double amount = Double.parseDouble(amountStr);

                balance += amount;
                balanceLabel.setText("Balance: $" + balance);
                JOptionPane.showMessageDialog(UserPanel.this, "Money received successfully!");

                amountField.setText(""); // Leere das Textfeld
            }
        });

        JPanel balancePanel = new JPanel();
        balancePanel.add(balanceLabel);

        JPanel sendPanel = new JPanel();
        sendPanel.add(amountField);
        sendPanel.add(sendButton);

        JPanel receivePanel = new JPanel();
        receivePanel.add(amountField);
        receivePanel.add(receiveButton);

        add(balancePanel);
        add(sendPanel);
        add(receivePanel);
    }
}