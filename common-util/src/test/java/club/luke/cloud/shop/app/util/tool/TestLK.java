package club.luke.cloud.shop.app.util.tool;

import club.luke.cloud.shop.app.util.log.L;
import org.junit.Test;

/**
 * Created by luke on 2018/11/2.
 */
public class TestLK {
    L log = L.getl(TestLK.class) ;




    @Test
    public  void vilidataCode () throws Exception{
        log.i(LK.vilidateCode(6)) ;
    }



    @Test
    public void testEvalStrCode() throws Exception{
        Boolean isBroken = true ;
        String stream = "" ;
        String code = "if(isBroken){stream=100}else{stream=200}" ;
        Object tmp = LK.evalStrCode(code, new LKMap<>().put1("isBroken", isBroken).put1("stream", stream)) ;

        log.i("stream is "+stream);
        log.i("tmp is "+tmp.toString());


    }


}
