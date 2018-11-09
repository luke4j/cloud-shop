package club.luke.cloud.shop.app.login.service.impl;

import club.luke.cloud.shop.app.login.dao.ILoginDao;
import club.luke.cloud.shop.app.login.dao.ILoginJpaDao;
import club.luke.cloud.shop.app.login.service.ILoginService;
import club.luke.cloud.shop.app.model.TU_Com;
import club.luke.cloud.shop.app.model.TU_User;
import club.luke.cloud.shop.app.util.tool.Assertion;
import club.luke.cloud.shop.app.util.tool.LK;
import club.luke.cloud.shop.app.web.vo.login.VOInLogin;
import club.luke.cloud.shop.app.web.vo.login.VOOutUser;
import club.luke.cloud.shop.app.web.vo.login.VOOutValText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by luke on 2018/11/1.
 */
@Service
public class LoginService implements ILoginService {

    private static final Logger log = LoggerFactory.getLogger(LoginService.class) ;

    @Resource
    ILoginDao loginDao ;

    @Resource
    ILoginJpaDao loginJpaDao ;


    @Override
    public VOOutUser findByloginNameAndPassword(VOInLogin vo) throws Exception{
        TU_User pojo_user = loginJpaDao.findByLoginNameAndPassword(vo.getLoginName(),vo.getPassword()) ;
        List<TU_User> lstUser = loginJpaDao.findByNameAndPassword(vo.getLoginName(), vo.getPassword()) ;
        VOOutUser voOutUser = new VOOutUser() ;
        BeanUtils.copyProperties(pojo_user, voOutUser);
        return voOutUser;
    }


    @Override
    public String rootPageIdAndRdmVal(String pageId, String rdm_val) throws Exception {
        this.loginDao.rootPageIdAndRdmVal(pageId,rdm_val) ;
        return pageId;
    }

    @Override
    public List<VOOutValText> findAllCom() throws Exception {
        List<TU_Com> lstCom = loginDao.findAllCom();
        List<VOOutValText> lstRst = new ArrayList<>(lstCom.size()) ;
        lstCom.forEach(com->{
            VOOutValText vout = new VOOutValText() ;
            //TODO tu_com
            vout.setText(com.getName());
            vout.setVal(com.getId().toString()) ;
            lstRst.add(vout) ;
        });
        return lstRst ;
    }

    @Transactional
    @Override
    public VOOutUser findByLoginNameAndPassword(VOInLogin vo) throws Exception {
        VOOutUser voOutUser = new VOOutUser() ;
        if(LK.StrIsNotEmpty(vo.getLoginTuken())){
            String json_outUser = this.loginDao.getRedisUserTuken(vo.getLoginTuken()) ;
            VOOutUser redisVOOutUser = LK.StrJson2Obj(json_outUser,VOOutUser.class) ;
            if(redisVOOutUser!=null){
               if(vo.getLoginName().equals(redisVOOutUser.getLoginName())&&vo.getComId().equals(redisVOOutUser.getLoginComId()))
                   return redisVOOutUser ;
            }
        }

        TU_User tu_user = this.loginJpaDao.findByLoginNameAndPassword(vo.getLoginName(), vo.getPassword()) ;
        Assertion.NotEmpty(tu_user, "登录失败");
        BeanUtils.copyProperties(tu_user, voOutUser);

        voOutUser.setName(LK.NameToPingYinLong(voOutUser.getName()));

        TU_Com tu_com = this.loginDao.get(TU_Com.class,vo.getComId()) ;
        Assertion.NotEmpty(tu_com,"站点信息异常");
        voOutUser.setCom_name(tu_com.getName());
        voOutUser.setLoginComId(tu_com.getId());

        String loginTuken = "loginTuken-"+tu_user.getCom().getId()+"-"+tu_user.getId()+"-"+LK.uuid() ;
        if(log.isDebugEnabled()){
            log.debug("login-tuken is "+loginTuken);
        }
        this.loginDao.setRedisLoginTuken(loginTuken, LK.ObjToJsonStr(voOutUser)) ;
        voOutUser.setLoginTuken(loginTuken);
        return voOutUser;
    }
}
