package com.example.techtest.web;

import com.example.techtest.model.ProductPrice;
import com.example.techtest.services.PricesService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PricesController {

    private final PricesService pricesService;

    PricesController(com.example.techtest.services.PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @GetMapping("/prices")
    ProductPrice getProductPrice(@RequestParam("product-id") Long productId, @RequestParam("brand-id") long brandId, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd.HH:mm:ss") Date date) {
        ProductPrice result = new ProductPrice();
        result = pricesService.getProductPrice(productId, brandId, date);
        return result;
    }


}
