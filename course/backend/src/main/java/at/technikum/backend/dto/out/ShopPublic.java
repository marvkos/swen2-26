package at.technikum.backend.dto.out;

import lombok.Data;

import java.util.List;

@Data
public class ShopPublic {

    private String id;
    private String name;
    private String city;
    private String coordinates;
    private List<ReviewPublic> reviews;
}
