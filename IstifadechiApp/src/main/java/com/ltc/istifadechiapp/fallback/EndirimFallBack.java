package com.ltc.istifadechiapp.fallback;

import com.ltc.istifadechiapp.client.EndirimClient;
import org.springframework.stereotype.Component;

@Component
public class EndirimFallBack implements EndirimClient {


    @Override
    public int getEndirim(String category) {

        System.out.println("Fallback Ishledi");

        return 0;
    }
}
