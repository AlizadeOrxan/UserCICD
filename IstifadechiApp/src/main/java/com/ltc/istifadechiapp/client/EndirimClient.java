package com.ltc.istifadechiapp.client;

import com.ltc.istifadechiapp.fallback.EndirimFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "endirim-service", url = "http://localhost:9091",fallback = EndirimFallBack.class)
public interface EndirimClient {

    @GetMapping("/endirim/{category}")
    int getEndirim(@PathVariable("category") String category);
}
