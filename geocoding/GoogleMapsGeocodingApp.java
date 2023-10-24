package com.example.projetojavafx.geocoding;

import com.example.projetojavafx.gui.GoogleMapsSwingApp;

import javax.swing.*;
import java.awt.*;

public class GoogleMapsGeocodingApp extends GoogleMapsSwingApp {
    private GeocodingService geocodingService;

    public GoogleMapsGeocodingApp(String apiKey) {
        super();
        geocodingService = new GeocodingService(apiKey);
    }

    //@Override
    private void geocodeLocation() {
        Label latField = null;
        double lat = Double.parseDouble(latField.getText());
        double lng = Double.parseDouble(lngField.getText());
        String results = geocodingService.geocodeLocation(lat, lng);
        displayGeocodingResults(results);
    }

    public static void main(String[] args) {
        String apiKey = "AIzaSyDHLQb21-KyzHGYhWZuMlJBi1nAZUvMSLo"; // Substitua pela sua chave de API válida

        SwingUtilities.invokeLater(() -> {
            GoogleMapsGeocodingApp app = new GoogleMapsGeocodingApp(apiKey);
            app.setVisible(true);
        });
    }
}

