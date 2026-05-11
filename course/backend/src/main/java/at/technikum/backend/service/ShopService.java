package at.technikum.backend.service;

import at.technikum.backend.dto.in.ReviewCreate;
import at.technikum.backend.dto.in.ShopCreate;
import at.technikum.backend.dto.service.Coordinates;
import at.technikum.backend.entity.Review;
import at.technikum.backend.exception.EntityNotFoundException;
import at.technikum.backend.mapper.ReviewMapper;
import at.technikum.backend.mapper.ShopMapper;
import at.technikum.backend.entity.Shop;
import at.technikum.backend.repository.ShopRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ShopService {

    private final ShopMapper shopMapper;
    private final ReviewMapper reviewMapper;
    private final ShopRepository shopRepository;
    private final GeoService geoService;

    public Shop create(ShopCreate shopIn) {
        Shop shop = shopMapper.toEntity(shopIn);
        Coordinates coordinates = geoService.findCoordinates(shop.getCity())
                .orElseThrow(IllegalArgumentException::new);
        shop.setCoordinates(coordinates.toString());
        return shopRepository.save(shop);
    }

    public List<Shop> getAll() {
        return shopRepository.findAll();
    }

    public Shop get(UUID id) {
        return shopRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Shop createReview(UUID id, ReviewCreate reviewIn) {
        Shop shop = get(id);
        Review review = reviewMapper.toEntity(reviewIn);
        shop.addReview(review);

        return shopRepository.save(shop);
    }
}
