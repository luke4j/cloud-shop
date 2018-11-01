package club.luke.cloud.shop.app.login.action;

import club.luke.cloud.shop.app.login.vo.VOInLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by luke on 2018/11/1.
 */
@Api(value = "Swagger2 在线接口文档")
public interface ILoginAction {


    @RequestMapping(path = "/gotologin" ,method = RequestMethod.GET)
    @ApiOperation(value = "只是个测试")
    @ResponseBody
    String gotoLogin(HttpServletRequest request, HttpServletResponse response, VOInLogin vo,BindingResult bindingResult) throws Exception ;



}
