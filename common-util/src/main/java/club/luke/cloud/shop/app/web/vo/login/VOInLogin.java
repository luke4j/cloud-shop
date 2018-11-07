package club.luke.cloud.shop.app.web.vo.login;

import club.luke.cloud.shop.app.web.vo.VOIn;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by luke on 2018/11/7.
 */
public class VOInLogin extends VOIn {

    @ApiModelProperty(value = "登录名" ,required = true)
    private String loginName ;
    @ApiModelProperty(value = "登录密码",required = true)
    private String password ;


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
