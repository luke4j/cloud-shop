package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by luke on 2018/11/12.
 * 销售单
 *
 * 一销售单可饰物多个销售组，一个销售组可包括多个商品，销售单不直接查询销售商品
 *
 *
 */
@Entity
public class TSL_Sell extends Model {

    /**销售员*/
    @ManyToOne
    @JoinColumn(name = "userId",foreignKey = @ForeignKey(name = "fk_sell_user"))
    TU_User user ;

    /**消费者*/
    @ManyToOne
    @JoinColumn(name = "customer",foreignKey = @ForeignKey(name = "fk_sell_customer"))
    TC_Customer customer ;


    /**销售站点*/
    @ManyToOne
    @JoinColumn(name = "customer",foreignKey = @ForeignKey(name = "fk_sell_bugCom"))
    TU_Com buyCom;

    /**取货站点*/
    @ManyToOne
    @JoinColumn(name = "customer",foreignKey = @ForeignKey(name = "fk_sell_bugCom"))
    TU_Com pickupCom;

    /**取货时间*/
    Date pickTime ;

    @OneToMany
    @JoinColumn(name = "sellGroupId",foreignKey = @ForeignKey(name = "fk_sell_group"))
    List<TSL_SellGroup> sellGroup ;


    public TU_User getUser() {
        return user;
    }

    public void setUser(TU_User user) {
        this.user = user;
    }

    public TC_Customer getCustomer() {
        return customer;
    }

    public void setCustomer(TC_Customer customer) {
        this.customer = customer;
    }

    public TU_Com getBuyCom() {
        return buyCom;
    }

    public void setBuyCom(TU_Com buyCom) {
        this.buyCom = buyCom;
    }

    public TU_Com getPickupCom() {
        return pickupCom;
    }

    public void setPickupCom(TU_Com pickupCom) {
        this.pickupCom = pickupCom;
    }

    public Date getPickTime() {
        return pickTime;
    }

    public void setPickTime(Date pickTime) {
        this.pickTime = pickTime;
    }

    public List<TSL_SellGroup> getSellGroup() {
        return sellGroup;
    }

    public void setSellGroup(List<TSL_SellGroup> sellGroup) {
        this.sellGroup = sellGroup;
    }
}
