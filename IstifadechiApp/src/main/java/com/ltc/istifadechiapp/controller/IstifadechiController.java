package com.ltc.istifadechiapp.controller;

import com.ltc.istifadechiapp.category.IstifadechiCategory;
import com.ltc.istifadechiapp.service.IstfiadechiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/istifadechi")
public class IstifadechiController {

    private final IstfiadechiService istfiadechiService;

    public IstifadechiController(IstfiadechiService istfiadechiService) {
        this.istfiadechiService = istfiadechiService;
    }


    @GetMapping("/price")
    public String getPrice(@RequestParam IstifadechiCategory category,
                           @RequestParam int price ){

        return istfiadechiService.calculatePrice(category, price);
    }
}
