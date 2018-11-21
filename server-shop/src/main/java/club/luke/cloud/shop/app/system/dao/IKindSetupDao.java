package club.luke.cloud.shop.app.system.dao;

import club.luke.cloud.shop.app.conf.IComBaseDao;
import club.luke.cloud.shop.app.web.vo.VOInId;

public interface IKindSetupDao extends IComBaseDao {

    void saveInitKindSetupByMySql(VOInId vo) throws Exception ;
}
