package club.luke.cloud.shop.app.web.vo.system;

import club.luke.cloud.shop.app.web.vo.VOIn;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by luke on 2018/11/19.
 */
public class VOInNode extends VOIn {

    @ApiModelProperty(name = "商品级别")
    String kindLvl ;

    @ApiModelProperty(name = "父级ID")
    Long fid ;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getKindLvl() {
        return kindLvl;
    }

    public void setKindLvl(String kindLvl) {
        this.kindLvl = kindLvl;
    }
}
