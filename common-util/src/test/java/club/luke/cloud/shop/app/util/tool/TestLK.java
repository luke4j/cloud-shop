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
    public void ArrayToJsonStrTest(){
        List<Object> lstMap = new ArrayList<Object>() ;
        lstMap.add(new LKMap<String,Object>().put1("luke", "于洋"));
        lstMap.add(new LKMap<String,Object>().put1("pw","潘伟")) ;

        String rt = LK.ArrayToJsonStr(lstMap,"pw") ;
        log.i(rt);
    }


}
