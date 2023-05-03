package com.capitoleconsulting.ecommerce.app.controller.v1;

import com.capitoleconsulting.ecommerce.app.EcommerceApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(classes = EcommerceApplication.class)
@AutoConfigureMockMvc
class PriceControllerTest {

    private String url = "/price";

    @Autowired
    private MockMvc mvc;



    @Test
    void testToObtainApplicablePricesOk() throws Exception {

        mvc.perform(get(url + "/price-id?" +
                        "BandId=3&" +
                        "date=2023-04-02T00:00:00.306Z&" +
                        "productId=5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.brandId").value(3))
                .andExpect(jsonPath("$.brand").value("JB HI FI"))
                .andExpect(jsonPath("$.product").value("S23 Ultra"))
                .andExpect(jsonPath("$.date").value("2023-04-01 00:00:00 2023-04-28 23:59:59"))
                .andExpect(jsonPath("$.priceNormally").value(2000))
                .andExpect(jsonPath("$.curr").value("AUS"))
                .andExpect(jsonPath("$.priceListId").value("5"))
                .andExpect(jsonPath("$.priceFinally").value(1740));
    }

    @Test
    void testToObtainInapplicablePricesOk() throws Exception {

        mvc.perform(get(url + "/price-id?" +
                        "BandId=3&" +
                        "date=2023-05-02T00:00:00.306Z&" +
                        "productId=5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.brandId").value(3))
                .andExpect(jsonPath("$.brand").value("JB HI FI"))
                .andExpect(jsonPath("$.product").value("S23 Ultra"))
                .andExpect(jsonPath("$.curr").value("AUS"))
                .andExpect(jsonPath("$.date").value(" "))
                .andExpect(jsonPath("$.priceNormally").value(2000))
                .andExpect(jsonPath("$.priceListId").value(""))
                .andExpect(jsonPath("$.priceFinally").value(2000));
    }



    @Test
    void testToObtainNonExistentProduct() throws Exception {

        mvc.perform(get(url + "/price-id?" +
                        "BandId=1&" +
                        "date=2020-06-30T01:21:37.306Z&" +
                        "productId=2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").value("Business error occurred: The product does not exist"));
    }



}