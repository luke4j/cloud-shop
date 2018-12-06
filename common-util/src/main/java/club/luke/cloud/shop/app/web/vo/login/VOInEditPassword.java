package club.luke.cloud.shop.app.web.vo.login;

import club.luke.cloud.shop.app.web.vo.VOIn;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by luke on 2018/11/12.
 */
public class VOInEditPassword extends VOIn {

    @ApiModelProperty(value = "新密码(md5加密后的密码)" ,required = true)
    String password ;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
