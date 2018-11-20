package club.luke.cloud.shop.app.goods.dao.impl;

import club.luke.cloud.shop.app.conf.ComBaseDao;
import club.luke.cloud.shop.app.goods.dao.IGoodsDao;
import club.luke.cloud.shop.app.model.TU_Com;
import club.luke.cloud.shop.app.web.vo.VOInId;
import org.springframework.stereotype.Component;

/**
 * Created by luke on 2018/11/19.
 */
@Component
public class GoodsDao extends ComBaseDao implements IGoodsDao {

    @Override
    public void saveInitKindSetupByMySql(VOInId vo) throws Exception {
        StringBuffer sb_sql = new StringBuffer("insert into tg_kind_setup (b_isDel,b_wtime,defval,htmlType,msg,name,kindId) values (0,now(),'','input','','attr1',"+vo.getId()+")") ;
        for(int i = 2 ;i<= 15 ;i++){
            sb_sql.append(",(0,now(),'','input','','attr"+i+"',"+vo.getId()+")") ;
        }
        this.getJdbcTemplate().execute(sb_sql.toString());
    }
}
