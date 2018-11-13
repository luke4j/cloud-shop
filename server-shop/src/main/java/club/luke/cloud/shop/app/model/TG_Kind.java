package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by luke on 2018/11/13.
 * 商品品类，品牌，型号，辞色
 */
@Entity
public class TG_Kind extends Model {

    /**父ID*/
    Long fid ;
    @Column(length = 45)
    String name ;



    /**是否度数*/
    Boolean lens ;

    /**是否效期（隐形为带效期商品）*/
    Boolean xq ;

    /**是否实物（检查不是实惠）*/
    Boolean sw ;

    /***/
    String attr1 ;
    String attr2 ;
    String attr3 ;
    String attr4 ;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
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
}
