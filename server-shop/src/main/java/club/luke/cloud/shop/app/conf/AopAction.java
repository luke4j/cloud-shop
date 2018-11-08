package club.luke.cloud.shop.app.conf;

import club.luke.cloud.shop.app.web.AopActionAround;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by luke on 2018/11/5.
 */
@Component
@Aspect
public class AopAction extends AopActionAround {

    private static final Logger log = LoggerFactory.getLogger(AopAction.class) ;

    @Pointcut("execution(* club.luke.cloud.shop.app.*.action.impl.*.*(..))")
    private void point() {
    }

    @Around("point()")
    public Object around (ProceedingJoinPoint jp) throws Throwable{
        return super.around(jp) ;
    }
}
