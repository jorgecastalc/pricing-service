package com.pricing.pricing_service.infrastructure.exception;

public class PriceException extends RuntimeException {
    public PriceException(Long productId, Long brandId, String applicationDate) {
        super("No se ha encontrado un precio que aplicar para el producto " + productId + " de la marca " + brandId + " para la fecha " + applicationDate);
    }
}
