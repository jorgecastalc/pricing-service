package com.pricing.pricing_service.infrastructure.mapper;

import com.pricing.pricing_service.domain.model.Price;
import com.pricing.pricing_service.infrastructure.controller.dto.PriceResponse;
import com.pricing.pricing_service.infrastructure.entity.PriceJpaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    List<Price> toDomainList(List<PriceJpaEntity> priceJpaEntities);

    PriceResponse toResponse(Price price);

}
