package com.capitole.challenge.core.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class PricesModel {
        Long productId;
        Long brandId;
        Integer priceList;
        LocalDateTime dateStart;
        LocalDateTime dateEnd;
        double price;
}
