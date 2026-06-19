package com.ltc.endirim.endirim;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endirim")
public class EndirimController {


    @GetMapping("/{category}")
    public int getEndirim(@PathVariable String category) {
        System.out.println("Service Endirim chagirildi");

        if (Math.random() < 0.5 ){
            throw new RuntimeException("Endirim service xetasi. Service ishlemir");
        }

        return switch (category) {
            case "VIP" -> 30;
            case "STUDENT" -> 15;
            default -> 5;
        };
        
    }
    
}
