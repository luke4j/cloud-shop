package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by luke on 2018/11/12.
 */
@Entity
public class TK_KC extends Model {

    /**公司*/
    @ManyToOne
    @JoinColumn(name = "comId",foreignKey = @ForeignKey(name = "fk_kc_com"))
    TU_Com com ;

    /**站点*/
    @ManyToOne
    @JoinColumn(name = "storeId",foreignKey = @ForeignKey(name = "fk_kc_store"))
    TU_Com store ;

    /**站点*/
    @ManyToOne
    @JoinColumn(name = "goodsId",foreignKey = @ForeignKey(name = "fk_kc_goods"))
    TG_Goods goods ;

    /**业务中使用的进货价格*/
    Double priceIn ;
    /**业务中使用的销售价格*/
    Double priceOut ;

    Long can_kc ;
    Long ci_kc ;
    Long zp_kc ;
    Long xy_kc ;

    Float sph ;
    Float cyl ;

    public TU_Com getCom() {
        return com;
    }

    public void setCom(TU_Com com) {
        this.com = com;
    }

    public TU_Com getStore() {
        return store;
    }

    public void setStore(TU_Com store) {
        this.store = store;
    }

    public TG_Goods getGoods() {
        return goods;
    }

    public void setGoods(TG_Goods goods) {
        this.goods = goods;
    }

    public Double getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(Double priceIn) {
        this.priceIn = priceIn;
    }

    public Double getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(Double priceOut) {
        this.priceOut = priceOut;
    }

    public Long getCan_kc() {
        return can_kc;
    }

    public void setCan_kc(Long can_kc) {
        this.can_kc = can_kc;
    }

    public Long getCi_kc() {
        return ci_kc;
    }

    public void setCi_kc(Long ci_kc) {
        this.ci_kc = ci_kc;
    }

    public Long getZp_kc() {
        return zp_kc;
    }

    public void setZp_kc(Long zp_kc) {
        this.zp_kc = zp_kc;
    }

    public Long getXy_kc() {
        return xy_kc;
    }

    public void setXy_kc(Long xy_kc) {
        this.xy_kc = xy_kc;
    }

    public Float getSph() {
        return sph;
    }

    public void setSph(Float sph) {
        this.sph = sph;
    }

    public Float getCyl() {
        return cyl;
    }

    public void setCyl(Float cyl) {
        this.cyl = cyl;
    }
}
