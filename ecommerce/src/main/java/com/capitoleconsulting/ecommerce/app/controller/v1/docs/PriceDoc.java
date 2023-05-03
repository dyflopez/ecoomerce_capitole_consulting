package com.capitoleconsulting.ecommerce.app.controller.v1.docs;
import com.capitoleconsulting.ecommerce.app.dto.PriceSearcherDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Tag(name = "Prices", description = "API exposed for get prices")
public interface PriceDoc {

    @Operation(summary = "Get prices  by Date, Product ID and Brand",
            description = "This operation is to search for the current value of a product.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product information",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    ResponseEntity getPriceByDateAndProductIdAndBrandId(@RequestParam("BandId") long BandId,
                                                        @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                                                        @RequestParam("productId") long productId);

}
