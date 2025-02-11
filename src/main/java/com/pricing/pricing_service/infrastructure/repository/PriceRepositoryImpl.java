package com.pricing.pricing_service.infrastructure.repository;

import com.pricing.pricing_service.domain.model.Price;
import com.pricing.pricing_service.domain.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceJpaRepository priceJpaRepository;
    
    @Override
    public List<Price> findApplicablePrices(Long productId, Long brandId, LocalDate date) {
        return List.of();
    }
}
