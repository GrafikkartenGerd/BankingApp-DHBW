package java.bankingapp;
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
        setLayout(new FlowLayout());

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        // Vorname
        JLabel vornameLabel = new JLabel("Vorname:");
        vornameField = new JTextField(20);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        // Telefonnummer
        JLabel telefonnummerLabel = new JLabel("Telefonnummer:");
        telefonnummerField = new JTextField(20);

        // Adresse
        JLabel adresseLabel = new JLabel("Adresse:");
        adresseField = new JTextField(20);

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
        add(nameLabel);
        add(nameField);
        add(vornameLabel);
        add(vornameField);
        add(emailLabel);
        add(emailField);
        add(telefonnummerLabel);
        add(telefonnummerField);
        add(adresseLabel);
        add(adresseField);
        add(createButton);

        pack();
        setLocationRelativeTo(null); // Zentrieren der UI auf dem Bildschirm
        setVisible(true);
    }
}
