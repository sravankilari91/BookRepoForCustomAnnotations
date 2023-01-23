package com.customannotatio.BookRepo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class TraceableAspectTest {

    @InjectMocks
    TraceableAspect traceableAspect;

    @Test
    public void traceTest() throws Throwable {
        Map<String, String> input = new HashMap<>();
        input.put("name", "sravan");
        input.put("age", "26");
        String expectedOutput = "success";
        ProceedingJoinPoint joinPoint = Mockito.mock(ProceedingJoinPoint.class);
        Mockito.when(joinPoint.getArgs()).thenReturn(new Object[]{input});
        Mockito.when(joinPoint.proceed()).thenReturn(expectedOutput);

        String response = (String) traceableAspect.trace(joinPoint);
        Assertions.assertEquals(expectedOutput, response);
        Mockito.verify(joinPoint, Mockito.times(1)).proceed();
    }
}
