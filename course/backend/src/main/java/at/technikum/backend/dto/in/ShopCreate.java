package at.technikum.backend.dto.in;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ShopCreate {

    @NotBlank
    private String name;
}
