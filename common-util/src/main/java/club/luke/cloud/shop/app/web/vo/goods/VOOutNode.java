package club.luke.cloud.shop.app.web.vo.goods;

import club.luke.cloud.shop.app.util.V;
import club.luke.cloud.shop.app.web.vo.VOOut;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luke on 2018/11/19.
 */
public class VOOutNode extends VOOut {

    @ApiModelProperty(name = "是否父结点")
    private Boolean isParent = true;
    @ApiModelProperty(name = "子结点总数")
    private Long count ;

    Long id ;
    /**父ID*/
    Long fid ;
    String name ;
    @ApiModelProperty(name = "是否度数")
    Boolean lens ;
    @ApiModelProperty(name = "是否效期")
    Boolean xq ;
    @ApiModelProperty(name = "是否实物")
    Boolean sw ;
    /***/
    String attr1 ;
    String attr2 ;
    String attr3 ;
    String attr4 ;

    String kcjb ;
    Double priceIn ;
    Double priceOut ;

    V.KindLvl kindLvl ;

    List<VOOutNode> children = new ArrayList<VOOutNode>(100);


    public V.KindLvl getKindLvl() {
        return kindLvl;
    }

    public void setKindLvl(V.KindLvl kindLvl) {
        this.kindLvl = kindLvl;
    }

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

    public String getKcjb() {
        return kcjb;
    }

    public void setKcjb(String kcjb) {
        this.kcjb = kcjb;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getLens() {
        return lens;
    }

    public void setLens(Boolean lens) {
        this.lens = lens;
    }

    public Boolean getXq() {
        return xq;
    }

    public void setXq(Boolean xq) {
        this.xq = xq;
    }

    public Boolean getSw() {
        return sw;
    }

    public void setSw(Boolean sw) {
        this.sw = sw;
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    public String getAttr4() {
        return attr4;
    }

    public void setAttr4(String attr4) {
        this.attr4 = attr4;
    }

    public List<VOOutNode> getChildren() {
        return children;
    }

    public void setChildren(List<VOOutNode> children) {
        this.children = children;
    }
}
