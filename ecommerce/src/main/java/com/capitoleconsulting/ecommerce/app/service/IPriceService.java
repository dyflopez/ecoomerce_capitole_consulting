package com.capitoleconsulting.ecommerce.app.service;

import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public interface IPriceService {

    ResponseEntity getPriceByDateAndProductIdAndBrandId(long BandId,
                                                        LocalDateTime date,
                                                        long productId);
}
