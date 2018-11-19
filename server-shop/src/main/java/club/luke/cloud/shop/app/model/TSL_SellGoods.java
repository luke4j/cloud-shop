package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by luke on 2018/11/12.
 * 销售组，分为成品，加工，效期，服务
 */
@Entity
public class TSL_SellGoods extends Model{


    @ManyToOne
    @JoinColumn(name = "goodsId",foreignKey = @ForeignKey(name = "fk_SellGoods_goods"))
    TG_Goods goods ;

    @ManyToOne
    @JoinColumn(name = "sellGoodsId",foreignKey = @ForeignKey(name = "fk_sellGroup_sellGoods"))
    TSL_SellGroup sellGroup ;

    @ManyToOne
    @JoinColumn(name = "kcId",foreignKey = @ForeignKey(name = "fk_sellGoods_kc"))
    TK_KC kc ;

    /**原始销售价*/
    Double priceOutSrc ;
    /**实际销售价格，打折自己算*/
    Double priceOutNow ;
    /**进货价*/
    Double printIn ;

    /**欠款*/
    Double qk = 0.0 ;



    public Double getQk() {
        return qk;
    }

    public void setQk(Double qk) {
        this.qk = qk;
    }



    public TSL_SellGroup getSellGroup() {
        return sellGroup;
    }

    public void setSellGroup(TSL_SellGroup sellGroup) {
        this.sellGroup = sellGroup;
    }

    public TG_Goods getGoods() {
        return goods;
    }

    public void setGoods(TG_Goods goods) {
        this.goods = goods;
    }

    public Double getPriceOutSrc() {
        return priceOutSrc;
    }

    public void setPriceOutSrc(Double priceOutSrc) {
        this.priceOutSrc = priceOutSrc;
    }

    public Double getPriceOutNow() {
        return priceOutNow;
    }

    public void setPriceOutNow(Double priceOutNow) {
        this.priceOutNow = priceOutNow;
    }

    public Double getPrintIn() {
        return printIn;
    }

    public void setPrintIn(Double printIn) {
        this.printIn = printIn;
    }

    public TK_KC getKc() {
        return kc;
    }

    public void setKc(TK_KC kc) {
        this.kc = kc;
    }
}
