package club.luke.cloud.shop.app.login.action.impl;

import club.luke.cloud.shop.app.login.action.ILoginAction;
import club.luke.cloud.shop.app.login.service.ILoginService;
import club.luke.cloud.shop.app.util.tool.LK;
import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.vo.VOInEmputy;
import club.luke.cloud.shop.app.web.vo.login.VOInLogin;
import club.luke.cloud.shop.app.web.vo.login.VOOutValText;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by luke on 2018/11/1.
 */
@Controller
public class LoginAction implements ILoginAction {
    private static final Logger log = LoggerFactory.getLogger(LoginAction.class) ;

    @Resource
    ILoginService loginService;


    @Override
    public ModelAndView root(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                       @ApiParam VOInEmputy vo, BindingResult bindingResult) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        String rdm_val = LK.vilidateCode(6) ;
        String pageId = LK.uuid() ;
        mav.getModel().put(pageId, rdm_val) ;
        log.debug("url / pageId is "+pageId+"    rdm is "+rdm_val);
        loginService.rootPageIdAndRdmVal(pageId,rdm_val) ;
        return mav;
    }

    @Override
    public ActionResult findAllCom(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                                          @ApiParam VOInEmputy vo, BindingResult bindingResult) throws Exception {
        List<VOOutValText> lstVO = this.loginService.findAllCom() ;
        return actionResult.OK("登录首页面，公司信息",lstVO) ;
    }

    @Override
    public ActionResult login(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                              @ApiParam @RequestParam @Valid VOInLogin vo, BindingResult bindingResult) throws Exception {
        return null;
    }
}
