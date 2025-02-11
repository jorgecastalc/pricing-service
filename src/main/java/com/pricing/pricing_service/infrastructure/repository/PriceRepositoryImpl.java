package com.pricing.pricing_service.infrastructure.repository;

import com.pricing.pricing_service.domain.model.Price;
import com.pricing.pricing_service.domain.repository.PriceRepository;
import com.pricing.pricing_service.infrastructure.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceJpaRepository priceJpaRepository;
    private final PriceMapper priceMapper;

    @Override
    public List<Price> findApplicablePrices(Long productId, Long brandId,
                                            LocalDate applicationDate) {

        return priceMapper.toDomainList(
                priceJpaRepository.findApplicablePrices(productId, brandId, applicationDate));
    }
}
