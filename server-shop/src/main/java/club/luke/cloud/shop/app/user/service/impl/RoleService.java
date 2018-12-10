package club.luke.cloud.shop.app.user.service.impl;

import club.luke.cloud.shop.app.model.TU_Fun;
import club.luke.cloud.shop.app.model.TU_Role;
import club.luke.cloud.shop.app.web.vo.user.VOInRole;
import club.luke.cloud.shop.app.web.vo.user.VOInRoleFun;
import club.luke.cloud.shop.app.user.dao.IRoleDao;
import club.luke.cloud.shop.app.user.service.IRoleService;
import club.luke.cloud.shop.app.util.tool.LKMap;
import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.vo.VOIn;
import club.luke.cloud.shop.app.web.vo.VOInId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by luke on 2018/11/15.
 */
@Service
@Transactional
public class RoleService implements IRoleService {

    @Resource
    IRoleDao roleDao ;

    @Override
    public List<TU_Role> findAllRole(VOIn vo) throws Exception {

        return this.roleDao.findAllRole(vo) ;
    }

    @Override
    public TU_Role saveRole(VOInRole vo) throws Exception {
        return this.roleDao.saveRole(vo) ;
    }

    @Override
    public void saveRoleFun(VOInRoleFun vo) throws Exception {
        List<TU_Fun> lstFun = this.roleDao.find("From TU_Fun f where f.id in (:funIds)", new LKMap<>().put1("funIds",vo.getFunIds())) ;
        TU_Role role = this.roleDao.get(TU_Role.class,vo.getRoleId()) ;
        role.setListFun(lstFun);
        this.roleDao.updateRole(role) ;
    }

    @Override
    public List<TU_Fun> findAllFunByRoleId(ActionResult actionResult, VOInId vo) throws Exception {
        /**所有权限*/
        List<TU_Fun> lstAllFun = this.roleDao.find("From TU_Fun f ") ;
        TU_Role role = this.roleDao.get(TU_Role.class,vo.getId()) ;
        actionResult.getMap().put1("roleFun",role.getListFun()) ;
        return lstAllFun ;
    }
}
