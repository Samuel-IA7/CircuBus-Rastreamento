package com.example.projetojavafx.gui;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoogleMapsSwingApp extends JFrame {
    private JFXPanel jfxPanel;
    private JTextField latField;
    protected JTextField lngField;
    private JTextArea resultArea;

    public GoogleMapsSwingApp() {
        setTitle("Google Maps and Geocoding in Java Swing");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jfxPanel = new JFXPanel();
        latField = new JTextField(10);
        lngField = new JTextField(10);
        JButton geocodeButton = new JButton("Geocode");
        resultArea = new JTextArea(10, 40);

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Latitude:"));
        controlPanel.add(latField);
        controlPanel.add(new JLabel("Longitude:"));
        controlPanel.add(lngField);
        controlPanel.add(geocodeButton);

        add(jfxPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        geocodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                geocodeLocation();
            }
        });

        Platform.runLater(() -> initFX(jfxPanel));
    }

    private void initFX(JFXPanel jfxPanel) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://www.google.com/maps");

        jfxPanel.setScene(new Scene(webView));
    }

    private void geocodeLocation() {
        // Implemente a lógica de geocodificação aqui
    }

    public void displayGeocodingResults(String results) {
        resultArea.setText("Geocoding Result:\n" + results);
    }
}

