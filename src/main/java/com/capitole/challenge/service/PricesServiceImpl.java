package com.capitole.challenge.service;

import com.capitole.challenge.controller.dto.PricesRequestDto;
import com.capitole.challenge.core.domain.Prices;
import com.capitole.challenge.core.repository.PricesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PricesServiceImpl implements PricesService{

    private PricesRepository pricesRepository;

    @Override
    public Optional<Prices> getPriceForProduct(PricesRequestDto pricesRequestDto) {
            return pricesRepository
                    .findByBrandIdAndProductId(pricesRequestDto.getBrandId(), pricesRequestDto.getProductId());
    }
}
