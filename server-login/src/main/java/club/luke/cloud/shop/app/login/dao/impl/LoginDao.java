package club.luke.cloud.shop.app.login.dao.impl;

import club.luke.cloud.shop.app.database.BaseDao;
import club.luke.cloud.shop.app.login.dao.ILoginDao;
import club.luke.cloud.shop.app.login.vo.VOInLogin;
import club.luke.cloud.shop.app.model.TU_User;
import club.luke.cloud.shop.app.util.tool.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by luke on 2018/11/1.
 */
@Component
public class LoginDao extends BaseDao implements ILoginDao {

    private static final Logger log = LoggerFactory.getLogger(LoginDao.class) ;



    @Override
    public TU_User getUserBYLogin(VOInLogin vo) throws Exception {
        TU_User user = this.get(TU_User.class, vo.getId()) ;
        Assertion.NotEmpty(user,"登录失败");
        return user;
    }
}
