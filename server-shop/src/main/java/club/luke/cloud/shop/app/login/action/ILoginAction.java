package club.luke.cloud.shop.app.login.action;

import club.luke.cloud.shop.app.web.vo.login.VOInEditPassword;
import club.luke.cloud.shop.app.web.vo.login.VOInLogin;
import club.luke.cloud.shop.app.web.vo.login.VOInLoginInfo;
import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.vo.VOInEmputy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by luke on 2018/11/1.
 */
@Api(value = "shop server login api")
public interface ILoginAction {

    /**
     * 首页面 <br>
     *     url: / <br>
     *     spring-mvc ModelAndView 实现
     * @param request
     * @param response
     * @param actionResult
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @ApiOperation("首页面")
    @RequestMapping(path = "/",method = RequestMethod.GET)
    ModelAndView root(HttpServletRequest request ,HttpServletResponse response ,ActionResult actionResult,
                @ApiParam
                VOInEmputy vo ,BindingResult bindingResult)throws Exception ;

    /**
     * 登录首页面，公司信息<br>
     *     url: login/findAllCom.act
     * @param request
     * @param response
     * @param actionResult
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @ApiOperation("登录首页面，公司信息")
    @RequestMapping(path = "login/findAllCom.act",method = RequestMethod.POST)
    @ResponseBody
    ActionResult findAllCom(HttpServletRequest request ,HttpServletResponse response ,ActionResult actionResult,
                            @ApiParam
                            VOInEmputy vo ,BindingResult bindingResult) throws Exception ;


    /**
     *登录方法<br>
     *     匹配登录名与密码
     *          登录成功返回用户基本信息
     *              生成登录tuken保存在redis,
     *          登录失败返回失败信息
     *
     *     <br>
     *     url:login/login.act
     *     <br>
     *     {loginName:'',password:''}
     * @param request
     * @param response
     * @param actionResult
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @ApiOperation("登录方法")
    @RequestMapping(path = "login/login.act",method = RequestMethod.POST)
    @ResponseBody
    ActionResult login(HttpServletRequest request ,HttpServletResponse response ,ActionResult actionResult,
                       @ApiParam @RequestBody @Valid
                       VOInLogin vo ,BindingResult bindingResult) throws Exception ;


    /**
     *登录后查询系统信息与个人信息,系统时间，当前操作人权限 ，信息，配置<br>
     *     url:login/getInfo.act<br>
     *         {loginTuken:''}
     * @param request
     * @param response
     * @param actionResult
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @ApiOperation("登录后查询系统信息与个人信息")
    @RequestMapping(path = "login/getInfo.act",method = RequestMethod.POST)
    @ResponseBody
    public ActionResult getInfo(HttpServletRequest request ,HttpServletResponse response ,ActionResult actionResult,
                                @ApiParam @RequestBody @Valid
                                VOInLoginInfo vo ,BindingResult bindingResult)throws Exception ;



    /**
     * 登出请求<br>
     *     url:login/logout.act<br>
     *         {loginTuken:''}
     * @param request
     * @param response
     * @param vo
     * @param bindingResult
     * @param actionResult
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "登出请求")
    @RequestMapping(path = "login/logout.act",method= RequestMethod.POST)
    @ResponseBody
    ActionResult logout(HttpServletRequest request, HttpServletResponse response,
                          @ApiParam(value = "登出请求", required = true)  @Valid @RequestBody
                          VOInLoginInfo vo, BindingResult bindingResult, ActionResult actionResult)throws Exception ;


    /**
     * 用户修改密码<br>
     *     url:login/editPassword.act<br>
     *         {password:'未加密密码',loginTuken:''}
     *
     * @param request
     * @param response
     * @param vo
     * @param bindingResult
     * @param actionResult
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "用户修改密码")
    @RequestMapping(path = "login/editPassword.act",method= RequestMethod.POST)
    @ResponseBody
    ActionResult editPassword(HttpServletRequest request, HttpServletResponse response,
                                @ApiParam(value = "用户修改密码", required = true)  @Valid @RequestBody
                                VOInEditPassword vo, BindingResult bindingResult, ActionResult actionResult)throws Exception ;

    /**
     * 用户基本信息查看<br>
     *     url:'login/getUserInfo.act'<br>
     *         {loginTuken:''}
     * @param request
     * @param response
     * @param vo
     * @param bindingResult
     * @param actionResult
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "用户基本信息查看")
    @RequestMapping(path = "login/getUserInfo.act",method= RequestMethod.POST)
    @ResponseBody
    ActionResult getUserInfo(HttpServletRequest request, HttpServletResponse response,
                               @ApiParam(value = "用户基本信息查看", required = true)  @Valid
                               VOInLoginInfo vo, BindingResult bindingResult, ActionResult actionResult)throws Exception ;



}
