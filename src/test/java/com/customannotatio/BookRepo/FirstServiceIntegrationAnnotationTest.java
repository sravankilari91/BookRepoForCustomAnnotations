package com.customannotatio.BookRepo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class FirstServiceIntegrationAnnotationTest {

    @Autowired
    private FirstService firstService;

    @Test
    public void testMyAnnotation() throws NoSuchMethodException {

        Map<String, String> input = new HashMap<>();
        input.put("name", "sravan");
        input.put("age", "26");
        Method method = FirstService.class.getMethod("firstTestMethod", Map.class);
        Traceable annotation = method.getAnnotation(Traceable.class);

        String response = firstService.firstTestMethod(input);

        Assertions.assertNotNull(annotation);
        Assertions.assertEquals(response, "success");
    }
}
