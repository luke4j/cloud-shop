package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by luke on 2018/11/12.
 */
@Entity
public class TSL_CartGoods extends Model {

    /**购买商品*/
    @ManyToOne
    @JoinColumn(name = "goodsId",foreignKey = @ForeignKey(name = "fk_cartGodos_goods"))
    TG_Goods goods ;

    /**购买数量*/
    Long goodsNum ;

    /**购物车*/
    @ManyToOne

    TSL_Cart cart ;

    public TG_Goods getGoods() {
        return goods;
    }

    public void setGoods(TG_Goods goods) {
        this.goods = goods;
    }

    public Long getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Long goodsNum) {
        this.goodsNum = goodsNum;
    }

    public TSL_Cart getCart() {
        return cart;
    }

    public void setCart(TSL_Cart cart) {
        this.cart = cart;
    }
}
