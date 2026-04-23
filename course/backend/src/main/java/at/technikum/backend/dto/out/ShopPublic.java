package at.technikum.backend.dto.out;

import lombok.Data;

import java.util.List;

@Data
public class ShopPublic {

    private String id;
    private String name;
    private List<ReviewPublic> reviews;
}
