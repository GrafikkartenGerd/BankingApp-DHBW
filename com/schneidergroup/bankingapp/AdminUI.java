package com.schneidergroup.bankingapp;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUI extends JFrame {
    private DefaultListModel<String> kundenListModel;
    private DefaultListModel<String> kontodatenListModel;
    private JList<String> kundenList;
    private JList<String> kontodatenList;

    public AdminUI() {
        setTitle("Admin Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));

        // Dummy-Daten für Kunden und Kontodaten
        kundenListModel = new DefaultListModel<>();
        kundenListModel.addElement("Kunde 1");
        kundenListModel.addElement("Kunde 2");
        kundenListModel.addElement("Kunde 3");

        kontodatenListModel = new DefaultListModel<>();
        kontodatenListModel.addElement("Kontodaten 1");
        kontodatenListModel.addElement("Kontodaten 2");
        kontodatenListModel.addElement("Kontodaten 3");

        kundenList = new JList<>(kundenListModel);
        kontodatenList = new JList<>(kontodatenListModel);

        kundenList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // Kontodaten aktualisieren, wenn ein Kunde ausgewählt wird
                int selectedIndex = kundenList.getSelectedIndex();
                if (selectedIndex >= 0 && selectedIndex < kontodatenListModel.getSize()) {
                    kontodatenList.setSelectedIndex(selectedIndex);
                }
            }
        });

        JScrollPane kundenScrollPane = new JScrollPane(kundenList);
        JScrollPane kontodatenScrollPane = new JScrollPane(kontodatenList);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(kundenScrollPane);
        panel.add(kontodatenScrollPane);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlatDarkLaf.install(); // Install FlatLaf look and feel
            showLoginWindow();
        });
    }
    private static void showLoginWindow() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(400, 250);
        loginFrame.setLayout(new BorderLayout());

        Color darkBlue = new Color(0,0,128);

        // Set flat dark look and feel
        FlatDarkLaf.install();

        // Change the default color theme
        UIManager.put("Component.arrowType", "chevron");
        UIManager.put("Button.arc", 999); // max rounded corners
        UIManager.put("Component.focusWidth", 1);
        UIManager.put("Button.background", darkBlue);
        UIManager.put("Button.foreground", Color.WHITE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel userLabel = new JLabel("Benutzername:");
        userLabel.setForeground(Color.WHITE);
        JLabel passwordLabel = new JLabel("Passwort:");
        passwordLabel.setForeground(Color.WHITE);
        JTextField userField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticateUser(username, password)) {
                    loginFrame.setVisible(false);
                    new AdminUI();
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Falscher Benutzername oder Passwort!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty label for placeholder
        panel.add(loginButton);

        loginFrame.add(panel, BorderLayout.CENTER);
        loginFrame.setLocationRelativeTo(null); // Center the login window
        loginFrame.setVisible(true);
    }

    private static boolean authenticateUser(String username, String password) {
        // Implement user authentication here
        return username.equals("admin") && password.equals("1234");
    }
}
