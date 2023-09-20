package com.example.techtest.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "prices")
@Getter
public class PriceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "BRAND_ID")
    private long brandId;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "PRODUCT_ID")
    private long productId;

    @Column(name = "PRIORITY")
    private int priority;

    @Column(name = "RATE")
    private int rate;

    @Column(name = "PRICE")
    private float price;

    @Column(name = "CURRENCY")
    private String currency;
}
