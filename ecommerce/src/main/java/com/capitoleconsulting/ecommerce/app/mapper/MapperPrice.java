package com.capitoleconsulting.ecommerce.app.mapper;

import com.capitoleconsulting.ecommerce.app.constants.Constant;
import com.capitoleconsulting.ecommerce.app.dto.PriceDTO;
import com.capitoleconsulting.ecommerce.app.model.PriceEntity;
import com.capitoleconsulting.ecommerce.app.util.Utilities;

public class MapperPrice {

    public MapperPrice() {
    }


    public static PriceDTO getPriceDTO(PriceEntity price, boolean flag) {

        return PriceDTO
                .builder()
                .brandId(price.getBrand().getId())
                .brand(price.getBrand().getCompany())
                .product(price.getProduct().getName())
                .priceNormally(price.getPrice())
                .date(
                        ((flag) ? Utilities.LocalDateTimeToString(price.getStartDate(), Constant.FORMAT_YYYY_MM_DD_HH_MM_SS) : "") +
                        " "+
                        ((flag) ? Utilities.LocalDateTimeToString(price.getEndDate(), Constant.FORMAT_YYYY_MM_DD_HH_MM_SS) : "")
                )
                .priceListId((flag) ? String.valueOf(price.getPriceList().getId()) : "")
                .priceFinally((flag) ? price.getPriceList().getPrice() : price.getPrice())
                .curr(price.getCurr().getCurrType())
                .build();

    }
}
