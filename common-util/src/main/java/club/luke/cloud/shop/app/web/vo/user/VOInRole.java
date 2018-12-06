package club.luke.cloud.shop.app.web.vo.user;

import club.luke.cloud.shop.app.web.vo.VOIn;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by luke on 2018/11/16.
 */
public class VOInRole extends VOIn {

    @ApiModelProperty(name = "角色名",required = true)
    @NotEmpty
    String name ;

    @ApiModelProperty(name = "角色备注",required = true)
    String bz ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}
