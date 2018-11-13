package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by luke on 2018/11/8.
 * 用户扩展信息
 */
@Entity
public class TU_UserExt extends Model {

    @OneToOne
    @JoinColumn(name = "userId",foreignKey = @ForeignKey(name = "fk_user_ex"))
    TU_User user ;

    /**
     * 是否过期
     */
    private Boolean gq = false ;


    public TU_User getUser() {
        return user;
    }

    public void setUser(TU_User user) {
        this.user = user;
    }



}
