package com.capitole.challenge.core.repository;

import com.capitole.challenge.core.domain.Prices;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PricesRepository extends CrudRepository<Prices, Long> {

    Optional<Prices> findByBrandIdAndProductId(Long brandId, Long productId);
}
