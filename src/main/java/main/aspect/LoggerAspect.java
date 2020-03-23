package main.aspect;

import az.ds.asanpay.logging.utility.BasicRequestTracer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by Sherif on 9/7/2018.
 */
@Component
@Aspect
public class LoggerAspect {

    @Autowired
    BasicRequestTracer basicRequestTracer;


    @Around(" (execution(* main..*.*(..)))  && !@annotation(az.ds.asanpay.logging.annotations.NoLogging)")
    public Object serviceLog(ProceedingJoinPoint joinPoint) throws Throwable {


//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//
//        String id = String.valueOf(utility.getNextCount());
//
//        info(utility.buildRequestBody(joinPoint,id));
//        Object retVal;
//        try {
//            retVal = joinPoint.proceed();
//        } catch (Exception ex) {
//            warn(utility.buildExceptionMessage(joinPoint, ex,id));
//            throw ex;
//        }
//        stopWatch.stop();
//        long millis = stopWatch.getTotalTimeMillis();
//        info(utility.buildResponseBody(retVal, millis, id,joinPoint));
//        return retVal;
        return basicRequestTracer.proceed(joinPoint);
    }



}
