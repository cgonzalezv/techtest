package com.example.techtest.services;

import com.example.techtest.model.ProductPrice;

import java.util.Date;

public interface PricesService {
    ProductPrice getProductPrice(long id, long brandId, Date date);
}
