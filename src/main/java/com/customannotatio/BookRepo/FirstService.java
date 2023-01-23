package com.customannotatio.BookRepo;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FirstService {

    @Traceable
    public String firstTestMethod(Map<String, String> input){
        System.out.println("now in TestServiceFirst: firstTestMethod ");
        return "success";
    }
}
