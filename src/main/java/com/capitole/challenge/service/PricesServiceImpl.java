package com.capitole.challenge.service;

import com.capitole.challenge.controller.dto.PricesResponseDto;
import com.capitole.challenge.core.repository.PricesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PricesServiceImpl implements PricesService{

    private final PricesRepository pricesRepository;

    @Override
    public List<PricesResponseDto> getPriceByProductIdAndBrandIdInApplyDate(Long productId, Long brandId, LocalDateTime applyDate) {
        return pricesRepository
                .findByProductIdAndBrandIdAndDateIsBetween(productId, brandId, applyDate)
                .stream().map(e->PricesResponseDto.builder()
                        .productId(e.getProductId())
                        .endDate(e.getEndDate())
                        .startDate(e.getStartDate())
                        .brandId(e.getBrandId())
                        .price(e.getPrice())
                        .priceList(e.getPriceListId()).build())
                .toList();
    }
}
