package club.luke.cloud.shop.app.login.action.vo;

import club.luke.cloud.shop.app.web.vo.VOIn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by luke on 2018/11/9.
 */
@ApiModel
public class VOInLoginInfo extends VOIn {

    @ApiModelProperty(value = "登录标志存在redis缓存，存在8*60分钟")
    private String loginTuken ;

    @ApiModelProperty(value = "user id")
    private Long id ;

    @ApiModelProperty(value = "用户登录密码，这个是md5加密后的")
    private String password ;

    @ApiModelProperty(value = "登录名")
    private String loginName ;

    @ApiModelProperty(value = "登录站点")
    private String com_id ;


    public String getLoginTuken() {
        return loginTuken;
    }

    public void setLoginTuken(String loginTuken) {
        this.loginTuken = loginTuken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getCom_id() {
        return com_id;
    }

    public void setCom_id(String com_id) {
        this.com_id = com_id;
    }
}
