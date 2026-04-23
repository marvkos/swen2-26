package at.technikum.backend.dto.out;

import lombok.Data;

@Data
public class ReviewPublic {

    private String id;
    private String text;
    private int rating;
}
