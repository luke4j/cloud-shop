package club.luke.cloud.shop.app.login.dao.impl;

import club.luke.cloud.shop.app.database.BaseDao;
import club.luke.cloud.shop.app.login.dao.ILoginDao;
import club.luke.cloud.shop.app.web.vo.login.VOInLogin;
import club.luke.cloud.shop.app.web.vo.login.VOOutUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by luke on 2018/11/1.
 */
@Component
public class LoginDao extends BaseDao implements ILoginDao {

    private static final Logger log = LoggerFactory.getLogger(LoginDao.class) ;

    @Override
    public VOOutUser findByloginNameAndPassword(VOInLogin vo) throws Exception {
        List<VOOutUser> lstUser = this.getJdbcTemplate().queryForList("Select * from TU_User user ",VOOutUser.class) ;
        if(lstUser!=null&&lstUser.size()>0)
            return lstUser.get(0) ;
        else
            return null;
    }
}
