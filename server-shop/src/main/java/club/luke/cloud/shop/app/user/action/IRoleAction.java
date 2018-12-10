package club.luke.cloud.shop.app.user.action;

import club.luke.cloud.shop.app.web.vo.user.VOInRole;
import club.luke.cloud.shop.app.web.vo.user.VOInRoleFun;
import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.vo.VOIn;
import club.luke.cloud.shop.app.web.vo.VOInId;
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


    /**
     * 查询所有功能，并查询角色对应的权限
     * <br>
     *     url:'role/findAllFunByRoleId.act'
     * @param request
     * @param response
     * @param actionResult
     * @param vo {id:Long-roleId}
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "findAllFunByRoleId.act",method = RequestMethod.POST)
    @ApiOperation("查询所有功能，并查询角色对应的权限")
    ActionResult findAllFunByRoleId(HttpServletRequest request,HttpServletResponse response ,ActionResult actionResult ,
                             @ApiParam(name = "查询所有功能，并查询角色对应的权限") @RequestBody @Valid
                             VOInId vo ,BindingResult bindingResult) throws Exception ;

    /**
     * 保存角色
     * <br>role/saveRole.act
     * @param request
     * @param response
     * @param actionResult
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "saveRole.act",method = RequestMethod.POST)
    @ApiOperation("保存角色）")
    ActionResult saveRole(HttpServletRequest request,HttpServletResponse response ,ActionResult actionResult ,
                             @ApiParam(name = "保存角色") @RequestBody @Valid
                             VOInRole vo ,BindingResult bindingResult) throws Exception ;

    /**
     *保存角色权限
     * <br>
     *     url:role/saveRoleFun.act
     * @param request
     * @param response
     * @param actionResult
     * @param vo                    {roleId:Long,funIds:list<Long>}
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "saveRoleFun.act",method = RequestMethod.POST)
    @ApiOperation("保存角色权限）")
    ActionResult saveRoleFun(HttpServletRequest request,HttpServletResponse response ,ActionResult actionResult ,
                             @ApiParam(name = "保存角色权限") @RequestBody @Valid
                             VOInRoleFun vo ,BindingResult bindingResult) throws Exception ;




}
