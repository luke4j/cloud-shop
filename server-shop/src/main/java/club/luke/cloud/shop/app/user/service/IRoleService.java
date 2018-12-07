package club.luke.cloud.shop.app.user.service;

import club.luke.cloud.shop.app.model.TU_Fun;
import club.luke.cloud.shop.app.model.TU_Role;
import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.vo.VOIn;
import club.luke.cloud.shop.app.web.vo.VOInId;
import club.luke.cloud.shop.app.web.vo.user.VOInRole;
import club.luke.cloud.shop.app.web.vo.user.VOInRoleFun;

import java.util.List;

/**
 * Created by luke on 2018/11/15.
 */
public interface IRoleService {
    /**
     * 查询所有权限（带公司限制）
     * @param vo
     * @return
     * @throws Exception
     */
    List<TU_Role> findAllRole(VOIn vo) throws Exception;

    /**
     * 保存角色
     * @param vo
     */
    TU_Role saveRole(VOInRole vo)throws Exception;

    /**
     * 保存角色权限
     * @param vo
     */
    void saveRoleFun(VOInRoleFun vo)throws Exception;

    /**
     * 查询所有功能，并查询角色对应的权限
     * @param actionResult
     * @param vo
     * @throws Exception
     */
    List<TU_Fun> findAllFunByRoleId(ActionResult actionResult, VOInId vo)throws Exception;
}
