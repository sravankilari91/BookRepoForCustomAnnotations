package com.customannotatio.BookRepo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = { FirstService.class,
        Traceable.class,
        AnnotationAwareAspectJAutoProxyCreator.class })
@ExtendWith(SpringExtension.class)
public class FirstServiceTest {
    @InjectMocks
    FirstService firstService;

    @Test
    public void firstTestMethod_test() {
        Map<String, String> input = new HashMap<>();
        input.put("name", "sravan");
        input.put("age", "26");
        String response = firstService.firstTestMethod(input);
        Assertions.assertEquals(response,"success");
    }

}
