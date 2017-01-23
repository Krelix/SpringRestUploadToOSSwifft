package com.github.krelix.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by brizarda on 23/01/2017.
 * Attempt at using AOP to monitor execution times
 * Currently not working.
 */
@Aspect
@Component
public class StorageMonitor {
    private static final Logger LOGGER = LoggerFactory.getLogger(StorageMonitor.class);

    @Before("execution(* StorageController.uploadDocument *)")
    public void uploadDocumentMonitor()
        throws Throwable {
        LOGGER.debug("In uploadDocumentMonitor");
        /*StopWatch watch = new StopWatch();

        watch.start();
        Object uploadResult = proceedingJoinPoint.proceed();
        watch.stop();

        LOGGER.info("Uploadexec time : {}", watch.toString());
        return (String) uploadResult;*/
    }

}
