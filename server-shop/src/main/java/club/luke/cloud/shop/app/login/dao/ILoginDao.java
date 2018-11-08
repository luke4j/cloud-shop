package club.luke.cloud.shop.app.login.dao;


import club.luke.cloud.shop.app.web.vo.login.VOInLogin;
import club.luke.cloud.shop.app.web.vo.login.VOOutUser;

/**
 * Created by luke on 2018/11/1.
 */

public interface ILoginDao {

    VOOutUser findByloginNameAndPassword(VOInLogin vo) throws Exception;
}
