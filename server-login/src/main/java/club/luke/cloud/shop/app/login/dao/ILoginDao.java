package club.luke.cloud.shop.app.login.dao;

import club.luke.cloud.shop.app.login.vo.VOInLogin;
import club.luke.cloud.shop.app.model.TU_User;

/**
 * Created by luke on 2018/11/1.
 */
public interface ILoginDao {

    TU_User getUserBYLogin(VOInLogin vo) throws Exception ;

}
