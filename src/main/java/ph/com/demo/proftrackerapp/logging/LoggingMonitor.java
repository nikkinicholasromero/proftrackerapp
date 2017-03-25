package ph.com.demo.proftrackerapp.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by nikkiromero on 23/03/2017.
 */
@Aspect
@Component
public class LoggingMonitor {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* ph.com.demo..*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before (Signature) : " + joinPoint.getSignature());
        Object[] args = joinPoint.getArgs();
        for(int i = 0; i < args.length; i++) {
            log.debug("Before (Param) : " + args[i].toString());
        }
    }

    @AfterReturning(value = "execution(* ph.com.demo..*.*(..))", returning = "returnValue")
    public void logAfterReturning(JoinPoint joinPoint, Object returnValue) {
        log.info("After Returning (Signature) : " + joinPoint.getSignature());
        log.info("After Returning (Return Value) : " + (returnValue != null ? returnValue.toString() : null));
    }

    @AfterThrowing(value = "execution(* ph.com.demo..*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        log.info("After Throwing (Signature) : " + joinPoint.getSignature());
        log.info("After Throwing (Exception Class) : " + exception.getClass());
        log.info("After Throwing (Exception Message) : " + exception.getMessage());
    }
}
