package club.luke.cloud.shop.app.goods.service.impl;

import club.luke.cloud.shop.app.goods.action.vo.VOInNode;
import club.luke.cloud.shop.app.goods.action.vo.VOOutNode;
import club.luke.cloud.shop.app.goods.dao.IGoodsDao;
import club.luke.cloud.shop.app.goods.service.IGoodsService;
import club.luke.cloud.shop.app.model.TG_Goods;
import club.luke.cloud.shop.app.model.TG_Kind;
import club.luke.cloud.shop.app.model.TU_Com;
import club.luke.cloud.shop.app.util.V;
import club.luke.cloud.shop.app.util.tool.LKMap;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luke on 2018/11/19.
 */
@Service
@Transactional
public class GoodsService implements IGoodsService {

    @Resource
    IGoodsDao goodsDao ;

    @Override
    public List<VOOutNode> findGoodsNode(VOInNode vo) throws Exception {
        List<VOOutNode> lstVOutNodes = new ArrayList<VOOutNode>(100) ;
        VOOutNode voOutNode = null ;
        if(!V.KindLvl.商品.name().equals(vo.getKindLvl())){
            TU_Com com = this.goodsDao.getGS(vo) ;
            List<TG_Kind>lstKinds = this.goodsDao.find("From TG_Kind k where k.com.id =:comId and k.fid=:fid",
                    new LKMap<String,Object>().put1("comId",com.getId()).put1("fid",vo.getFid())) ;

            for (TG_Kind kind : lstKinds) {
                voOutNode = new VOOutNode() ;
                BeanUtils.copyProperties(kind, voOutNode);
                Long count = 0l ;
                /**颜色的子数据在TG_Goods中*/
                if(V.KindLvl.颜色.name().equals(vo.getKindLvl())){
                    count = this.goodsDao.getUnique("select count(g.id) from TG_Goods g where g.color.id=:colorId",
                            new LKMap<String,Object>().put1("colorId",kind.getId())) ;
                }else{
                    count = this.goodsDao.getUnique("select count(k.id) From TG_Kind k where k.fid=:fid",
                            new LKMap<String,Object>().put1("fid",kind.getId())) ;
                }
                voOutNode.setCount(count);
                lstVOutNodes.add(voOutNode) ;

            }

        }else{
            List<TG_Goods>lstGoods = this.goodsDao.find("From TG_Goods g where g.color.id=:colorId",
                    new LKMap<String, Object>().put1("colorId", vo.getFid())) ;
            for (TG_Goods goods : lstGoods) {
                voOutNode = new VOOutNode() ;
                voOutNode.setName(goods.getName());
                voOutNode.setKcjb(goods.getKcjb().name());
                voOutNode.setId(goods.getId());
                voOutNode.setFid(vo.getFid());
                voOutNode.setIsParent(false);
                voOutNode.setPriceIn(goods.getPriceIn());
                voOutNode.setPriceOut(goods.getPriceOut());
                lstVOutNodes.add(voOutNode) ;
            }
            
        }
        return lstVOutNodes ;
    }
}
