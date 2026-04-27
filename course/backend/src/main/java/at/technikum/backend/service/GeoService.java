package at.technikum.backend.service;

import at.technikum.backend.dto.openrouteservice.GeocodeSearchResponse;
import at.technikum.backend.dto.openrouteservice.Geometry;
import at.technikum.backend.dto.service.Coordinates;
import at.technikum.backend.service.client.OpenRouteServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeoService {

    private final String openRouteServiceApiKey;
    private final OpenRouteServiceClient openRouteServiceClient;

    public GeoService(
            @Value("${openrouteservice.api-key}") String openRouteServiceApiKey,
            OpenRouteServiceClient openRouteServiceClient
    ) {
        this.openRouteServiceApiKey = openRouteServiceApiKey;
        this.openRouteServiceClient = openRouteServiceClient;
    }

    public Optional<Coordinates> findCoordinates(String query) {
        GeocodeSearchResponse geocodeSearchResponse = openRouteServiceClient.geocodeSearch(openRouteServiceApiKey, query);

        if (geocodeSearchResponse.getFeatures().isEmpty()) {
            return Optional.empty();
        }

        Geometry geometry = geocodeSearchResponse.getFeatures().getFirst().getGeometry();
        Coordinates coordinates = new Coordinates(
                geometry.getCoordinates().getLast(),
                geometry.getCoordinates().getFirst()
        );

        return Optional.of(coordinates);
    }
}
