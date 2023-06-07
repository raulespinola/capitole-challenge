package com.capitole.challenge.controller.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class PricesResponseDto {

    Long productId;
    Long brandId;
    Integer priceList;
    LocalDateTime dateStart;
    LocalDateTime dateEnd;
    double price;

}
