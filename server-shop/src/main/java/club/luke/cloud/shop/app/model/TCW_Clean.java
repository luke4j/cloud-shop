package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;
import club.luke.cloud.shop.app.util.V;

import javax.persistence.*;

/**
 * Created by luke on 2018/11/13.
 * 结算
 */
public class TCW_Clean extends Model {

    /**
     * 借（借来）true +   收款
     * 贷（供出）false -  付款
     * */
    private boolean jd ;

    /**金额*/
    Double num ;

    @ManyToOne
    @JoinColumn(name = "sellGoodsId",foreignKey = @ForeignKey(name = "fk_clean_sellGoods"))
    TSL_SellGoods sellGoods ;

    @Enumerated(EnumType.STRING)
    @Column(length = 10,nullable = false)
    V.PayType payType ;

    /**发生站点*/
    @ManyToOne
    @JoinColumn(name = "storeId",foreignKey = @ForeignKey(name = "fk_clean_store"))
    TU_Com store ;

    /**经手人*/
    @ManyToOne
    @JoinColumn(name = "handlerId",foreignKey = @ForeignKey(name = "fk_clean_handler"))
    TU_User handler ;

    String bz ;

    public boolean isJd() {
        return jd;
    }

    public void setJd(boolean jd) {
        this.jd = jd;
    }

    public TSL_SellGoods getSellGoods() {
        return sellGoods;
    }

    public void setSellGoods(TSL_SellGoods sellGoods) {
        this.sellGoods = sellGoods;
    }

    public V.PayType getPayType() {
        return payType;
    }

    public void setPayType(V.PayType payType) {
        this.payType = payType;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public TU_Com getStore() {
        return store;
    }

    public void setStore(TU_Com store) {
        this.store = store;
    }

    public TU_User getHandler() {
        return handler;
    }

    public void setHandler(TU_User handler) {
        this.handler = handler;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}
