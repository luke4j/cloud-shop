package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;
import club.luke.cloud.shop.app.util.V;

import javax.persistence.*;

/**
 * Created by luke on 2018/11/12.
 * 销售验光
 */
@Entity
public class TC_YGMX extends Model {

    @ManyToOne
    @JoinColumn(name = "ygId",foreignKey = @ForeignKey(name = "fk_ygmx_ygd"))
    TC_YG ygd ;

    @OneToOne
    TC_YGMX_Ext ygmx_ext ;



    @Enumerated(EnumType.STRING)
    @Column(length = 10,nullable = false)
    V.EyeType eyeType ;

    @Enumerated(EnumType.STRING)
    @Column(length = 10,nullable = false)
    V.UseType useType ;



    /**是否小瞳*/
    Boolean xt ;

    /**是否主视眼*/
    Boolean zy ;

    @Column(length = 16)
    String sph ;
    @Column(length = 16)
    String cyl ;
    @Column(length = 16)
    String c_add ;
    /**三棱镜*/
    @Column(length = 16)
    String slj ;
    /**基底*/
    @Column(length = 16)
    String jd ;

    /**视轴*/
    @Column(length = 16)
    String sz ;
    /**轴位*/
    @Column(length = 16)
    String zw ;

    /**矫正视力*/
    @Column(length = 16)
    String js ;
    /**瞳高*/
    @Column(length = 16)
    String tg ;
    /**瞳距*/
    @Column(length = 16)
    String tj ;
    /**总瞳距*/
    @Column(length = 16)
    String ztj ;




    public V.EyeType getEyeType() {
        return eyeType;
    }

    public void setEyeType(V.EyeType eyeType) {
        this.eyeType = eyeType;
    }

    public V.UseType getUseType() {
        return useType;
    }

    public void setUseType(V.UseType useType) {
        this.useType = useType;
    }



    public Boolean getXt() {
        return xt;
    }

    public void setXt(Boolean xt) {
        this.xt = xt;
    }

    public String getSph() {
        return sph;
    }

    public void setSph(String sph) {
        this.sph = sph;
    }

    public String getCyl() {
        return cyl;
    }

    public void setCyl(String cyl) {
        this.cyl = cyl;
    }

    public String getC_add() {
        return c_add;
    }

    public void setC_add(String c_add) {
        this.c_add = c_add;
    }

    public String getSlj() {
        return slj;
    }

    public void setSlj(String slj) {
        this.slj = slj;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getSz() {
        return sz;
    }

    public void setSz(String sz) {
        this.sz = sz;
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public String getTg() {
        return tg;
    }

    public void setTg(String tg) {
        this.tg = tg;
    }

    public String getTj() {
        return tj;
    }

    public void setTj(String tj) {
        this.tj = tj;
    }

    public String getZtj() {
        return ztj;
    }

    public void setZtj(String ztj) {
        this.ztj = ztj;
    }

    public TC_YG getYgd() {
        return ygd;
    }

    public void setYgd(TC_YG ygd) {
        this.ygd = ygd;
    }

    public TC_YGMX_Ext getYgmx_ext() {
        return ygmx_ext;
    }

    public void setYgmx_ext(TC_YGMX_Ext ygmx_ext) {
        this.ygmx_ext = ygmx_ext;
    }

    public Boolean getZy() {
        return zy;
    }

    public void setZy(Boolean zy) {
        this.zy = zy;
    }
}
