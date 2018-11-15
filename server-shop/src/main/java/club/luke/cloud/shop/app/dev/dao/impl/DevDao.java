package club.luke.cloud.shop.app.dev.dao.impl;

import club.luke.cloud.shop.app.database.BaseDao;
import club.luke.cloud.shop.app.dev.dao.IDevDao;
import club.luke.cloud.shop.app.model.TU_Fun;
import org.springframework.stereotype.Component;

/**
 * Created by luke on 2018/11/15.
 */
@Component
public class DevDao extends BaseDao implements IDevDao {

    @Override
    public void editFun(TU_Fun tu_fun) throws Exception {
        this.update(tu_fun) ;
    }
}
