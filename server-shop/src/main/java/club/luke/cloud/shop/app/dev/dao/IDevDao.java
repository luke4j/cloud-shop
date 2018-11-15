package club.luke.cloud.shop.app.dev.dao;

import club.luke.cloud.shop.app.database.IBaseDao;
import club.luke.cloud.shop.app.model.TU_Fun;

/**
 * Created by luke on 2018/11/15.
 */
public interface IDevDao extends IBaseDao {

    /**
     * 保存或修改功能数据
     * @param tu_fun
     * @throws Exception
     */
    void editFun(TU_Fun tu_fun) throws Exception;
}
