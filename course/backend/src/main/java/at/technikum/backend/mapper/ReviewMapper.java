package at.technikum.backend.mapper;

import at.technikum.backend.dto.in.ReviewCreate;
import at.technikum.backend.dto.out.ReviewPublic;
import at.technikum.backend.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReviewMapper {
    Review toEntity(ReviewCreate reviewIn);
    ReviewPublic toObject(Review review);
}
