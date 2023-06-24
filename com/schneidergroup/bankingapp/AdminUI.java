package com.schneidergroup.bankingapp;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

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
            new AdminUI();
        });
    }
}