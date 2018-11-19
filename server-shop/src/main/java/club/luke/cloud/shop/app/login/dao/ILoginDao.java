package club.luke.cloud.shop.app.login.dao;


import club.luke.cloud.shop.app.database.IBaseDao;
import club.luke.cloud.shop.app.login.action.vo.VOInLogin;
import club.luke.cloud.shop.app.login.action.vo.VOOutUser;
import club.luke.cloud.shop.app.model.TSYS_SetupCom;
import club.luke.cloud.shop.app.model.TU_Com;
import club.luke.cloud.shop.app.model.TU_User;

import java.util.List;

/**
 * Created by luke on 2018/11/1.
 */

public interface ILoginDao extends IBaseDao {

    VOOutUser findByloginNameAndPassword(VOInLogin vo) throws Exception;

    /**
     * redis保存页面唯一码与验证码
     * @param pageId
     * @param rdm_val
     * @return
     */
    String rootPageIdAndRdmVal(String pageId, String rdm_val) throws Exception;

    /**
     * 查询所有公司与站点
     * @return
     * @throws Exception
     */
    List<TU_Com> findAllCom()throws Exception;

    /**
     * login tuken 缓存到redis 保存时间是60*60*8秒
     * @param loginTuken
     * @param s
     * @throws Exception
     */
    void setRedisLoginTuken(String loginTuken, String s)throws Exception;


    /**
     * redis缓存中取得
     * @param loginTuken
     * @return
     * @throws Exception
     */
    String getRedisUserTuken(String loginTuken)throws Exception;

    /**
     * 查询用户所在公司的公司配置
     * @param id
     * @return
     * @throws Exception
     */
    List<TSYS_SetupCom> findSetupComById(Long id)throws Exception;

    /**
     * 删除redis中登录缓存
     * @param loginTuken
     * @return
     * @throws Exception
     */
    Boolean delRedisLoginUser(String loginTuken)throws Exception;

    Boolean editPassword(TU_User tu_user)throws Exception;
}
