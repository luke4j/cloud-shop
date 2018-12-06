package club.luke.cloud.shop.app.web.vo.login;

import club.luke.cloud.shop.app.web.vo.VOIn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by luke on 2018/11/7.
 */
@ApiModel
public class VOInLogin extends VOIn {

    @ApiModelProperty(value = "登录名" ,required = true)
    private String loginName ;
    @ApiModelProperty(value = "登录密码",required = true)
    private String password ;

    @ApiModelProperty(value = "站点ID",required = true)
    private Long comId ;



    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

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
