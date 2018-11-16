package club.luke.cloud.shop.app.user.action.vo;

import club.luke.cloud.shop.app.web.vo.VOIn;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by luke on 2018/11/16.
 */
public class VOInRoleFun extends VOIn {

    @ApiModelProperty(name = "角色ID",required = true)
    @NotNull
    Long roleId ;

    @ApiModelProperty(name = "功能ID",required = true)
    @NotNull
    List<Long> funIds ;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getFunIds() {
        return funIds;
    }

    public void setFunIds(List<Long> funIds) {
        this.funIds = funIds;
    }
}
