package club.luke.cloud.shop.app.login.action;

import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.vo.VOInEmputy;
import club.luke.cloud.shop.app.web.vo.login.VOInLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
     *     url: login/findAllCmpToCombo.act
     * @param request
     * @param response
     * @param actionResult
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @ApiOperation("登录首页面，公司信息")
    @RequestMapping(path = "login/findAllCmpToCombo.act",method = RequestMethod.POST)
    ActionResult findAllCom(HttpServletRequest request ,HttpServletResponse response ,ActionResult actionResult,
                            @ApiParam
                            VOInEmputy vo ,BindingResult bindingResult) throws Exception ;


    /**
     *登录方法<br>
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
    @RequestMapping(path = "login/login.act")
    ActionResult login(HttpServletRequest request ,HttpServletResponse response ,ActionResult actionResult,
                       @ApiParam @RequestParam @Valid
                       VOInLogin vo ,BindingResult bindingResult) throws Exception ;






}
