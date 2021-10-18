package com.lambda.cvlibrary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cvlib")
public class CVController {
    
    @GetMapping("/hello")
    String hello() {
        return "Hello momottes";
    }

}
