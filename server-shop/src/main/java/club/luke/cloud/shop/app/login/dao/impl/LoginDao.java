package club.luke.cloud.shop.app.login.dao.impl;

import club.luke.cloud.shop.app.database.BaseDao;
import club.luke.cloud.shop.app.web.vo.login.VOInLogin;
import club.luke.cloud.shop.app.web.vo.login.VOOutUser;
import club.luke.cloud.shop.app.login.dao.ILoginDao;
import club.luke.cloud.shop.app.model.TSYS_SetupCom;
import club.luke.cloud.shop.app.model.TU_Com;
import club.luke.cloud.shop.app.model.TU_User;
import club.luke.cloud.shop.app.util.tool.LKMap;
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

    @Override
    public String rootPageIdAndRdmVal(String pageId, String rdm_val) throws Exception{
        this.setRedisValueAndEX(pageId, rdm_val, 5l) ;
        return pageId;
    }

    @Override
    public List<TU_Com> findAllCom() throws Exception {
        return this.find("Select new TU_Com (id,name) From TU_Com",TU_Com.class) ;
    }

    @Override
    public void setRedisLoginTuken(String loginTuken, String s) throws Exception {
        this.setRedisValueAndEX(loginTuken,s,60*8l) ;
    }

    @Override
    public String getRedisUserTuken(String loginTuken) throws Exception {
        return this.getRedisValue(loginTuken);
    }

    @Override
    public List<TSYS_SetupCom> findSetupComById(Long id) throws Exception {
        return this.find("From TSYS_SetupCom sys where sys.com.id=:comId", new LKMap<String, Object>().put1("comId", id)) ;
    }

    @Override
    public Boolean delRedisLoginUser(String loginTuken) throws Exception {
        return this.delRedisValueByKey(loginTuken) ;
    }

    @Override
    public Boolean editPassword(TU_User tu_user) throws Exception {
        this.update(tu_user) ;
        return true ;
    }
}
