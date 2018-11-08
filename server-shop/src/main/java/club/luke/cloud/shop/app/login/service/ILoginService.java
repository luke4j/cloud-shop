package club.luke.cloud.shop.app.login.service;


import club.luke.cloud.shop.app.web.vo.login.VOInLogin;
import club.luke.cloud.shop.app.web.vo.login.VOOutUser;
import club.luke.cloud.shop.app.web.vo.login.VOOutValText;

import java.util.List;

/**
 * Created by luke on 2018/11/1.
 */
public interface ILoginService {

    /**
     * 登录查询用户方法
     * @param vo
     * @return
     */
    VOOutUser findByloginNameAndPassword(VOInLogin vo) throws Exception;

    /**
     * 程序生成页面唯一ID，与验证码，保存在redis里，时间是5分钟
     * @param pageId
     * @param rdm_val
     * @return
     */
    String rootPageIdAndRdmVal(String pageId, String rdm_val) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    List<VOOutValText> findAllCom()throws Exception;
}
