package com.pricing.pricing_service.domain.repository;

import com.pricing.pricing_service.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {

    Optional<Price> findApplicablePrice(Long productId, Long brandId,
                                        LocalDateTime applicationDate);
}
