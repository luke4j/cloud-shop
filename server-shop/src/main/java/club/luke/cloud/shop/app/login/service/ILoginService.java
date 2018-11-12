package club.luke.cloud.shop.app.login.service;


import club.luke.cloud.shop.app.login.action.vo.VOInLogin;
import club.luke.cloud.shop.app.login.action.vo.VOOutUser;
import club.luke.cloud.shop.app.login.action.vo.VOOutValText;
import club.luke.cloud.shop.app.web.vo.VORedisUser;

import java.util.List;
import java.util.Map;

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
     * 查询所有站点
     * @return
     * @throws Exception
     */
    List<VOOutValText> findAllCom()throws Exception;

    /**
     * 登录查询
     * @param vo
     * @return
     * @throws Exception
     */
    VOOutUser findByLoginNameAndPassword(VOInLogin vo)throws Exception;

    /**
     * 登录后查询系统信息与个人信息,系统时间，当前操作人权限 ，信息，配置
     * @param voRedisUser
     * @return
     * @throws Exception
     */
    Map<String,Object> getInfo(VORedisUser voRedisUser)throws Exception;
}
