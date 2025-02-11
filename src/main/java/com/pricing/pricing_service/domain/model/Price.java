package com.pricing.pricing_service.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    private Long brandId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer priceList;
    private Long productId;
    private BigDecimal price;
    private String currency;

}
