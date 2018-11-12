package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by luke on 2018/11/12.
 * 销售组，分为成品，加工，效期，服务
 */
@Entity
public class TSL_SellGoods extends Model{


    @OneToMany
    @JoinColumn(name = "goodsId",foreignKey = @ForeignKey(name = "fk_sellGoods_goods"))
    List<TG_Goods> goods ;

    @ManyToOne
    @JoinColumn(name = "sellGoodsId",foreignKey = @ForeignKey(name = "fk_sellGroup_sellGoods"))
    TSL_SellGroup sellGroup ;

    @ManyToOne
    @JoinColumn(name = "kcId",foreignKey = @ForeignKey(name = "fk_sellGoods_kc"))
    TK_KC kc ;

    /**原始销售价*/
    Double srcPrice ;
    /**实际销售价格，打折自己算*/
    Double outPrice ;
    /**进货价*/
    Double inPrice ;

    /**欠款*/
    Double qk = 0.0 ;



    public Double getQk() {
        return qk;
    }

    public void setQk(Double qk) {
        this.qk = qk;
    }

    public List<TG_Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<TG_Goods> goods) {
        this.goods = goods;
    }

    public TSL_SellGroup getSellGroup() {
        return sellGroup;
    }

    public void setSellGroup(TSL_SellGroup sellGroup) {
        this.sellGroup = sellGroup;
    }

    public Double getSrcPrice() {
        return srcPrice;
    }

    public void setSrcPrice(Double srcPrice) {
        this.srcPrice = srcPrice;
    }

    public Double getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(Double outPrice) {
        this.outPrice = outPrice;
    }

    public Double getInPrice() {
        return inPrice;
    }

    public void setInPrice(Double inPrice) {
        this.inPrice = inPrice;
    }

    public TK_KC getKc() {
        return kc;
    }

    public void setKc(TK_KC kc) {
        this.kc = kc;
    }
}
