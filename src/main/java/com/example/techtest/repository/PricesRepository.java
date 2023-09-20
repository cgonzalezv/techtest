package com.example.techtest.repository;

import com.example.techtest.model.PriceModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PricesRepository extends JpaRepository<PriceModel, Long> {

    @Query("SELECT t FROM PriceModel t WHERE t.brandId = :brandid and t.productId= :productid and t.startDate < :date and t.endDate > :date" )
    List<PriceModel> findByDateProductIdBrandId(Date date, long productid, long brandid, Sort sort);
}
