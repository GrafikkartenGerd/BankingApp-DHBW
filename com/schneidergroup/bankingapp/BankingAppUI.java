package com.schneidergroup.bankingapp;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingAppUI extends JFrame {
    private JTextField nameField;
    private JTextField vornameField;
    private JTextField emailField;
    private JTextField telefonnummerField;
    private JTextField adresseField;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public BankingAppUI() {
        setTitle("Banking App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2, 10, 10)); // 8 rows, 2 columns, 10-pixel gap

        Color darkBlue = new Color(0, 0, 128);

        // Set flat dark look and feel
        FlatDarkLaf.install();

        // Change the default color theme
        UIManager.put("Component.arrowType", "chevron");
        UIManager.put("Button.arc", 999); // max rounded corners
        UIManager.put("Component.focusWidth", 1);
        UIManager.put("Button.background", darkBlue);
        UIManager.put("Button.foreground", Color.WHITE);

        createAndAddComponents();

        pack();
        setLocationRelativeTo(null); // Center the UI on the screen
        setVisible(true);
    }

    // Move the creation and adding of components to a separate method
    private void createAndAddComponents() {
        add(createFieldPanel("Name:", nameField = new JTextField(20)));
        add(createFieldPanel("Vorname:", vornameField = new JTextField(20)));
        add(createFieldPanel("Email:", emailField = new JTextField(20)));
        add(createFieldPanel("Telefonnummer:", telefonnummerField = new JTextField(20)));
        add(createFieldPanel("Adresse:", adresseField = new JTextField(20)));

        add(new JLabel("Benutzername:"));
        usernameField = new JTextField(20);
        add(usernameField);

        add(new JLabel("Passwort:"));
        passwordField = new JPasswordField(20);
        add(passwordField);

        add(createButton());
    }

    // Create a method that creates a panel for a label and a text field
    private JPanel createFieldPanel(String labelText, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.WHITE); // Set label color to white

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);

        return panel;
    }

    // Create a method that creates the button
    private JButton createButton() {
        JButton button = new JButton("Registrieren");

        button.addActionListener(e -> {
            String name = nameField.getText();
            String vorname = vornameField.getText();
            String email = emailField.getText();
            String telefonnummer = telefonnummerField.getText();
            String adresse = adresseField.getText();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            System.out.println("Registrieren: " + name + " " + vorname);
            System.out.println("Benutzername: " + username);
            System.out.println("Passwort: " + password);
        });

        return button;
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

        Color darkBlue = new Color(0, 0, 128);

        // Set flat dark look and feel
        FlatDarkLaf.install();

        // Change the default color theme
        UIManager.put("Component.arrowType", "chevron");
        UIManager.put("Button.arc", 999); // max rounded corners
        UIManager.put("Component.focusWidth", 1);
        UIManager.put("Button.background", darkBlue);
        UIManager.put("Button.foreground", Color.WHITE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
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
                    new BankingAppUI();
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
