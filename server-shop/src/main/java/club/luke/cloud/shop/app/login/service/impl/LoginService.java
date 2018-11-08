package club.luke.cloud.shop.app.login.service.impl;

import club.luke.cloud.shop.app.login.dao.ILoginDao;
import club.luke.cloud.shop.app.login.dao.ILoginJpaDao;
import club.luke.cloud.shop.app.login.service.ILoginService;
import club.luke.cloud.shop.app.model.TU_Com;
import club.luke.cloud.shop.app.model.TU_User;
import club.luke.cloud.shop.app.web.vo.login.VOInLogin;
import club.luke.cloud.shop.app.web.vo.login.VOOutUser;
import club.luke.cloud.shop.app.web.vo.login.VOOutValText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
