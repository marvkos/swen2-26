package at.technikum.backend.mapper;

import at.technikum.backend.dto.in.ShopCreate;
import at.technikum.backend.dto.out.ShopPublic;
import at.technikum.backend.dto.out.ShopsPublic;
import at.technikum.backend.entity.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ShopMapper {
    Shop toEntity(ShopCreate shopIn);
    ShopsPublic toListObject(Shop shop);
    ShopPublic toObject(Shop shop);
}
