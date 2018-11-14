package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.util.V;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 * Created by luke on 2018/11/14.
 */
@Entity
public class V_KC_Goods {

    @Id
    Long kcId  ;
    Long goodsId ;
    Long kindId  ;
    Long brandId  ;
    Long versionId  ;
    Long colorId ;
    Long comId ;
    Long storeId ;

    String goodsName ;

    @Enumerated(EnumType.STRING)
    V.KcJbType kcjb ;

    Float sph ;
    Float cyl ;

    String comName ;
    String storeName ;

    Double priceIn  ;
    Double price_out ;

    Long zp_kc ;
    Long can_kc ;
    Long ci_kc ;
    Long xy_kc ;

    String kindName ;
    String brandName ;
    String versionName ;
    String colorName ;
    
    String attr1 ;
    String attr2 ;
    String attr3 ;
    String attr4 ;
    String attr5 ;
    String attr6 ;
    String attr7 ;
    String attr8 ;
    String attr9 ;
    String attr10 ;
    String attr11 ;
    String attr12 ;
    String attr13 ;
    String attr14 ;
    String attr15 ;

    public Long getKcId() {
        return kcId;
    }

    public void setKcId(Long kcId) {
        this.kcId = kcId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getKindId() {
        return kindId;
    }

    public void setKindId(Long kindId) {
        this.kindId = kindId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Double getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(Double priceIn) {
        this.priceIn = priceIn;
    }

    public Double getPrice_out() {
        return price_out;
    }

    public void setPrice_out(Double price_out) {
        this.price_out = price_out;
    }

    public Long getZp_kc() {
        return zp_kc;
    }

    public void setZp_kc(Long zp_kc) {
        this.zp_kc = zp_kc;
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

    public Long getXy_kc() {
        return xy_kc;
    }

    public void setXy_kc(Long xy_kc) {
        this.xy_kc = xy_kc;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    public String getAttr4() {
        return attr4;
    }

    public void setAttr4(String attr4) {
        this.attr4 = attr4;
    }

    public String getAttr5() {
        return attr5;
    }

    public void setAttr5(String attr5) {
        this.attr5 = attr5;
    }

    public String getAttr6() {
        return attr6;
    }

    public void setAttr6(String attr6) {
        this.attr6 = attr6;
    }

    public String getAttr7() {
        return attr7;
    }

    public void setAttr7(String attr7) {
        this.attr7 = attr7;
    }

    public String getAttr8() {
        return attr8;
    }

    public void setAttr8(String attr8) {
        this.attr8 = attr8;
    }

    public String getAttr9() {
        return attr9;
    }

    public void setAttr9(String attr9) {
        this.attr9 = attr9;
    }

    public String getAttr10() {
        return attr10;
    }

    public void setAttr10(String attr10) {
        this.attr10 = attr10;
    }

    public String getAttr11() {
        return attr11;
    }

    public void setAttr11(String attr11) {
        this.attr11 = attr11;
    }

    public String getAttr12() {
        return attr12;
    }

    public void setAttr12(String attr12) {
        this.attr12 = attr12;
    }

    public String getAttr13() {
        return attr13;
    }

    public void setAttr13(String attr13) {
        this.attr13 = attr13;
    }

    public String getAttr14() {
        return attr14;
    }

    public void setAttr14(String attr14) {
        this.attr14 = attr14;
    }

    public String getAttr15() {
        return attr15;
    }

    public void setAttr15(String attr15) {
        this.attr15 = attr15;
    }

    public V.KcJbType getKcjb() {
        return kcjb;
    }

    public void setKcjb(V.KcJbType kcjb) {
        this.kcjb = kcjb;
    }
}
