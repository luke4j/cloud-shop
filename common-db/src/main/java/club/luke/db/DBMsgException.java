package club.luke.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by luke on 2018/11/1.
 */
public class DBMsgException extends Exception {

    private static final Logger log = LoggerFactory.getLogger(DBMsgException.class) ;


    private DBMsgException(){} ;
    private DBMsgException(String msg){} ;

    public static DBMsgException create(String msg){
        log.error(msg);
        return new DBMsgException(msg) ;
    }

    @Override
    public void printStackTrace() {
        log.error(this.getMessage());
        super.printStackTrace();
    }
}
