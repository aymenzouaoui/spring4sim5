package tn.esprit.spring4sim5.configuration;

import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j

public class LoggingAspect {

/*

    @Before("execution(* tn.esprit.spring4sim5.service.BlocServices.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();

        log.info("In method " + name + " : ");
        System.out.println("In method " + name + " : ");
    }



    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* tn.esprit.spring4sim5.service.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("Method execution time: " + elapsedTime + " milliseconds.");
        System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }

    @After("execution(* tn.esprit.spring4sim5.service.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("Exiting method " + name);
        logger.info("Exiting method " + name);
    }
*/
}
