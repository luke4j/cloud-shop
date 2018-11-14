package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;
import club.luke.cloud.shop.app.util.V;

import javax.persistence.*;

/**
 * Created by luke on 2018/11/12.
 */
@Entity
public class TG_Goods extends Model{

    @Column(length = 40,nullable = false)
    String name ;

    @ManyToOne
    @JoinColumn(name = "kindId",foreignKey = @ForeignKey(name = "fk_goods_kind"))
    TG_Kind kind ;

    @ManyToOne
    @JoinColumn(name = "brandId",foreignKey = @ForeignKey(name = "fk_goods_brand"))
    TG_Kind brand ;

    @ManyToOne
    @JoinColumn(name = "versionId",foreignKey = @ForeignKey(name = "fk_goods_version"))
    TG_Kind version ;

    @ManyToOne
    @JoinColumn(name = "colorId",foreignKey = @ForeignKey(name = "fk_goods_color"))
    TG_Kind color ;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    V.KcJbType kcjb = V.KcJbType.现库 ;

    /**进货价，做为商品录入时录入的公司统一进货价，不会在页面显示，只做写入库存时进货价的标准，非直营站点可能会上浮*/
    Double priceIn ;
    /**销售价，做为商品录入时录入的公司统一销售价，不会在页面显示 ，只做写入库存时销售价格标准，有此站点对某些商品会做其它价格处理*/
    Double priceOut ;

    public Double getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(Double priceIn) {
        this.priceIn = priceIn;
    }

    public Double getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(Double priceOut) {
        this.priceOut = priceOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TG_Kind getKind() {
        return kind;
    }

    public void setKind(TG_Kind kind) {
        this.kind = kind;
    }

    public TG_Kind getBrand() {
        return brand;
    }

    public void setBrand(TG_Kind brand) {
        this.brand = brand;
    }

    public TG_Kind getVersion() {
        return version;
    }

    public void setVersion(TG_Kind version) {
        this.version = version;
    }

    public TG_Kind getColor() {
        return color;
    }

    public void setColor(TG_Kind color) {
        this.color = color;
    }

    public V.KcJbType getKcjb() {
        return kcjb;
    }

    public void setKcjb(V.KcJbType kcjb) {
        this.kcjb = kcjb;
    }
}
