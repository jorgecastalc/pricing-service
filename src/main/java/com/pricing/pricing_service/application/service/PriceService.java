package com.pricing.pricing_service.application.service;

import com.pricing.pricing_service.domain.model.Price;
import com.pricing.pricing_service.domain.repository.PriceRepository;
import com.pricing.pricing_service.infrastructure.exception.PriceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;


    public Price getApplicablePrice(Long productId, Long brandId,
                                    LocalDateTime applicationDate) {

        List<Price> pricesList = priceRepository.findApplicablePrices(productId, brandId,
                applicationDate);

        return pricesList.stream().findFirst()
                .orElseThrow(
                        () -> new PriceException(productId, brandId, applicationDate.toString()));
    }
}
