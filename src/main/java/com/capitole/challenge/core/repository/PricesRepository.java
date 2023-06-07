package com.capitole.challenge.core.repository;

import com.capitole.challenge.core.domain.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {

    @Transactional(readOnly = true)
    @Query(value = "select * from Prices t where t.PRODUCT_ID = ?1 and t.BRAND_ID= ?2 and ?3 BETWEEN START_DATE AND END_DATE order by t.PRIORITY DESC limit 1 ", nativeQuery = true)
    Optional<Prices> findByProductIdAndBrandIdAndDateIsBetween(@Param("productId") Long productId, @Param("brandId")Long brandId,@Param("date") LocalDateTime date);
}
