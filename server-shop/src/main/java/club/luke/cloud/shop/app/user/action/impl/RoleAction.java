package club.luke.cloud.shop.app.user.action.impl;

import club.luke.cloud.shop.app.model.TU_Role;
import club.luke.cloud.shop.app.user.action.IRoleAction;
import club.luke.cloud.shop.app.user.service.IRoleService;
import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.action.BaseAction;
import club.luke.cloud.shop.app.web.vo.VOIn;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by luke on 2018/11/15.
 */
@RestController
public class RoleAction extends BaseAction  implements IRoleAction{

    @Resource
    IRoleService roleService ;

    @Override
    public ActionResult findAllRole(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                                    @ApiParam(name = "公司限制") @RequestBody @Valid
                                    VOIn vo, BindingResult bindingResult) throws Exception {
        List<TU_Role> lstRole = roleService.findAllRole(vo) ;
        return actionResult.OK("查询所有权限（带公司限制）",lstRole);
    }
}
