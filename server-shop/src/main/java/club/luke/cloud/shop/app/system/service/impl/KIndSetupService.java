package club.luke.cloud.shop.app.system.service.impl;


import club.luke.cloud.shop.app.model.TG_Goods;
import club.luke.cloud.shop.app.model.TG_Kind;
import club.luke.cloud.shop.app.model.TG_Kind_Setup;
import club.luke.cloud.shop.app.model.TU_Com;
import club.luke.cloud.shop.app.web.vo.system.VOInKindSetup;
import club.luke.cloud.shop.app.web.vo.system.VOInNode;
import club.luke.cloud.shop.app.web.vo.system.VOOutNode;
import club.luke.cloud.shop.app.system.dao.IKindSetupDao;
import club.luke.cloud.shop.app.system.service.IKindSetupService;
import club.luke.cloud.shop.app.util.V;
import club.luke.cloud.shop.app.util.tool.LKMap;
import club.luke.cloud.shop.app.web.vo.VOInId;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class KIndSetupService implements IKindSetupService {

    @Resource
    IKindSetupDao kindSetupDao ;

    @Override
    public List<TG_Kind_Setup> findKindSetupConfig(VOInId vo) throws Exception {
        List<TG_Kind_Setup> lstKindSetp = this.kindSetupDao.find("From TG_Kind_Setup fs where  fs.kind.id=:kindId",
                new LKMap<String,Object>().put1("kindId",vo.getId())) ;
        if(lstKindSetp==null||lstKindSetp.size()==0){
            /**如果没有配置过品类的属性配置，需要先初始化一下数据*/
            this.kindSetupDao.saveInitKindSetupByMySql(vo) ;
            lstKindSetp = this.kindSetupDao.find("From TG_Kind_Setup fs where  fs.kind.id=:kindId",
                    new LKMap<String,Object>().put1("kindId",vo.getId())) ;
        }
        return lstKindSetp;
    }

    @Override
    public void editKindSetupConfigById(VOInKindSetup vo) throws Exception {
        vo.setDefVal(vo.getDefVal().replace("；",";"));
        TG_Kind_Setup kindSetup = this.kindSetupDao.get(TG_Kind_Setup.class,vo.getId()) ;
        BeanUtils.copyProperties(vo,kindSetup);
        this.kindSetupDao.update(kindSetup) ;
    }

    @Override
    public List<VOOutNode> findGoodsNode(VOInNode vo) throws Exception {
        List<VOOutNode> lstVOutNodes = new ArrayList<VOOutNode>(100) ;
        VOOutNode voOutNode = null ;

        TU_Com com = this.kindSetupDao.getGS(vo) ;
        List<TG_Kind>lstKinds = this.kindSetupDao.find("From TG_Kind k where k.com.id =:comId and k.fid=:fid",
                new LKMap<String,Object>().put1("comId",com.getId()).put1("fid", vo.getFid())) ;

        for (TG_Kind kind : lstKinds) {
            voOutNode = new VOOutNode() ;
            BeanUtils.copyProperties(kind, voOutNode);
            Long count = 0l ;
            /**颜色的子数据在TG_Goods中*/
            if(V.KindLvl.颜色.name().equals(kind.getKindLvl())){
                count = this.kindSetupDao.getUnique("select count(g.id) from TG_Goods g where g.color.id=:colorId",
                        new LKMap<String,Object>().put1("colorId",kind.getId())) ;
            }else{
                count = this.kindSetupDao.getUnique("select count(k.id) From TG_Kind k where k.fid=:fid",
                        new LKMap<String,Object>().put1("fid",kind.getId())) ;
            }
            voOutNode.setCount(count);
            lstVOutNodes.add(voOutNode) ;
        }
        /**点击颜色时，lstKinds.size==0,点击没有下一级数据的也会走这里，但是仍然查询不出数据*/
        if(lstKinds.size()==0){
            List<TG_Goods>lstGoods = this.kindSetupDao.find("From TG_Goods g where g.color.id=:colorId",
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
}
