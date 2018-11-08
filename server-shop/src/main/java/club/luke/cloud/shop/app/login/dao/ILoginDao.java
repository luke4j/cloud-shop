package club.luke.cloud.shop.app.login.dao;


import club.luke.cloud.shop.app.model.TU_Com;
import club.luke.cloud.shop.app.web.vo.login.VOInLogin;
import club.luke.cloud.shop.app.web.vo.login.VOOutUser;

import java.util.List;

/**
 * Created by luke on 2018/11/1.
 */

public interface ILoginDao {

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

}
