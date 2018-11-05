package club.luke.cloud.shop.app.web;

import club.luke.cloud.shop.app.util.tool.Assertion;
import club.luke.cloud.shop.app.util.tool.LK;
import club.luke.cloud.shop.app.web.vo.VO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by luke on 2018/11/2.
 * club.luke.cloud.shop.app.*.action.impl.*.*(..))
 *
 */
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
        if(actionResult==null){
            actionResult = new ActionResult() ;
        }
        if(request!=null&&response!=null){
            actionResult.init(request,response) ;
        }
        String jsonParams = new JSONObject(vo).toString() ;
        actionResult.getMap()
                .put1("url",request.getRequestURL())
                .put1("json params ", jsonParams);

        if(bindingResult.hasErrors()){
            Assertion.Error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        log.debug("==========>:url is " + request.getRequestURL());
        log.debug("==========>:json params "+jsonParams );
        log.debug("==========>:start time "+ LK.DateToStr(new Date(),"yyyy-MM-dd HH:mm:ss SSS"));
        Object obj = jp.proceed(jp.getArgs()) ;
        log.debug("==========>:end time "+ LK.DateToStr(new Date(),"yyyy-MM-dd HH:mm:ss SSS"));

        return obj ;
    }

}
