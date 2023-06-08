package com.capitole.challenge.service;

import com.capitole.challenge.controller.dto.PricesResponseDto;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PricesService {
    Optional<PricesResponseDto> getPriceByProductIdAndBrandIdInApplyDate(Long productId, Long brandId, LocalDateTime applyDate);
}
