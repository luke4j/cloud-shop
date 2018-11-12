package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by luke on 2018/11/12.
 * 验光单
 */
@Entity
public class TC_YGD extends Model{

    /**验光类型*/
    public enum YGType{
        /**电脑验光*/
        dn_yg,
        /**检影验光*/
        jy_yg,
        /**精调验光*/
        jt_yg,
        /**处方*/
        cf,
        /**销售单使用*/
        xsd
    }


    /**验光师，或销售员*/
    @ManyToOne
    @JoinColumn(name = "ygsId",foreignKey = @ForeignKey(name = "fk_yg_ygs"))
    TU_User ygs ;


    /**顾客*/
    @ManyToOne
    @JoinColumn(name = "customerId",foreignKey = @ForeignKey(name = "fk_yg_customer"))
    TC_Customer customer ;



    @Enumerated(EnumType.STRING)
    @Column(length = 10,nullable = false)
    YGType ygType ;


    @OneToMany
    List<TC_YGMX> ygmx ;


    /**一次诊断*/
    private String zd1 ;
    /**二次诊断*/
    private String zd2 ;
    /**三次诊断*/
    private String zd3 ;
    /**四次诊断*/
    private String zd4 ;
    /**五次诊断*/
    private String zd5 ;




    public YGType getYgType() {
        return ygType;
    }

    public void setYgType(YGType ygType) {
        this.ygType = ygType;
    }


    public TU_User getYgs() {
        return ygs;
    }

    public void setYgs(TU_User ygs) {
        this.ygs = ygs;
    }

    public TC_Customer getCustomer() {
        return customer;
    }

    public void setCustomer(TC_Customer customer) {
        this.customer = customer;
    }

    public List<TC_YGMX> getYgmx() {
        return ygmx;
    }

    public void setYgmx(List<TC_YGMX> ygmx) {
        this.ygmx = ygmx;
    }

    public String getZd1() {
        return zd1;
    }

    public void setZd1(String zd1) {
        this.zd1 = zd1;
    }

    public String getZd2() {
        return zd2;
    }

    public void setZd2(String zd2) {
        this.zd2 = zd2;
    }

    public String getZd3() {
        return zd3;
    }

    public void setZd3(String zd3) {
        this.zd3 = zd3;
    }

    public String getZd4() {
        return zd4;
    }

    public void setZd4(String zd4) {
        this.zd4 = zd4;
    }

    public String getZd5() {
        return zd5;
    }

    public void setZd5(String zd5) {
        this.zd5 = zd5;
    }
}
