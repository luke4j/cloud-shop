package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;
import club.luke.cloud.shop.app.util.V;

import javax.persistence.*;
import java.util.List;

/**
 * Created by luke on 2018/11/12.
 * 销售组
 */
@Entity
public class TSL_SellGroup extends Model{



    @Enumerated(EnumType.STRING)
    @Column(length = 10,nullable = false)
    V.GroupType groupType = V.GroupType.加工 ;

    @ManyToOne
    @JoinColumn(name = "sellId",foreignKey = @ForeignKey(name = "fk_group_sell"))
    TSL_Sell sell ;

    @ManyToOne
    @JoinColumn(name = "ygId",foreignKey = @ForeignKey(name = "fk_group_yg"))
    TC_YG yg ;

    /**验光单照片路径*/
    String ygd_photo ;
    /**验光师编码*/
    @Column(length = 20)
    String ygs_bm ;
    /**验光师姓名*/
    @Column(length = 20)
    String ygs_xm ;


    @OneToMany
    @JoinColumn(name = "sellGoodsId",foreignKey = @ForeignKey(name = "fk_sellGroup_sellGoods"))
    List<TSL_SellGoods> sellGoods ;

    /**流程位置<br>
     * 初步流程定为
     * <br>成品；服务；效期：销售制单->打印收费->完成
     *<br> 加工为：销售制单->打印收费->
     *     送至加工制单->送至加工接收->
     *     配料出库制单->配料出库->
     *     原料初检制单->原料初检->
     *     加工商品制单->加工商品->
     *     终检装盒制单->终检装盒->
     *     送至取货制单->送至取货->
     *     顾客试戴制单->顾客试戴->
     *     顾客试戴制单（收欠款）->顾客试戴->
     *     （加工商品销售）完成
     * */
    @Column(length = 20,nullable = false)
    String lcwz = "xszd" ;

    /**备注*/
    String bz ;

    public TC_YG getYg() {
        return yg;
    }

    public void setYg(TC_YG yg) {
        this.yg = yg;
    }

    public String getYgd_photo() {
        return ygd_photo;
    }

    public void setYgd_photo(String ygd_photo) {
        this.ygd_photo = ygd_photo;
    }

    public String getYgs_bm() {
        return ygs_bm;
    }

    public void setYgs_bm(String ygs_bm) {
        this.ygs_bm = ygs_bm;
    }

    public String getYgs_xm() {
        return ygs_xm;
    }

    public void setYgs_xm(String ygs_xm) {
        this.ygs_xm = ygs_xm;
    }

    public TSL_Sell getSell() {
        return sell;
    }

    public void setSell(TSL_Sell sell) {
        this.sell = sell;
    }

    public V.GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(V.GroupType groupType) {
        this.groupType = groupType;
    }

    public List<TSL_SellGoods> getSellGoods() {
        return sellGoods;
    }

    public void setSellGoods(List<TSL_SellGoods> sellGoods) {
        this.sellGoods = sellGoods;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getLcwz() {
        return lcwz;
    }

    public void setLcwz(String lcwz) {
        this.lcwz = lcwz;
    }
}
