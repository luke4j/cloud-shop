package club.luke.cloud.shop.app.login.vo;

import club.luke.cloud.shop.app.web.Page;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by luke on 2018/11/1.
 */
public class VOInLogin extends Page  {

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
