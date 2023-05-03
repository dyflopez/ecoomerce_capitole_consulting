package com.capitoleconsulting.ecommerce.app.controller.v1;

import com.capitoleconsulting.ecommerce.app.controller.v1.docs.PriceDoc;
import com.capitoleconsulting.ecommerce.app.dto.PriceSearcherDTO;
import com.capitoleconsulting.ecommerce.app.service.IPriceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@AllArgsConstructor
@RestController
@RequestMapping("/price")
public class PriceController implements PriceDoc {

    private final IPriceService iPriceService;

    @Override
    @GetMapping("/price-id")
    public ResponseEntity getPriceByDateAndProductIdAndBrandId(long BandId, LocalDateTime date, long productId) {
        return iPriceService.getPriceByDateAndProductIdAndBrandId(BandId, date, productId);
    }
}
