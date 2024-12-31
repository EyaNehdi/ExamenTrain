package tn.esprit.examen.ExamenTrain.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@Aspect
public class LoggingAspect {
    @Pointcut("execution (int tn.esprit.examen.ExamenTrain.services.*.*(..))")
    public void methodCall() {}

    @Around("methodCall()")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        System.out.println("Méthode " + joinPoint.getSignature() + " exécutée en " + (endTime - startTime) + " ms");
        return proceed;
    }

}
