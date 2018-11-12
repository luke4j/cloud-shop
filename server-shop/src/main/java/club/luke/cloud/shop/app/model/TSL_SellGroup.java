package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by luke on 2018/11/12.
 * 销售组
 */
@Entity
public class TSL_SellGroup extends Model{

    public enum GroupType{
        /**加工*/
        jg,
        /**成品*/
        cp,
        /**效期*/
        xq,
        /**服务*/
        fw
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 10,nullable = false)
    GroupType groupType = GroupType.jg ;

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

    /**
     *销售查询时所使用的验光数据
     */
    @OneToOne
    @JoinColumn(name = "sell_yg_id",foreignKey = @ForeignKey(name = "fk_sellGroup_sellYG"))
    TC_YGMX sell_yg ;





    public GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(GroupType groupType) {
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
