package com.example.techtest.services.impl;

import com.example.techtest.model.PriceModel;
import com.example.techtest.model.ProductPrice;
import com.example.techtest.repository.PricesRepository;
import com.example.techtest.services.PricesService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PriceServiceImpl implements PricesService {

    private final PricesRepository pricesRepository;

    PriceServiceImpl(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public ProductPrice getProductPrice(long id, long brandId, Date date) {
        ProductPrice result = new ProductPrice();
        List<PriceModel> res = pricesRepository.findByDateProductIdBrandId(date, id, brandId, Sort.by("priority").descending());
        if (res.size() > 0) {
            result.setProductId(res.get(0).getProductId());
            result.setPriceId(res.get(0).getId());
            result.setRate(res.get(0).getRate());
            result.setStartDate(res.get(0).getStartDate());
            result.setEndDate(res.get(0).getEndDate());
            result.setPrice(res.get(0).getPrice());
            return result;
        }
        return null;
    }
}
