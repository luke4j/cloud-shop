package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.*;

/**
 * Created by luke on 2018/11/13.
 * 商品扩展属性
 */
@Entity
public class TG_Goods_Ext extends Model {

    @OneToOne
    @JoinColumn(name = "goodsId",foreignKey = @ForeignKey(name = "fk_goodsExt_goods"))
    TG_Goods goods ;

    @Column(length = 40)
    String attr1 ;
    @Column(length = 40)
    String attr2 ;
    @Column(length = 40)
    String attr3 ;
    @Column(length = 40)
    String attr4 ;
    @Column(length = 40)
    String attr5 ;
    @Column(length = 40)
    String attr6 ;
    @Column(length = 40)
    String attr7 ;
    @Column(length = 40)
    String attr8 ;
    @Column(length = 40)
    String attr9 ;
    @Column(length = 40)
    String attr10 ;
    @Column(length = 40)
    String attr11 ;
    @Column(length = 40)
    String attr12 ;
    @Column(length = 40)
    String attr13 ;
    @Column(length = 40)
    String attr14 ;
    @Column(length = 40)
    String attr15 ;


    public TG_Goods getGoods() {
        return goods;
    }

    public void setGoods(TG_Goods goods) {
        this.goods = goods;
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
