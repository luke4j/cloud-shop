package club.luke.cloud.shop.app.user.dao.impl;

import club.luke.cloud.shop.app.conf.ComBaseDao;
import club.luke.cloud.shop.app.model.TU_Com;
import club.luke.cloud.shop.app.model.TU_Role;
import club.luke.cloud.shop.app.user.action.vo.VOInRole;
import club.luke.cloud.shop.app.user.dao.IRoleDao;
import club.luke.cloud.shop.app.util.tool.LKMap;
import club.luke.cloud.shop.app.web.vo.VOIn;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by luke on 2018/11/15.
 */
@Component
public class RoleDao extends ComBaseDao implements IRoleDao{

    @Override
    public List<TU_Role> findAllRole(VOIn vo) throws Exception {
        TU_Com tu_com = this.getGS(vo) ;
        return this.find("From TU_Role r where r.com.id=:comId",new LKMap<String,Object>().put1("comId",tu_com.getId())) ;
    }

    @Override
    public TU_Role saveRole(VOInRole vo) throws Exception {
        TU_Com com = this.getGS(vo) ;
        TU_Role role = new TU_Role() ;
        role.setCom(com);
        BeanUtils.copyProperties(vo, role);
        this.save(role) ;
        return role ;
    }

    @Override
    public void updateRole(TU_Role role) throws Exception {
        this.update(role) ;
    }
}
