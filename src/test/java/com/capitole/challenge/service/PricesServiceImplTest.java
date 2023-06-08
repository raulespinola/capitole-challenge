package com.capitole.challenge.service;

import com.capitole.challenge.controller.dto.PricesResponseDto;
import com.capitole.challenge.core.domain.Prices;
import com.capitole.challenge.core.repository.PricesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricesServiceImplTest {

    @InjectMocks
    private PricesServiceImpl pricesService;

    @Mock
    private PricesRepository pricesRepository;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Test
    void return_prices_from_service() {
        mockPriceList();
        Optional<PricesResponseDto> prices = pricesService.getPriceByProductIdAndBrandIdInApplyDate(1L,
                35455L,LocalDateTime.parse("2020-06-14 00:00:00", formatter));
        assertEquals(prices.get().getPrice(), 35.5);
    }

    private void mockPriceList() {
        var item = Prices.builder()
                .productId(35455L)
                .brandId(1L)
                .startDate(LocalDateTime.parse("2020-06-14 00:00:00",
                        formatter))
                .endDate(LocalDateTime.parse("2020-06-14 12:00:00",
                        formatter))
                .price(35.5)
                .build();
        var list = Optional.of(item);
        when(pricesRepository.findByProductIdAndBrandIdAndDateIsBetween(any(), any(), any()))
                .thenReturn(list);
    }
}