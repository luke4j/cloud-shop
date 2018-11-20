package club.luke.cloud.shop.app.goods.service;

import club.luke.cloud.shop.app.goods.action.vo.VOInKindAndGoods;
import club.luke.cloud.shop.app.goods.action.vo.VOInKindSetup;
import club.luke.cloud.shop.app.goods.action.vo.VOInNode;
import club.luke.cloud.shop.app.goods.action.vo.VOOutNode;
import club.luke.cloud.shop.app.model.TG_Kind_Setup;
import club.luke.cloud.shop.app.web.vo.VOInId;

import java.util.List;

/**
 * Created by luke on 2018/11/19.
 */
public interface IGoodsService {
    /**
     * 查询商品树 一级为品类，二级为品牌，三级为型号，四级为颜色，五级为商品
     * <br>
     *     结点由两个表组成，TG_Kind,TG_Goods
     *     <br>
     *         前四级的数据在TG_Kind中，第五级商品数据在TG_Goods中
     * @param vo
     * @return
     * @throws Exception
     */
    List<VOOutNode> findGoodsNode(VOInNode vo) throws Exception;

    /**
     * 以kindLel为标志，品类就是添加品类，商品就是添加商品
     * @param vo
     * @throws Exception
     */
    void addKindAndGoods(VOInKindAndGoods vo)throws Exception;

    /**
     * 查询品类对应的商品扩展属性
     * @param vo
     * @return
     */
    List<TG_Kind_Setup> findKindSetupConfig(VOInId vo)throws Exception;

    /**
     * 修改商品品类配置属性
     * @param vo
     * @throws Exception
     */
    void editKindSetupConfigById(VOInKindSetup vo)throws Exception;
}
