package com.ltc.istifadechiapp.service;

import com.ltc.istifadechiapp.category.IstifadechiCategory;
import com.ltc.istifadechiapp.client.EndirimClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Slf4j
public class IstfiadechiService {

    private final EndirimClient endirimClient;

    public IstfiadechiService(EndirimClient endirimClient) {
        this.endirimClient = endirimClient;
    }



    public String calculatePrice(IstifadechiCategory category, int price) {

        int discount = endirimClient.getEndirim(category.name());
        int finalPrice = price - (price * discount / 100);

        return "Category: " + category +
                ", Discount: " + discount + "%" +
                ", Final Price: " + finalPrice;
    }



}
