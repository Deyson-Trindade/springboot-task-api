package com.notes.app.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggerAspect {

    private static final Logger LOGGER = LogManager.getLogger(LoggerAspect.class);


    @Around("execution(* com.notes..*(..)))")
    public Object logMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();


        final StopWatch stopWatch = new StopWatch();
        final Object[] argsJson = proceedingJoinPoint.getArgs();

        final String fullyQualifyMethodName = String.format("%s.%s", methodSignature.getDeclaringType().getSimpleName(),methodSignature.getName());
        LOGGER.info("Entering in method: {} with parameters values {}", fullyQualifyMethodName, argsJson);

        //calculate method execution time
        stopWatch.start();
        final Object result = proceedingJoinPoint.proceed();

        LOGGER.info("Exiting {} with value {}", fullyQualifyMethodName, result);
        stopWatch.stop();

        //Log method execution time
        LOGGER.info("ChoreApi - Spring Boot Logging AOP EXAMPLE - Execution time of "
                + methodSignature.getDeclaringType().getSimpleName() // Class Name
                + "." + methodSignature.getName() + " " // Method Name
                + ":: " + stopWatch.getTotalTimeMillis() + " ms");

        return result;
    }

}
