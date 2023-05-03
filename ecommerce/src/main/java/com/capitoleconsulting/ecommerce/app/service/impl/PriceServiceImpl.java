package com.capitoleconsulting.ecommerce.app.service.impl;

import com.capitoleconsulting.ecommerce.app.exception.MyBusinessException;
import com.capitoleconsulting.ecommerce.app.mapper.MapperPrice;
import org.springframework.cache.annotation.Cacheable;
import com.capitoleconsulting.ecommerce.app.repository.PriceRepository;
import com.capitoleconsulting.ecommerce.app.service.IPriceService;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@AllArgsConstructor
public class PriceServiceImpl implements IPriceService {

    private final PriceRepository priceRepository;

    @Override
    @Cacheable("cachePrice")
    @Transactional(readOnly = true)
    public ResponseEntity getPriceByDateAndProductIdAndBrandId(long BandId, LocalDateTime date, long productId) {

        log.debug(
                "getPriceByDateAndProductIdAndBrandId() request data: \n{}",
                BandId,
                date,
                productId
        );

        var priceEntity = priceRepository.findByBrandIdAndProductIdOrderByPriorityDesc(BandId, productId);

        var priceDTO=
        priceEntity.stream()
                .filter(
                        price -> (
                                date.isAfter(price.getStartDate()) &&
                                        date.isBefore(price.getEndDate())
                        ) ||
                                price.getStartDate().isEqual(date) ||
                                price.getEndDate().isEqual(date)
                )
                .findFirst()
                .map(price -> MapperPrice.getPriceDTO(price,true))
                .orElse(priceEntity
                        .stream()
                        .findFirst()
                        .map(price -> MapperPrice.getPriceDTO(price,false))
                        .orElse(null));

        if(priceDTO == null ){
            throw new MyBusinessException(": The product does not exist");
        }

        log.info(
                "getPriceByDateAndProductIdAndBrandId() successful: \n{}"
        );

        return ResponseEntity.ok(priceDTO);

    }
}
