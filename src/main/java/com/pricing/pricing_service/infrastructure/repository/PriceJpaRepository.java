package com.pricing.pricing_service.infrastructure.repository;

import com.pricing.pricing_service.infrastructure.entity.PriceJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceJpaEntity, Long> {

    @Query("""
            SELECT p FROM PriceJpaEntity p
            WHERE p.productId = :productId
            AND p.brandId = :brandId
            AND p.startDate <= :applicationDate
            AND p.endDate >= :applicationDate
            ORDER BY p.priority DESC
            """)
    List<PriceJpaEntity> findApplicablePrices(
            @Param("productId") Long productId,
            @Param("brandId") Long brandId,
            @Param("applicationDate") LocalDateTime applicationDate
    );
}
