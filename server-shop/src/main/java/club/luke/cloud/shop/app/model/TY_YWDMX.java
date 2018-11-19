package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.*;

/**
 * Created by luke on 2018/11/19.
 * 业务单
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class TY_YWDMX extends Model{

    @ManyToOne
    @JoinColumn(name = "goodsId")
    TG_Goods goods ;

    Float sph ;
    Float cyl ;

    @ManyToOne
    @JoinColumn(name = "kcId")
    TK_KC kc ;

    @ManyToOne
    @JoinColumn(name = "ywdId")
    TY_YWD ywd ;

    /**操作数量*/
    Long num ;

    public TG_Goods getGoods() {
        return goods;
    }

    public void setGoods(TG_Goods goods) {
        this.goods = goods;
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

    public TK_KC getKc() {
        return kc;
    }

    public void setKc(TK_KC kc) {
        this.kc = kc;
    }

    public TY_YWD getYwd() {
        return ywd;
    }

    public void setYwd(TY_YWD ywd) {
        this.ywd = ywd;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}
