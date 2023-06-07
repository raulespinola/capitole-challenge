package com.capitole.challenge.core.domain;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "prices")
@Entity
@Where(clause = "active=true")
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class Prices extends BaseEntity{

    @Column(name = "BRAND_ID")
    private Long brandId;
    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    @Column(name = "END_DATE")
    private LocalDateTime endDate;
    @Column(name = "PRICE_LIST")
    private Long priceListId;
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "PRIORITY")
    private Integer priority;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "CURR")
    private String curr;
}
