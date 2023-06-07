package com.capitole.challenge.controller;

import com.capitole.challenge.controller.dto.PricesResponseDto;
import com.capitole.challenge.service.PricesServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@RestController(value = "/prices")
@Log4j2
@Validated
@RequiredArgsConstructor
public class PricesController {

    private final PricesServiceImpl pricesServiceImpl;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    //@ApiOperation(value = "Get Titles of Items by Rating", produces = "application/json")
    public ResponseEntity<List<PricesResponseDto>> getPriceForProduct(@RequestParam("productId") @NotNull Long productId,
                                                                      @RequestParam("brandId") @NotNull Long brandId,
                                                                      @RequestParam("date") @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){

        List<PricesResponseDto> pricesData = pricesServiceImpl
                .getPriceByProductIdAndBrandIdInApplyDate(productId,brandId, date);
        if (!pricesData.isEmpty()) {
            return ResponseEntity.ok()
                    .body(pricesData);
        }
        return ResponseEntity.notFound().build();
    }
}
