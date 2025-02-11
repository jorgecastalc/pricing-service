package com.pricing.pricing_service.infrastructure.mapper;

import com.pricing.pricing_service.domain.model.Price;
import com.pricing.pricing_service.infrastructure.controller.dto.PriceResponse;
import com.pricing.pricing_service.infrastructure.entity.PriceJpaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    Price toDomain(PriceJpaEntity priceJpaEntity);

    PriceJpaEntity toEntity(Price price);

    List<Price> toDomainList(List<PriceJpaEntity> priceJpaEntities);

    List<PriceJpaEntity> toEntityList(List<Price> prices);

    PriceResponse toResponse(Price price);

}
