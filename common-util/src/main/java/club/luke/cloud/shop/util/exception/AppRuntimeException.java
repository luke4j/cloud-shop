package club.luke.cloud.shop.util.exception;

import club.luke.cloud.shop.util.log.L;

/**
 * Created by luke on 2018/11/2.
 */
public class AppRuntimeException extends RuntimeException {

    private static final L l = L.getl(AppException.class) ;

    private AppRuntimeException(){
        super();
    }
    private AppRuntimeException(String msg){
        super(msg);
    }

    public static AppRuntimeException create(String msg){
        l.e("====== AppMsgException ====== >>\n" + msg);
        AppRuntimeException appMsgException = new AppRuntimeException(msg) ;
        return appMsgException ;
    }

    public static AppRuntimeException create(Throwable e){
        l.e("====== AppMsgException ====== >>\n" + e.getClass()+"\t"+ e.getMessage());
        AppRuntimeException appMsgException = new AppRuntimeException(e.getMessage()) ;
        return appMsgException ;
    }



}
