package com.schneidergroup.bankingapp;

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

    public BankingAppUI() {
        setTitle("Banking App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10)); // 6 Zeilen, 2 Spalten, Abstand von 10 Pixeln

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        JPanel namePanel = new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        // Vorname
        JLabel vornameLabel = new JLabel("Vorname:");
        vornameField = new JTextField(20);
        JPanel vornamePanel = new JPanel();
        vornamePanel.add(vornameLabel);
        vornamePanel.add(vornameField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        JPanel emailPanel = new JPanel();
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);

        // Telefonnummer
        JLabel telefonnummerLabel = new JLabel("Telefonnummer:");
        telefonnummerField = new JTextField(20);
        JPanel telefonnummerPanel = new JPanel();
        telefonnummerPanel.add(telefonnummerLabel);
        telefonnummerPanel.add(telefonnummerField);

        // Adresse
        JLabel adresseLabel = new JLabel("Adresse:");
        adresseField = new JTextField(20);
        JPanel adressePanel = new JPanel();
        adressePanel.add(adresseLabel);
        adressePanel.add(adresseField);

        // Button
        JButton createButton = new JButton("Kunden erstellen");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hier kannst du den Code einfügen, um einen Kunden zu erstellen
                String name = nameField.getText();
                String vorname = vornameField.getText();
                String email = emailField.getText();
                String telefonnummer = telefonnummerField.getText();
                String adresse = adresseField.getText();

                // Hier kannst du den Kunden erstellen und weitere Aktionen ausführen
                // ...

                // Beispiel-Ausgabe zur Demonstration
                System.out.println("Kunde erstellt: " + name + " " + vorname);
            }
        });

        // UI-Komponenten zur UI hinzufügen
        add(namePanel);
        add(vornamePanel);
        add(emailPanel);
        add(telefonnummerPanel);
        add(adressePanel);
        add(createButton);

        pack();
        setLocationRelativeTo(null); // Zentrieren der UI auf dem Bildschirm
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showLoginWindow();
            }
        });
    }

    private static void showLoginWindow() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(400, 250);
        loginFrame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel userLabel = new JLabel("Benutzername:");
        JLabel passwordLabel = new JLabel("Passwort:");
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
                    JOptionPane.showMessageDialog(loginFrame, "Falscher Benutzername oder Passwort!");
                }
            }
        });

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Leeres Label für Platzhalter
        panel.add(loginButton);

        loginFrame.add(panel, BorderLayout.CENTER);
        loginFrame.setLocationRelativeTo(null); // Zentrieren des Login-Fensters
        loginFrame.setVisible(true);
    }

    private static boolean authenticateUser(String username, String password) {
        // Hier kannst du die Authentifizierung der Benutzer implementieren
        // Überprüfe, ob der Benutzername und das Passwort gültig sind
        // Rückgabe: true, wenn die Authentifizierung erfolgreich ist, ansonsten false
        // Beispiel:
        return username.equals("admin") && password.equals("1234");
    }
}
