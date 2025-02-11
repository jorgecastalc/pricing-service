package com.pricing.pricing_service.infrastructure.config;

import com.pricing.pricing_service.infrastructure.entity.PriceJpaEntity;
import com.pricing.pricing_service.infrastructure.repository.PriceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final PriceJpaRepository priceJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        priceJpaRepository.save(new PriceJpaEntity(null, 1L,
                LocalDateTime.of(2020, 6, 14, 0, 0, 0),
                LocalDateTime.of(2020, 12, 31, 23, 59, 59),
                1, 35455L, 0, new BigDecimal("35.50"), "EUR"));

        priceJpaRepository.save(new PriceJpaEntity(null, 1L,
                LocalDateTime.of(2020, 6, 14, 15, 0, 0),
                LocalDateTime.of(2020, 6, 14, 18, 30, 0),
                2, 35455L, 1, new BigDecimal("25.45"), "EUR"));

        priceJpaRepository.save(new PriceJpaEntity(null, 1L,
                LocalDateTime.of(2020, 6, 15, 0, 0, 0),
                LocalDateTime.of(2020, 6, 15, 11, 0, 0),
                3, 35455L, 1, new BigDecimal("30.50"), "EUR"));

        priceJpaRepository.save(new PriceJpaEntity(null, 1L,
                LocalDateTime.of(2020, 6, 15, 16, 0, 0),
                LocalDateTime.of(2020, 12, 31, 23, 59, 59),
                4, 35455L, 1, new BigDecimal("38.95"), "EUR"));

    }
}
