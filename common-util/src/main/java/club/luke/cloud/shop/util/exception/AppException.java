package club.luke.cloud.shop.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by luke on 2018/11/2.
 */
public class AppException extends Exception{

    private static final Logger log = LoggerFactory.getLogger(AppException.class) ;

    private AppException(){
        super();
    }
    private AppException(String msg){
        super(msg);
    }

    public static AppException create(String msg){
        log.error("====== AppException ====== >>\n" + msg);
        AppException appMsgException = new AppException(msg) ;
        return appMsgException ;
    }

    public static AppException create(Throwable e){
        log.error("====== AppException ====== >>\n" + e.getClass() + "\t" + e.getMessage());
        AppException appMsgException = new AppException(e.getMessage()) ;
        return appMsgException ;
    }

}
