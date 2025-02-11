package com.pricing.pricing_service.domain.repository;

import com.pricing.pricing_service.domain.model.Price;

import java.time.LocalDate;
import java.util.List;

public interface PriceRepository {

    List<Price> findApplicablePrices(Long productId, Long brandId, LocalDate date);
}
