package club.luke.cloud.shop.app.conf;

import club.luke.cloud.shop.app.database.BaseDao;
import club.luke.cloud.shop.app.model.TU_Com;
import club.luke.cloud.shop.app.web.vo.VOIn;

/**
 * Created by luke on 2018/11/15.
 */
public class ComBaseDao  extends BaseDao {

    /**
     * 以登录站点查询总公司数据
     * @param vo
     * @return
     * @throws Exception
     */
        public TU_Com getGS(VOIn vo) throws Exception{
            /**查询登录站点*/
            TU_Com store = this.get(TU_Com.class,vo.getLoginComId()) ;
            /**判断登录站点是否总公司*/
            if(store.getFid()==null||store.getFid().longValue()==0){
                return store ;
            }else{
                return getGS(store) ;
            }
        }

        private TU_Com getGS(TU_Com store)throws Exception{
            /**判断站点的父级是否总公司*/
            store = this.get(TU_Com.class,store.getFid()) ;
            if(store.getFid()==null||store.getFid().longValue()==0){
                return store ;
            }else{
                return getGS(store) ;
            }
        }

}
