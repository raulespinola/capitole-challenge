package com.capitole.challenge.controller;

import com.capitole.challenge.controller.dto.PricesRequestDto;
import com.capitole.challenge.core.domain.Prices;
import com.capitole.challenge.service.PricesServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController(value = "api/prices")
public class PricesController {

    private PricesServiceImpl pricesServiceImpl;

    @GetMapping(value = "/",  produces = "application/json")
    //@ApiOperation(value = "Get Titles of Items by Rating", produces = "application/json")
    public ResponseEntity<Prices> getPriceForProduct(@RequestBody PricesRequestDto pricesRequestDto){

        Optional<Prices> pricesData = pricesServiceImpl.getPriceForProduct(pricesRequestDto);
        if (!pricesData.isEmpty()) {
            return ResponseEntity.ok()
                    .body(pricesData.get());
        }
        return ResponseEntity.notFound().build();
    }
}
