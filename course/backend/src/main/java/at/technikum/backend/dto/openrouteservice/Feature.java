package at.technikum.backend.dto.openrouteservice;

import lombok.Data;

@Data
public class Feature {
    private String type;
    private Geometry geometry;
}
