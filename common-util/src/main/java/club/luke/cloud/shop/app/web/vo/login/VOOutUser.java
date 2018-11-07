package club.luke.cloud.shop.app.web.vo.login;

import club.luke.cloud.shop.app.web.vo.VOOut;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by luke on 2018/11/7.
 */
public class VOOutUser implements VOOut {

    @ApiModelProperty(value = "out id")
    private Long id ;

    @ApiModelProperty(value = "out name")
    private String name ;

    @ApiModelProperty(value = "out sex")
    private String sex ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
