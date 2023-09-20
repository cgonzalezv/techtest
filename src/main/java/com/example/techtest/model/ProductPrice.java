package com.example.techtest.model;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class
ProductPrice {
    private long productId;
    private long priceId;
    private int rate;
    private float price;
    private Date startDate;
    private Date endDate;
}
