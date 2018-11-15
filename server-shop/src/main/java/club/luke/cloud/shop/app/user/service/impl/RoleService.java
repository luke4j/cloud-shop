package club.luke.cloud.shop.app.user.service.impl;

import club.luke.cloud.shop.app.model.TU_Role;
import club.luke.cloud.shop.app.user.dao.IRoleDao;
import club.luke.cloud.shop.app.user.service.IRoleService;
import club.luke.cloud.shop.app.web.vo.VOIn;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by luke on 2018/11/15.
 */
@Service
public class RoleService implements IRoleService {

    @Resource
    IRoleDao roleDao ;

    @Override
    public List<TU_Role> findAllRole(VOIn vo) throws Exception {

        return this.roleDao.findAllRole(vo) ;
    }
}
