package club.luke.cloud.shop.app.login.action;

import club.luke.cloud.shop.app.login.vo.VOInLogin;
import club.luke.cloud.shop.app.login.vo.VOOutUser;
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
 * Created by luke on 2018/11/1.
 */
@Api(value = "login server api")
public interface ILoginAction {

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
    @RequestMapping(path = "login.act",method = RequestMethod.POST)
    VOOutUser login(HttpServletRequest request ,HttpServletResponse response ,
                    @ApiParam @RequestBody @Valid
                 VOInLogin vo,BindingResult bindingResult) throws Exception ;


    @ApiOperation("welcome page")
    @RequestMapping(path = "/",method = RequestMethod.GET)
    String welcome() ;


}
