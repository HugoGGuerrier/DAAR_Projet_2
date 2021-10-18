package com.lambda.cvlibrary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/cvlib")
public class CVController {

    @GetMapping("/")
    String search(@RequestParam("q") String query) {
        return "SEARCH";
    }

    @PostMapping("/")
    String upload(@RequestParam("file") MultipartFile file) {
        return "TEST";
    }

}
