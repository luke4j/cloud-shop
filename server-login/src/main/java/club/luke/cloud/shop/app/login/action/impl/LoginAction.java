package club.luke.cloud.shop.app.login.action.impl;

import club.luke.cloud.shop.app.login.action.ILoginAction;
import club.luke.cloud.shop.app.login.service.ILoginService;
import club.luke.cloud.shop.app.login.vo.VOInLogin;
import club.luke.cloud.shop.app.login.vo.VOOutUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by luke on 2018/11/1.
 */
@Controller
public class LoginAction implements ILoginAction {

    private static final Logger log = LoggerFactory.getLogger(LoginAction.class) ;

    private ILoginService loginService ;


    @Override
    public String gotoLogin(HttpServletRequest request, HttpServletResponse response, VOInLogin vo,BindingResult bindingResult) throws Exception {
        log.info("===============LoginAction.gotoLogin=================");
        VOOutUser voOutUser = this.loginService.getUserByLogin(vo) ;
        return "blogger";
    }
}
