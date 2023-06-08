package com.capitole.challenge.controller;

import com.capitole.challenge.controller.dto.PricesResponseDto;
import com.capitole.challenge.service.PricesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
import java.util.Optional;

@RestController(value = "/prices")
@Log4j2
@Validated
@RequiredArgsConstructor
public class PricesController {

    private final PricesServiceImpl pricesServiceImpl;

    @Operation(summary = "Get Price By a Date, Brand and Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found a Price",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PricesResponseDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Data Provided is invalid",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "There are no price for that request",
                    content = @Content) })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<PricesResponseDto>> getPriceForProduct(@RequestParam("productId") @NotNull Long productId,
                                                                          @RequestParam("brandId") @NotNull Long brandId,
                                                                          @RequestParam("date") @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){

        Optional<PricesResponseDto> pricesData = pricesServiceImpl
                .getPriceByProductIdAndBrandIdInApplyDate(productId,brandId, date);
        if (pricesData.isPresent()) {
            return ResponseEntity.ok()
                    .body(pricesData);
        }
        return ResponseEntity.notFound().build();
    }


}
