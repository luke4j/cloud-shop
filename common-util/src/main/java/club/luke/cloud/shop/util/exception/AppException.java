package club.luke.cloud.shop.util.exception;

import club.luke.cloud.shop.util.log.L;

/**
 * Created by luke on 2018/11/2.
 */
public class AppException extends Exception{
    private static final L l = L.getl(AppException.class) ;

    private AppException(){
        super();
    }
    private AppException(String msg){
        super(msg);
    }

    public static AppException create(String msg){
        l.e("====== AppMsgException ====== >>\n" + msg);
        AppException appMsgException = new AppException(msg) ;
        return appMsgException ;
    }

    public static AppException create(Throwable e){
        l.e("====== AppMsgException ====== >>\n" + e.getClass()+"\t"+ e.getMessage());
        AppException appMsgException = new AppException(e.getMessage()) ;
        return appMsgException ;
    }

}
