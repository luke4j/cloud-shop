package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;
import club.luke.cloud.shop.app.util.V;

import javax.persistence.*;

/**
 * Created by luke on 2018/11/13.
 *  商品品类控制着商品的扩展属性，这里记录着每个品类扩展属性的意义
 */
@Entity
public class TG_Kind_Setup extends Model {


    @ManyToOne
    @JoinColumn(name = "kindId",foreignKey = @ForeignKey(name = "fk_kindSetup_kind"))
    TG_Kind kind ;

    /**表中的列名，见表 TG_Godos_Ext.attr**/
    @Column(length = 10)
    String name ;
    /**列所代表的意义*/
    @Column(length = 30)
    String msg ;


    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    V.HtmlType htmlType = V.HtmlType.input ;

    String defVal  ;

    public TG_Kind getKind() {
        return kind;
    }

    public void setKind(TG_Kind kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public V.HtmlType getHtmlType() {
        return htmlType;
    }

    public void setHtmlType(V.HtmlType htmlType) {
        this.htmlType = htmlType;
    }

    public String getDefVal() {
        return defVal;
    }

    public void setDefVal(String defVal) {
        this.defVal = defVal;
    }
}
