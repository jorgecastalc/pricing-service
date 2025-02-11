package com.pricing.pricing_service.application.service;

import com.pricing.pricing_service.domain.model.Price;
import com.pricing.pricing_service.domain.repository.PriceRepository;
import com.pricing.pricing_service.infrastructure.exception.PriceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceService priceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnApplicablePrice() {
        // Given
        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        Price expectedPrice = new Price(brandId, applicationDate, applicationDate.plusHours(10),
                1, productId, 0, new BigDecimal("35.50"), "EUR");

        when(priceRepository.findApplicablePrices(productId, brandId, applicationDate))
                .thenReturn(List.of(expectedPrice));

        // When
        Price actualPrice = priceService.getApplicablePrice(productId, brandId, applicationDate);

        // Then
        assertNotNull(actualPrice);
        assertEquals(expectedPrice.getPrice(), actualPrice.getPrice());
        verify(priceRepository, times(1)).findApplicablePrices(productId, brandId, applicationDate);
    }

    @Test
    void shouldThrowExceptionWhenNoPriceFound() {
        // Given
        Long productId = 99999L;
        Long brandId = 1L;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        when(priceRepository.findApplicablePrices(productId, brandId, applicationDate))
                .thenReturn(List.of());

        // When & Then
        assertThrows(PriceException.class,
                () -> priceService.getApplicablePrice(productId, brandId, applicationDate));
        verify(priceRepository, times(1)).findApplicablePrices(productId, brandId, applicationDate);
    }
}