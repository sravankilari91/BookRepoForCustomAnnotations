package com.customannotatio.BookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @Autowired
    FirstService ServiceFirst;

    @PostMapping("/test")
    public String test(@RequestBody Map<String, String> input) {
        System.out.println("now in controller");

        return ServiceFirst.firstTestMethod(input);
    }
}
