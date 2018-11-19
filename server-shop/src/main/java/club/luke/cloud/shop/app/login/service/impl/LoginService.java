package club.luke.cloud.shop.app.login.service.impl;

import club.luke.cloud.shop.app.login.action.vo.*;
import club.luke.cloud.shop.app.login.dao.ILoginDao;
import club.luke.cloud.shop.app.login.dao.ILoginJpaDao;
import club.luke.cloud.shop.app.login.service.ILoginService;
import club.luke.cloud.shop.app.model.*;
import club.luke.cloud.shop.app.util.tool.Assertion;
import club.luke.cloud.shop.app.util.tool.LK;
import club.luke.cloud.shop.app.util.tool.LKMap;
import club.luke.cloud.shop.app.web.vo.VOOut;
import club.luke.cloud.shop.app.web.vo.VORedisUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.*;


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

    @Override
    public Map<String, Object> getInfo(VORedisUser voRedisUser)  throws Exception {
        Map<String,Object> result = new HashMap<String,Object>() ;

        TU_User tu_user = this.loginJpaDao.findById(voRedisUser.getId()) ;
        Assertion.NotEmpty(tu_user, "用户不存在");
        /**查询用户消息*/
        List<TU_Message> listMessage_gr = new ArrayList<>() ; //this.loginDao.findMessage_gr(tu_user) ;
        List<TU_Message> listMessage_zd = new ArrayList<>()  ; //this.loginDao.findMessage_zd(tu_user) ;
        List<TU_Message> listMessage_js = new ArrayList<>()  ; //this.loginDao.findMessage_js(tu_user) ;
        List<TU_Message> listMessage_allCom = new ArrayList<>()  ; //this.loginDao.findMessage_allCom(tu_user) ;
        List<TU_Message> listMessage_system = new ArrayList<>()  ; //this.loginDao.findMessage_system(tu_user) ;
        result.put("msgs",new LKMap<String,Object>().put1("gr",listMessage_gr)
                .put1("zd",listMessage_zd)
                .put1("js",listMessage_js)
                .put1("allCom",listMessage_allCom)
                .put1("system",listMessage_system)) ;
        /**查询用户权限*/
        TU_Role tu_role = tu_user.getRole() ;
        Assertion.NotEmpty(tu_role, "用户角色不能为空，请配置");
        result.put("role",tu_role) ;
        List<TU_Fun> lstFun = tu_user.getRole().getListFun();
        Assertion.NotEmpty(lstFun, "您的角色没有配置权限");
        result.put("funs",lstFun) ;
        /**查询系统配置*/
        List<TSYS_SetupCom> listSetupCom = this.loginDao.findSetupComById(tu_user.getCom().getId()) ;
        result.put("listSetupCom", listSetupCom) ;
        log.info("load time");
        result.put("sysTime", new Date().getTime()) ;

        return result ;
    }

    @Override
    public VOOut delRedisLoginUser(VOInLoginInfo vo) throws Exception {
        this.loginDao.delRedisLoginUser(vo.getLoginTuken()) ;
        return null;
    }

    @Override
    public VOOutUserInfo getUserInfo(VOInLoginInfo vo)  throws Exception {
        VORedisUser redisUser = this.loginDao.getRedisUser(vo.getLoginTuken()) ;
        TU_User tu_user = this.loginDao.get(TU_User.class, redisUser.getId()) ;
        VOOutUserInfo voOutUserInfo = new VOOutUserInfo() ;
        BeanUtils.copyProperties(tu_user,voOutUserInfo);
        return voOutUserInfo;
    }

    @Override
    @Transactional
    public Boolean editPassword(VOInEditPassword vo) throws Exception {
        VORedisUser redisUser = this.loginDao.getRedisUser(vo.getLoginTuken()) ;
        TU_User tu_user = this.loginDao.get(TU_User.class, redisUser.getId()) ;
        tu_user.setPassword(vo.getPassword());
        this.loginDao.editPassword(tu_user) ;
        return true;
    }
}
