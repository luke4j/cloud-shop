package club.luke.cloud.shop.app.util.tool;

import club.luke.cloud.shop.app.util.log.L;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luke on 2018/11/2.
 */
public class TestLK {
    L log = L.getl(TestLK.class) ;




    @Test
    public  void vilidataCode (){
        log.i(LK.vilidateCode(6)) ;
    }




}
