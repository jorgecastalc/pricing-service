package com.pricing.pricing_service.application.service;

import com.pricing.pricing_service.domain.model.Price;
import com.pricing.pricing_service.domain.repository.PriceRepository;
import com.pricing.pricing_service.infrastructure.exception.PriceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;


    public Price getApplicablePrice(Long productId, Long brandId,
                                    LocalDateTime applicationDate) {

        return priceRepository.findApplicablePrice(productId, brandId, applicationDate)
                .orElseThrow(
                        () -> new PriceException(productId, brandId, applicationDate.toString()));
    }
}
