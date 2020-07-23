package vn.woodsland.byserp.api.aspect;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("execution(* vn.woodsland.byserp.api.controller.*.*(..))")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        String[] sigParamNames = methodSignature.getParameterNames();
        Object[] signatureArgs = proceedingJoinPoint.getArgs();

        if (log.isInfoEnabled()) {
            log.info("Entering method {} of class {}", methodName, className);
            if (ArrayUtils.isNotEmpty(sigParamNames)
                    && ArrayUtils.isNotEmpty(signatureArgs)
                    && ArrayUtils.isSameLength(sigParamNames, signatureArgs)) {
                log.info("Names of parameters and their values :");
                for (int index = 0; index < signatureArgs.length; index++) {
                    log.info("{}: {}", sigParamNames[index], signatureArgs[index]);
                }
            }
        }
        // start stopwatch
        Object retVal = proceedingJoinPoint.proceed(signatureArgs);

        // stop stopwatch
        if (log.isInfoEnabled()) {
            log.info("Exiting method {} of class {}", methodName, className);
        }

        return retVal;
    }


}
