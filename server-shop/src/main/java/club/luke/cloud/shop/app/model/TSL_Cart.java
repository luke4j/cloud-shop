package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by luke on 2018/11/12.
 * 购物车
 */
@Entity
public class TSL_Cart extends Model {



    /**谁的购物车*/
    @OneToOne
    @JoinColumn(name = "userId",foreignKey = @ForeignKey(name = "TSL_Cart_User"))
    TU_User user ;

    @Column(length = 40,nullable = false)
    String name ;

    @OneToMany
    /**one2many 在后一个中建关系列,这里是生成表中列的名字*/
    @JoinColumn(name = "cartId",foreignKey = @ForeignKey(name = "fk_cartGoods_cart"))
    List<TSL_CartGoods> cartGoodses ;

//    @OneToMany
//    @JoinColumn(name = "sellId",foreignKey = @ForeignKey(name = "fk_group_sell"))
//    List<TSL_SellGroup> sellGroup ;

    public TU_User getUser() {
        return user;
    }

    public void setUser(TU_User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TSL_CartGoods> getCartGoodses() {
        return cartGoodses;
    }

    public void setCartGoodses(List<TSL_CartGoods> cartGoodses) {
        this.cartGoodses = cartGoodses;
    }
}
