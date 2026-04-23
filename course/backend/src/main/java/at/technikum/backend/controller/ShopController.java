package at.technikum.backend.controller;

import at.technikum.backend.dto.in.ReviewCreate;
import at.technikum.backend.dto.in.ShopCreate;
import at.technikum.backend.dto.out.ShopsPublic;
import at.technikum.backend.mapper.ShopMapper;
import at.technikum.backend.dto.out.ShopPublic;
import at.technikum.backend.entity.Shop;
import at.technikum.backend.service.ShopService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shops")
@AllArgsConstructor
public class ShopController {

    private final ShopMapper shopMapper;
    private final ShopService shopService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShopPublic create(@RequestBody @Valid ShopCreate shopIn) {
        Shop shop = shopService.create(shopIn);
        return shopMapper.toObject(shop);
    }

    @GetMapping
    public List<ShopsPublic> readAll() {
        return shopService.getAll().stream()
                .map(shopMapper::toListObject)
                .toList();
    }

    @GetMapping("/{id}")
    public ShopPublic read(@PathVariable UUID id) {
        Shop shop = shopService.get(id);
        return shopMapper.toObject(shop);
    }

    @PostMapping("/{id}/reviews")
    @ResponseStatus(HttpStatus.CREATED)
    public ShopPublic addReview(
            @PathVariable UUID id,
            @RequestBody @Valid ReviewCreate reviewIn
    ) {
        Shop shop = shopService.createReview(id, reviewIn);
        return shopMapper.toObject(shop);
    }
}
