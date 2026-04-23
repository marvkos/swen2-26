package at.technikum.backend.dto.in;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReviewCreate {

    @NotBlank
    private String text;

    @Min(1)
    @Max(10)
    private int rating;
}
