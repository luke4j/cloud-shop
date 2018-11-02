package club.luke.cloud.shop.app.web;

import club.luke.cloud.shop.app.util.tool.Assertion;
import club.luke.cloud.shop.app.web.vo.VO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by luke on 2018/11/2.
 */
@Aspect
public class AopActionAround {
    private static final Logger log = LoggerFactory.getLogger(AopActionAround.class) ;

    @Pointcut("execution(* club.luke.cloud.shop.app.*.action.impl.*.*(..))")
    private void point() {
    }

    public Object around(ProceedingJoinPoint jp) throws Throwable{

        ActionResult actionResult = null ;
        HttpServletRequest request = null ;
        HttpServletResponse response = null ;
        BindingResult bindingResult = null ;
        VO vo = null ;

        Object[] args = jp.getArgs() ;
        for (Object arg : args) {
            if(arg instanceof ActionResult){
                actionResult = (ActionResult)arg ;
                continue;
            }
            if(arg instanceof HttpServletRequest){
                request = (HttpServletRequest)arg ;
                continue;
            }
            if(arg instanceof HttpServletResponse){
                response = (HttpServletResponse) arg ;
            }
            if(arg instanceof BindingResult){
                bindingResult = (BindingResult) arg ;
            }
            if(arg instanceof VO){
                vo = (VO)arg ;
            }
        }


        Object obj = jp.proceed(jp.getArgs()) ;
        if(bindingResult.hasErrors()){
            Assertion.Error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }


        return obj ;
    }

}
