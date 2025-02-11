package com.pricing.pricing_service.infrastructure.controller;

import com.pricing.pricing_service.application.service.PriceService;
import com.pricing.pricing_service.domain.model.Price;
import com.pricing.pricing_service.infrastructure.controller.dto.PriceResponse;
import com.pricing.pricing_service.infrastructure.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;
    private final PriceMapper priceMapper;

    @GetMapping
    public ResponseEntity<PriceResponse> getPrice(@RequestParam Long productId,
                                                  @RequestParam Long brandId,
                                                  @RequestParam @DateTimeFormat(
                                                          iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {

        Price applicablePrice = priceService.getApplicablePrice(productId, brandId,
                applicationDate);
        return ResponseEntity.ok(priceMapper.toResponse(applicablePrice));

    }
}
