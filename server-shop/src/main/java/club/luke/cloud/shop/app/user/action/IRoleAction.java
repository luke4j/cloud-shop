package club.luke.cloud.shop.app.user.action;

import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.vo.VOIn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by luke on 2018/11/15.
 */

@RequestMapping(path = "role")
@Api(value = "shop server user.role api")
public interface IRoleAction {

    /**
     * 查询所有权限（带公司限制）
     * <br>
     *     url:'role/findAllRole.act'
     * @param request
     * @param response
     * @param actionResult
     * @param vo 使用登录的站点查询总公司数据
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "findAllRole.act",method = RequestMethod.POST)
    @ApiOperation("查询所有权限 （带公司限制）")
    ActionResult findAllRole(HttpServletRequest request,HttpServletResponse response ,ActionResult actionResult ,
                             @ApiParam(name = "公司限制") @RequestBody @Valid
                             VOIn vo ,BindingResult bindingResult) throws Exception ;


}
