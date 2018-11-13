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
            @JoinColumn(name = "cartId",foreignKey = @ForeignKey(name = "fk_cart_cartGoods"))
    List<TSL_CartGoods> cartGoodses ;

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
