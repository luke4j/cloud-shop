package club.luke.cloud.shop.app.login.action.impl;

import club.luke.cloud.shop.app.login.action.ITestAction;
import club.luke.cloud.shop.app.login.service.ILoginService;
import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.vo.VOInEmputy;
import club.luke.cloud.shop.app.web.vo.login.VOInLogin;
import club.luke.cloud.shop.app.web.vo.login.VOOutUser;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by luke on 2018/11/8.
 */
@Controller
public class TestAction implements ITestAction {

    private static final Logger log = LoggerFactory.getLogger(LoginAction.class) ;

    @Resource
    private ILoginService loginService ;


    @Override
    public String test() throws Exception {
        return "test";
    }

    @Override
    public String welcome(HttpServletRequest request ,HttpServletResponse response ,ActionResult actionResult,
                          @ApiParam @Valid
                          VOInEmputy vo,BindingResult bindingResult)throws Exception {
        return "index";
    }


    @Override
    public ActionResult login(HttpServletRequest request, HttpServletResponse response,ActionResult actionResult,
                              @Valid @RequestBody
                              VOInLogin vo, BindingResult bindingResult) throws Exception {
        actionResult = new ActionResult() ;
        actionResult.init(request,response) ;
        VOOutUser outUser = loginService.findByloginNameAndPassword(vo) ;



        return actionResult.OK("login",outUser);
    }
}
