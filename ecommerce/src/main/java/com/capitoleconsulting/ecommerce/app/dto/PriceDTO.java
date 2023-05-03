package com.capitoleconsulting.ecommerce.app.dto;



import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceDTO {

    private long brandId;

    private String brand;

    private  String product;

    private String date;

    private BigDecimal priceNormally;

    private String priceListId;

    private String curr;

    private BigDecimal priceFinally;


}
