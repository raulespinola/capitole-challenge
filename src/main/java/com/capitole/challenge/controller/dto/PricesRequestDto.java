package com.capitole.challenge.controller.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class PricesRequestDto {
  LocalDateTime date;
  Long brandId;
  Long productId;

}
