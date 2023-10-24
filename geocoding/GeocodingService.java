package com.example.projetojavafx.geocoding;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import java.io.IOException;

public class GeocodingService {
    public GeoApiContext context;

    public GeocodingService(String apiKey) {
        context = new GeoApiContext.Builder().apiKey(apiKey).build();
    }

    public String geocodeLocation(double lat, double lng) {
        LatLng latLng = new LatLng(lat, lng);
        try {
            GeocodingResult[] results = GeocodingApi.newRequest(context)
                    .latlng(latLng)
                    .await();

            StringBuilder resultStringBuilder = new StringBuilder();
            for (GeocodingResult result : results) {
                resultStringBuilder.append(result.formattedAddress).append("\n");
            }
            return resultStringBuilder.toString();
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
            return "Erro na chamada da API: " + e.getMessage();
        }
    }
}

