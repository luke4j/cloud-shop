package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;
import club.luke.cloud.shop.app.util.V;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by luke on 2018/11/8.
 * 公司单位,部门
 */
@Entity
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class TU_Com extends Model {

    public TU_Com(){}
    public TU_Com(Long id,String name){
        this.id = id ;
        this.name = name ;
    }



    @Column(length = 80,nullable = false)
    private String name ;

    /**
     * 总公司，分公司，站点
     */
    @Column(length = 20,nullable = false)
    @Enumerated(EnumType.STRING)
    private V.ComKind kind = V.ComKind.站点;

    /**
     * 是否加式中心
     */
    private Boolean jg_Center = false ;

    /**
     * 是否销售站点
     */
    private Boolean xs_zd = false ;


    /**
     * 是否直营
     */
    private Boolean zy = true;

    /**
     * 是否有成品库存
     */
    private Boolean cp_kc = false ;

    /**
     * 父级id，如果是总公司这个值是 null
     */
    private Long fid  ;

    /**com地址*/
    private String addr ;
    /**com 电话*/
    @Column(length = 20)
    private String tel ;

    /**com 管理员姓名*/
    @Column(length = 20)
    private String adminName ;
    /**com 管理员电话*/
    @Column(length = 20)
    private String adminTel ;

    public Boolean getJg_Center() {
        return jg_Center;
    }

    public Boolean getXs_zd() {
        return xs_zd;
    }

    public void setXs_zd(Boolean xs_zd) {
        this.xs_zd = xs_zd;
    }

    public Boolean getZy() {
        return zy;
    }

    public void setZy(Boolean zy) {
        this.zy = zy;
    }

    public Boolean getCp_kc() {
        return cp_kc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public V.ComKind getKind() {
        return kind;
    }

    public void setKind(V.ComKind kind) {
        this.kind = kind;
    }

    public Boolean isJg_Center() {
        return jg_Center;
    }

    public void setJg_Center(Boolean jg_Center) {
        this.jg_Center = jg_Center;
    }

    public Boolean isCp_kc() {
        return cp_kc;
    }

    public void setCp_kc(Boolean cp_kc) {
        this.cp_kc = cp_kc;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminTel() {
        return adminTel;
    }

    public void setAdminTel(String adminTel) {
        this.adminTel = adminTel;
    }
}
