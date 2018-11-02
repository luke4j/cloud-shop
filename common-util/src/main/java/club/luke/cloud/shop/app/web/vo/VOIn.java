package club.luke.cloud.shop.app.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by luke on 2018/11/2.
 */
@ApiModel
public class VOIn implements VO {

    @ApiModelProperty(name = "用户目标地址")
    private String srcUrl ;
    @ApiModelProperty(name = "合法用户标识")
    private String userTuken ;

    public String getSrcUrl() {
        return srcUrl;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }

    public String getUserTuken() {
        return userTuken;
    }

    public void setUserTuken(String userTuken) {
        this.userTuken = userTuken;
    }
}
