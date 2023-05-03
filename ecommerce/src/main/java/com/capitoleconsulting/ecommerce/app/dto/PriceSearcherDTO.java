package com.capitoleconsulting.ecommerce.app.dto;

import lombok.Setter;
import lombok.Getter;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;


@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceSearcherDTO {

    @NotBlank
    @NotEmpty
    private  long BandId;

    @NotBlank
    @NotEmpty
    private LocalDateTime date;

    @NotBlank
    @NotEmpty
    private  long productId;

}
