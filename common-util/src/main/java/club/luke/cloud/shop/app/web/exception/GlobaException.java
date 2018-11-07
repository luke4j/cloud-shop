package club.luke.cloud.shop.app.web.exception;

import club.luke.cloud.shop.app.util.tool.LK;
import club.luke.cloud.shop.app.web.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by luke on 2018/11/7.
 */
@ControllerAdvice
public class GlobaException  {

    private static final Logger log = LoggerFactory.getLogger(GlobaException.class) ;


    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ActionResult handlerException(HttpServletRequest request,HttpServletResponse response, Throwable e){
        e.printStackTrace();
        ActionResult actionResult = new ActionResult().init(request,response) ;
        String msg = e.getMessage() ;
        if(LK.StrIsEmpty(msg))
            msg = e.getClass().toString() ;
        actionResult.Fial(e,msg) ;
        return actionResult ;
    }

}
