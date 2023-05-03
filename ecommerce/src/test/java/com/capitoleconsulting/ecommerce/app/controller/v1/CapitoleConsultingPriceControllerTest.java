package com.capitoleconsulting.ecommerce.app.controller.v1;

import com.capitoleconsulting.ecommerce.app.EcommerceApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = EcommerceApplication.class)
@AutoConfigureMockMvc
class CapitoleConsultingPriceControllerTest {


    private static final String URL = "/price/price-id";

    private static final String BRAND_ID = "1";

    private static final String PRODUCT_ID = "35455";


    @Autowired
    private MockMvc mvc;

    private ResultActions performGetRequest(String date) throws Exception {
        return mvc.perform(get(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .param("BandId", BRAND_ID)
                .param("date", date)
                .param("productId", PRODUCT_ID));
    }



    @Test
    void testCapitoleConsulting1() throws Exception {

        var result = performGetRequest("2020-06-14T10:00:00.000Z");
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.brand").value("ZARA"))
                .andExpect(jsonPath("$.product").value("RIPPED DENIM JACKET DRESS"))
                .andExpect(jsonPath("$.date").value("2020-06-14 00:00:00 2020-12-31 23:59:59"))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.priceNormally").value(35.5))
                .andExpect(jsonPath("$.priceListId").value("1"))
                .andExpect(jsonPath("$.priceFinally").value(10.1));
    }

    @Test
    void testCapitoleConsulting2() throws Exception {

        var result = performGetRequest("2020-06-14T16:00:00.000Z");
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.brand").value("ZARA"))
                .andExpect(jsonPath("$.product").value("RIPPED DENIM JACKET DRESS"))
                .andExpect(jsonPath("$.date").value("2020-06-14 15:00:00 2020-06-14 18:30:00"))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.priceNormally").value(25.45))
                .andExpect(jsonPath("$.priceListId").value("2"))
                .andExpect(jsonPath("$.priceFinally").value(5.5));
    }

    @Test
    void testCapitoleConsulting3() throws Exception {

        var result = performGetRequest("2020-06-14T21:00:00.000Z");
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.brand").value("ZARA"))
                .andExpect(jsonPath("$.product").value("RIPPED DENIM JACKET DRESS"))
                .andExpect(jsonPath("$.date").value("2020-06-14 00:00:00 2020-12-31 23:59:59"))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.priceNormally").value(35.5))
                .andExpect(jsonPath("$.priceListId").value("1"))
                .andExpect(jsonPath("$.priceFinally").value(10.1));
    }

    @Test
    void testCapitoleConsulting4() throws Exception {

        var result = performGetRequest("2020-06-15T10:00:00.000Z");
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.brand").value("ZARA"))
                .andExpect(jsonPath("$.product").value("RIPPED DENIM JACKET DRESS"))
                .andExpect(jsonPath("$.date").value("2020-06-15 00:00:00 2020-06-15 11:00:00"))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.priceNormally").value(30.5))
                .andExpect(jsonPath("$.priceListId").value("3"))
                .andExpect(jsonPath("$.priceFinally").value(30.4));
    }

    @Test
    void testCapitoleConsulting5() throws Exception {

        var result = performGetRequest("2020-06-15T21:00:00.000Z");
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.brand").value("ZARA"))
                .andExpect(jsonPath("$.product").value("RIPPED DENIM JACKET DRESS"))
                .andExpect(jsonPath("$.date").value("2020-06-15 16:00:00 2020-12-31 23:59:59"))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.priceNormally").value(38.95))
                .andExpect(jsonPath("$.priceListId").value("4"))
                .andExpect(jsonPath("$.priceFinally").value(200));
    }

}