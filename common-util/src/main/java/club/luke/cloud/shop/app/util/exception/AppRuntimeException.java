package club.luke.cloud.shop.app.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by luke on 2018/11/2.
 */
public class AppRuntimeException extends RuntimeException {

    private static final Logger log = LoggerFactory.getLogger(AppException.class) ;

    private AppRuntimeException(){
        super();
    }
    private AppRuntimeException(String msg){
        super(msg);
    }

    public static AppRuntimeException create(String msg){
        log.error("====== AppMsgException ====== >>\n" + msg);
        AppRuntimeException appMsgException = new AppRuntimeException(msg) ;
        return appMsgException ;
    }

    public static AppRuntimeException create(Throwable e){
        log.error("====== AppMsgException ====== >>\n" + e.getClass() + "\t" + e.getMessage());
        AppRuntimeException appMsgException = new AppRuntimeException(e.getMessage()) ;
        return appMsgException ;
    }



}
