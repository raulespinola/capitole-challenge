package com.capitole.challenge.service;

import com.capitole.challenge.controller.dto.PricesRequestDto;
import com.capitole.challenge.core.domain.Prices;

import java.util.Optional;

public interface PricesService {
    Optional<Prices> getPriceForProduct(PricesRequestDto pricesRequestDto);
}
