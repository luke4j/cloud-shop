package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by luke on 2018/11/1.
 */

@Entity
public class TU_User extends Model{

    @Column(length = 80,nullable = false)
    private String name ;

    @Column(length = 40,nullable = false,unique = true)
    private String loginName ;

    @Column(length = 36,nullable = false)
    private String password ;


    private Date brithday ;

    @Column(length = 20)
    private String zhi_wu ;

    @Column(length = 20)
    private String xue_li ;

    @Column(length = 20)
    private String phone ;
    @Column(length = 120)
    private String addr ;
    @Column(length = 120)
    private String photo ;

    @Column(length = 4)
    private String sex ;


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public String getZhi_wu() {
        return zhi_wu;
    }

    public void setZhi_wu(String zhi_wu) {
        this.zhi_wu = zhi_wu;
    }

    public String getXue_li() {
        return xue_li;
    }

    public void setXue_li(String xue_li) {
        this.xue_li = xue_li;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
