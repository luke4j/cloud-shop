package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;
import club.luke.cloud.shop.app.util.V;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by luke on 2018/11/19.
 * 业务编码
 */
@Entity
public class TY_Code extends Model {

    @Column(length = 40)
    String name ;

    @Column(length = 40)
    String bm ;

    @Column(length = 100)
    String info ;

    @Enumerated(EnumType.STRING)
            @Column(length = 8)
    V.GoodsState goodsState= V.GoodsState.正 ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public V.GoodsState getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(V.GoodsState goodsState) {
        this.goodsState = goodsState;
    }
}
