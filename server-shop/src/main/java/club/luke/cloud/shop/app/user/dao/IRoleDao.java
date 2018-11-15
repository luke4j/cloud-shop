package club.luke.cloud.shop.app.user.dao;

import club.luke.cloud.shop.app.database.IBaseDao;
import club.luke.cloud.shop.app.model.TU_Role;
import club.luke.cloud.shop.app.web.vo.VOIn;

import java.util.List;

/**
 * Created by luke on 2018/11/15.
 */
public interface IRoleDao extends IBaseDao {

    /**
     * 查询所有权限（带公司限制）
     * @param vo
     * @throws Exception
     */
    List<TU_Role> findAllRole(VOIn vo) throws Exception;
}
