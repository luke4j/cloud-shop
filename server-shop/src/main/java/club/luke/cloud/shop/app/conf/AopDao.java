package club.luke.cloud.shop.app.conf;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by luke on 2018/11/14.
 */
@Component
@Aspect
public class AopDao {

    private static final Logger log = LoggerFactory.getLogger(AopDao.class) ;

    @Pointcut("execution(* club.luke.cloud.shop.app.*.dao.impl.*.*(..))")
    private void point() {
    }

    @Around("point()")
    public Object around (ProceedingJoinPoint jp) throws Throwable{
        log.debug("====>====>====>"+jp.getSignature().toShortString());
        //TODO befor code
        Object obj = jp.proceed(jp.getArgs()) ;
        //TODO after code
        return obj ;

    }
}
