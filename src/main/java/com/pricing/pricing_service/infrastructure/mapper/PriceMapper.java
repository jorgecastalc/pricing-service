package com.pricing.pricing_service.infrastructure.mapper;

import com.pricing.pricing_service.domain.model.Price;
import com.pricing.pricing_service.infrastructure.controller.dto.PriceResponse;
import com.pricing.pricing_service.infrastructure.entity.PriceJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    Price toDomain(PriceJpaEntity priceJpaEntity);

    PriceResponse toResponse(Price price);

}
