package club.luke.cloud.shop.app.login.service.impl;

import club.luke.cloud.shop.app.login.dao.ILoginDao;
import club.luke.cloud.shop.app.login.service.ILoginService;
import club.luke.cloud.shop.app.login.vo.VOInLogin;
import club.luke.cloud.shop.app.login.vo.VOOutUser;
import club.luke.cloud.shop.app.model.TU_User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by luke on 2018/11/1.
 */
@Service
public class LoginService implements ILoginService {


    @Resource
    ILoginDao loginDao ;

    @Override
    public VOOutUser getUserByLogin(VOInLogin vo) throws Exception {
        TU_User user = this.loginDao.getUserBYLogin(vo) ;
        VOOutUser out = new VOOutUser() ;
        BeanUtils.copyProperties(user,out);
        return out;
    }
}
