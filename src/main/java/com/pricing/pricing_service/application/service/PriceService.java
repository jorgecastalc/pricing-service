package com.pricing.pricing_service.application.service;

import com.pricing.pricing_service.domain.model.Price;
import com.pricing.pricing_service.domain.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;


    public Optional<Price> getApplicablePrice(Long productId, Long brandId,
                                              LocalDate applicationDate) {

        List<Price> pricesList = priceRepository.findApplicablePrices(productId, brandId,
                applicationDate);

        return pricesList.stream().findFirst();
    }
}
