package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// define type of items and Id
@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    Stock findByStockId(int stockId);
//    public Stock findByPrice(double price);
//    public Stock findByCompanyName(String companyName);

}
