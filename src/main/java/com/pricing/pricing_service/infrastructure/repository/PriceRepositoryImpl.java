package com.pricing.pricing_service.infrastructure.repository;

import com.pricing.pricing_service.domain.model.Price;
import com.pricing.pricing_service.domain.repository.PriceRepository;
import com.pricing.pricing_service.infrastructure.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceJpaRepository priceJpaRepository;
    private final PriceMapper priceMapper;

    @Override
    public Optional<Price> findApplicablePrice(Long productId, Long brandId,
                                               LocalDateTime applicationDate) {

        return priceJpaRepository.findApplicablePrice(productId, brandId, applicationDate)
                .map(priceMapper::toDomain);
    }
}
