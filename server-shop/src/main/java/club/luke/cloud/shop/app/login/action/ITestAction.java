package club.luke.cloud.shop.app.login.action;

import club.luke.cloud.shop.app.login.action.vo.VOInLogin;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by luke on 2018/11/8.
 */
@Api(value = "shop server test api")
public interface ITestAction {

    @RequestMapping(value = "/test.act" ,method = RequestMethod.POST)
    @ResponseBody
    String test() throws Exception ;


    @ApiOperation("welcome page")
//    @RequestMapping(path = "/",method = RequestMethod.GET)
    String welcome(HttpServletRequest request ,HttpServletResponse response ,ActionResult actionResult,
                   @ApiParam @Valid
                   VOInEmputy vo,BindingResult bindingResult) throws Exception ;

    /**
     * 用户登录
     * @param request
     * @param response
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @ApiOperation("用户登录")
    @ResponseBody
    @RequestMapping(path = "test/login.act",method = RequestMethod.POST)
    ActionResult login(HttpServletRequest request ,HttpServletResponse response ,ActionResult actionResult,
                       @ApiParam @RequestBody @Valid
                       VOInLogin vo,BindingResult bindingResult) throws Exception ;

}
