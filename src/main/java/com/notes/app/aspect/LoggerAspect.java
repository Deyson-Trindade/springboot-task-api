package com.notes.app.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    private static final Logger LOGGER = LogManager.getLogger(LoggerAspect.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    @Around("execution(* com.notes..*(..)))")
    public Object logMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        final Object[] args = proceedingJoinPoint.getArgs();

        final String params = OBJECT_MAPPER.writeValueAsString(args);
        final String fullyQualifyMethodName = String.format("%s.%s", methodSignature.getDeclaringType().getSimpleName(),methodSignature.getName());
        LOGGER.info("Entering in method: {} with parameters values {}", fullyQualifyMethodName, params);

        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
            final String resultAsJson = OBJECT_MAPPER.writeValueAsString(result);
            LOGGER.info("Exiting {} with value {}", fullyQualifyMethodName, resultAsJson);
        } catch (Exception e) {
            LOGGER.error("Exiting {} with an exception {}", fullyQualifyMethodName, e);
        }
        return result;
    }

}
