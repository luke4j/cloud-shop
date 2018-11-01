package club.luke.cloud.shop.app.login.dao.impl;

import club.luke.cloud.shop.app.login.dao.ILoginDao;
import club.luke.cloud.shop.app.login.vo.VOInLogin;
import club.luke.cloud.shop.app.model.TU_User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by luke on 2018/11/1.
 */
@Component
public class LoginDao implements ILoginDao {

    private static final Logger log = LoggerFactory.getLogger(LoginDao.class) ;

    @Resource
    private SessionFactory sessionFactory  ;

    private Session getSession() throws Exception{
        Session session = null ;
        try{
            session = this.sessionFactory.getCurrentSession() ;
        }catch (Exception e){
            session = this.sessionFactory.openSession() ;
        }
        return session ;
    }


    @Override
    public TU_User getUserBYLogin(VOInLogin vo) throws Exception {
        Session session = this.getSession() ;
        TU_User user = session.get(TU_User.class,vo.getId()) ;
        return user;
    }
}
