package club.luke.cloud.shop.app.web.vo.goods;

import club.luke.cloud.shop.app.util.V;
import club.luke.cloud.shop.app.web.vo.VOIn;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class VOInKindAndGoods extends VOIn {

    /**父ID*/
    Long fid ;
    Long id ;
    String name ;

    /**是否度数*/
    Boolean lens ;

    /**是否效期（隐形为带效期商品）*/
    Boolean xq ;

    /**是否实物（检查不是实惠）*/
    Boolean sw ;

    /**级别，1级为品类，2级为品牌，3级为型号，4级为颜色，5级为商品*/
    @NotNull(message = "类型级别不能为空")
    V.KindLvl kindLvl;
    V.KcJbType kcjb ;

    /**进货价，做为商品录入时录入的公司统一进货价，不会在页面显示，只做写入库存时进货价的标准，非直营站点可能会上浮*/
    Double priceIn ;
    /**销售价，做为商品录入时录入的公司统一销售价，不会在页面显示 ，只做写入库存时销售价格标准，有此站点对某些商品会做其它价格处理*/
    Double priceOut ;

    /**存放位置 - 加工中心是否存放*/
    Boolean jg_center_cf ;
    /**存放位置 - 销售站点是否存放*/
    Boolean xs_zd_cf ;

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


    public Boolean getJg_center_cf() {
        return jg_center_cf;
    }

    public void setJg_center_cf(Boolean jg_center_cf) {
        this.jg_center_cf = jg_center_cf;
    }

    public Boolean getXs_zd_cf() {
        return xs_zd_cf;
    }

    public void setXs_zd_cf(Boolean xs_zd_cf) {
        this.xs_zd_cf = xs_zd_cf;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getLens() {
        return lens;
    }

    public void setLens(Boolean lens) {
        this.lens = lens;
    }

    public Boolean getXq() {
        return xq;
    }

    public void setXq(Boolean xq) {
        this.xq = xq;
    }

    public Boolean getSw() {
        return sw;
    }

    public void setSw(Boolean sw) {
        this.sw = sw;
    }

    public V.KindLvl getKindLvl() {
        return kindLvl;
    }

    public void setKindLvl(V.KindLvl kindLvl) {
        this.kindLvl = kindLvl;
    }

    public V.KcJbType getKcjb() {
        return kcjb;
    }

    public void setKcjb(V.KcJbType kcjb) {
        this.kcjb = kcjb;
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
}
