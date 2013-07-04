package com.github.greengerong;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class ConditionRunAspect {

    @Around("methodsToBeConditionRun(conditionRun)")
    public Object profile(ProceedingJoinPoint pjp, ConditionRun conditionRun) throws Throwable {
        final Result result = isExec(pjp, conditionRun);
        if (result.isExec()) {
            return pjp.proceed();
        }
        return result.getDefaultValue();
    }

    private Result isExec(ProceedingJoinPoint pjp, ConditionRun conditionRun) {
        try {
            final Runner runner = conditionRun.value().newInstance();
            final MethodSignature signature = (MethodSignature) pjp.getSignature();
            return runner.exec(signature, pjp.getArgs());
        } catch (Exception e) {
            throw new RuntimeException("Runner must be empty constructor and make sure the config is ok.", e);
        }
    }

    @Pointcut(value = "@annotation(conditionRun)")
    public void methodsToBeConditionRun(ConditionRun conditionRun) {
    }
}

