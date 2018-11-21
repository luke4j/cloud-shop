package club.luke.cloud.shop.app.goods.service.impl;

import club.luke.cloud.shop.app.goods.action.vo.VOInKindAndGoods;
import club.luke.cloud.shop.app.goods.action.vo.VOInNode;
import club.luke.cloud.shop.app.goods.action.vo.VOOutNode;
import club.luke.cloud.shop.app.goods.dao.IGoodsDao;
import club.luke.cloud.shop.app.goods.service.IGoodsService;
import club.luke.cloud.shop.app.model.TG_Goods;
import club.luke.cloud.shop.app.model.TG_Kind;
import club.luke.cloud.shop.app.model.TG_Kind_Setup;
import club.luke.cloud.shop.app.model.TU_Com;
import club.luke.cloud.shop.app.util.V;
import club.luke.cloud.shop.app.util.tool.Assertion;
import club.luke.cloud.shop.app.util.tool.LKMap;
import club.luke.cloud.shop.app.web.vo.VOInId;
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

        TU_Com com = this.goodsDao.getGS(vo) ;
        List<TG_Kind>lstKinds = this.goodsDao.find("From TG_Kind k where k.com.id =:comId and k.fid=:fid",
                new LKMap<String,Object>().put1("comId",com.getId()).put1("fid", vo.getFid())) ;

        for (TG_Kind kind : lstKinds) {
            voOutNode = new VOOutNode() ;
            BeanUtils.copyProperties(kind, voOutNode);
            Long count = 0l ;
            /**颜色的子数据在TG_Goods中*/
            if(V.KindLvl.颜色.name().equals(kind.getKindLvl())){
                count = this.goodsDao.getUnique("select count(g.id) from TG_Goods g where g.color.id=:colorId",
                        new LKMap<String,Object>().put1("colorId",kind.getId())) ;
            }else{
                count = this.goodsDao.getUnique("select count(k.id) From TG_Kind k where k.fid=:fid",
                        new LKMap<String,Object>().put1("fid",kind.getId())) ;
            }
            voOutNode.setCount(count);
            lstVOutNodes.add(voOutNode) ;
        }
        /**点击颜色时，lstKinds.size==0,点击没有下一级数据的也会走这里，但是仍然查询不出数据*/
        if(lstKinds.size()==0){
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
                voOutNode.setKindLvl(V.KindLvl.商品);
                lstVOutNodes.add(voOutNode) ;
            }
        }

        return lstVOutNodes ;
    }

    @Override
    public void addKindAndGoods(VOInKindAndGoods vo) throws Exception {
        if(V.KindLvl.商品.name().equals(vo.getKindLvl())){
            addGoods(vo) ;
        }else{
            addKind(vo);
        }
    }

    private void addKind(VOInKindAndGoods vo)throws Exception{
        Assertion.NotEmpty(vo.getKindLvl(),"级别不能为空");
        TU_Com com = this.goodsDao.getGS(vo) ;
        TG_Kind kind = new TG_Kind() ;
        BeanUtils.copyProperties(vo,kind);

        kind.setCom(com);
        this.goodsDao.save(kind) ;
    }

    /**
     * 添加商品时，要添加库存(添加库存就要写入流水)，度数商品要添加度数配置与度数明细
     * @param vo
     * @throws Exception
     */
    private void addGoods(VOInKindAndGoods vo)throws Exception{

    }


    @Override
    public List<TG_Kind_Setup> findKindSetupByKindId(VOInId vo) throws Exception {
        List<TG_Kind_Setup> lst = this.goodsDao.find("From TG_Kind_Setup fs where fs.kind.id=:kindId and fs.msg<>''",
                new LKMap<String,Object>().put1("kindId",vo.getId())) ;
        return lst;
    }
}
