package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by luke on 2018/11/8.
 * 公司单位,部门
 */
@Entity
public class TU_Com extends Model {


    public enum ComKind{
        /**总公司*/
        zgs,
        /**分公司*/
        fgs,
        /**站点*/
        zd
    }


    @Column(length = 80,nullable = false)
    private String name ;

    /**
     * 总公司，分公司，站点
     */
    @Column(length = 20,nullable = false)
    @Enumerated(EnumType.STRING)
    private ComKind kind = ComKind.zd;

    /**
     * 是否加式中心
     */
    private Boolean jg_Center = false ;

    /**
     * 是否有镜片库存
     */
    private Boolean jp_kc = false ;

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
    private String tel ;

    /**com 管理员姓名*/
    private String adminName ;
    /**com 管理员电话*/
    private String adminTel ;

    public Boolean getJg_Center() {
        return jg_Center;
    }

    public Boolean getJp_kc() {
        return jp_kc;
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

    public ComKind getKind() {
        return kind;
    }

    public void setKind(ComKind kind) {
        this.kind = kind;
    }

    public Boolean isJg_Center() {
        return jg_Center;
    }

    public void setJg_Center(Boolean jg_Center) {
        this.jg_Center = jg_Center;
    }

    public Boolean isJp_kc() {
        return jp_kc;
    }

    public void setJp_kc(Boolean jp_kc) {
        this.jp_kc = jp_kc;
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
