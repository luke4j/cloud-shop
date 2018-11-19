package club.luke.cloud.shop.app.yw.service.impl;

import club.luke.cloud.shop.app.model.*;
import club.luke.cloud.shop.app.util.tool.LK;
import club.luke.cloud.shop.app.yw.dao.IYWDao;
import club.luke.cloud.shop.app.yw.service.IYWProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * Created by luke on 2018/11/19.
 */
@Service
public class YWProxyFactory {
    private static final Logger log = LoggerFactory.getLogger(YWProxyFactory.class) ;
    @Resource
    IYWDao ywDao ;


    /**
     * 代理IYWProxy接口，所以返回的也是这个接口类型
     * @param target
     * @return
     * @throws Exception
     */
    IYWProxy getInstance(IYWProxy target) throws Exception{
        IYWProxy iywProxy =(IYWProxy) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    if(log.isDebugEnabled()){
                        log.debug("==》进入业务代理，代理对象为："+target.getClass().getClass().getName()+"=>代理方法为："+method.getName()+"=>参数为\n");
                        for (Object arg : args) {
                           log.debug(arg .getClass().getSimpleName()+":"+ LK.ObjToJsonStr(arg));
                        }
                    }

                    /**执行代理方法*/
                    Object object = method.invoke(target,args) ;
                    log.info("代理方法已完成");

                    TY_YWD ywd = null ;
                    TY_YWDMX ywdmx = null ;
                    TK_KC kc = null ;
                    TY_Code ywCode = null ;
                    Long num = null ;
                    TU_Com store = null ;
                    TU_User endOpter = null ;

                    for (Object arg : args) {
                        if(arg instanceof TY_YWD){
                            ywd = (TY_YWD)arg ;
                            continue;
                        }
                        if(arg instanceof TY_YWDMX){
                            ywdmx = (TY_YWDMX)arg ;
                            continue;
                        }
                        if(arg instanceof TK_KC){
                            kc = (TK_KC)arg ;
                            continue;
                        }
                        if(arg instanceof TY_Code){
                            ywCode = (TY_Code)arg ;
                            continue;
                        }
                        if(arg instanceof Long){
                            num = (Long)arg ;
                            continue;
                        }
                        if(arg instanceof TU_Com){
                            store = (TU_Com)arg ;
                            continue;
                        }
                        if(arg instanceof TU_User){
                            endOpter = (TU_User)arg ;
                            continue;
                        }
                    }
                    TY_LS ls = new TY_LS() ;
                    /**某商品，在某时间，在某地点，做了某个业务，是谁操作的，操作了多少*/
                    ls.setKc(kc);
                    ls.setGoods(kc.getGoods());
                    ls.setSph(kc.getSph());
                    ls.setCyl(kc.getCyl());
                    ls.setEndTime(new Date());
                    ls.setStore(store);
//                    ls.setYwCode(ywCode) ;
                    ls.setOptNum(num);
                    ls.setEndOpter(endOpter);

                    ls.setE_can_kc(kc.getCan_kc());
                    ls.setE_ci_kc(kc.getCi_kc());
                    ls.setE_zp_kc(kc.getZp_kc());
                    ls.setE_z_kc(kc.getZ_kc());

                    ls.setYwdId(ywd.getId());
                    ls.setYwdTable(ywd.getClass().getSimpleName());

                    ls.setYwmxId(ywdmx.getId());
                    ls.setYwmxTable(ywdmx.getClass().getSimpleName());

                    this.ywDao.save(ls) ;
                    log.info("代理保存流水："+ls.getId());

            return object ;
        }) ;
        return iywProxy ;
    }


}
