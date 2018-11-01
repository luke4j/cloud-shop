package club.luke.cloud.shop.app.login.service;

import club.luke.cloud.shop.app.login.vo.VOInLogin;
import club.luke.cloud.shop.app.login.vo.VOOutUser;

/**
 * Created by luke on 2018/11/1.
 */
public interface ILoginService {
    VOOutUser getUserByLogin(VOInLogin vo) throws Exception ;
}
