package club.luke.cloud.shop.app.login.service;


import club.luke.cloud.shop.app.web.vo.login.VOInLogin;
import club.luke.cloud.shop.app.web.vo.login.VOOutUser;

/**
 * Created by luke on 2018/11/1.
 */
public interface ILoginService {

    /**
     * 登录查询用户方法
     * @param vo
     * @return
     */
    VOOutUser findByloginNameAndPassword(VOInLogin vo) throws Exception;
}
