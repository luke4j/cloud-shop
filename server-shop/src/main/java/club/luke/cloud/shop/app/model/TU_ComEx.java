package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;
import sun.security.util.Length;

import javax.persistence.*;

/**
 * Created by luke on 2018/11/8.
 * 部门扩展信息
 */
@Entity
public class TU_ComEx  extends Model{

    @OneToOne
    @JoinColumn(name = "comId",foreignKey = @ForeignKey(name = "fk_comex_com"),nullable = false)
    private TU_Com com ;

    /**是否试用*/
    private boolean test ;

    @Column(length = 20,nullable = false)
    private String amdinLoginName ;
    @Column(length = 20,nullable = false)
    private String adminPassword ;

    /**是否启用结转*/
    private boolean ymjz = false ;
    /**结转日期*/
    @Column(length = 20,nullable = false)
    private String ymjz_riqi = "yyyy-mm-01" ;

    /**当前结转月*/
    @Column(length = 20,nullable = false)
    private String dq_jzy = "yyyy-mm" ;


    public TU_Com getCom() {
        return com;
    }

    public void setCom(TU_Com com) {
        this.com = com;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public String getAmdinLoginName() {
        return amdinLoginName;
    }

    public void setAmdinLoginName(String amdinLoginName) {
        this.amdinLoginName = amdinLoginName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public boolean isYmjz() {
        return ymjz;
    }

    public void setYmjz(boolean ymjz) {
        this.ymjz = ymjz;
    }

    public String getYmjz_riqi() {
        return ymjz_riqi;
    }

    public void setYmjz_riqi(String ymjz_riqi) {
        this.ymjz_riqi = ymjz_riqi;
    }

    public String getDq_jzy() {
        return dq_jzy;
    }

    public void setDq_jzy(String dq_jzy) {
        this.dq_jzy = dq_jzy;
    }
}
