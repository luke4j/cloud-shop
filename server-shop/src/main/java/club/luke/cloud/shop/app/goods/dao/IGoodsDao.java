package club.luke.cloud.shop.app.goods.dao;

import club.luke.cloud.shop.app.conf.IComBaseDao;
import club.luke.cloud.shop.app.model.TU_Com;
import club.luke.cloud.shop.app.web.vo.VOInId;

/**
 * Created by luke on 2018/11/19.
 */
public interface IGoodsDao extends IComBaseDao {
    void saveInitKindSetupByMySql(VOInId vo) throws Exception ;
}
