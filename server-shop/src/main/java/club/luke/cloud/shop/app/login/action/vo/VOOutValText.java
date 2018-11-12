package club.luke.cloud.shop.app.login.action.vo;

import club.luke.cloud.shop.app.web.vo.VOOut;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by luke on 2018/11/8.
 */
public class VOOutValText implements VOOut {
    @ApiModelProperty("select option value")
    String val ;
    @ApiModelProperty("select option text")
    String text ;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
