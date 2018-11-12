package club.luke.cloud.shop.app.login.action.impl;

import club.luke.cloud.shop.app.login.action.ILoginAction;
import club.luke.cloud.shop.app.login.action.vo.*;
import club.luke.cloud.shop.app.login.service.ILoginService;
import club.luke.cloud.shop.app.model.TU_User;
import club.luke.cloud.shop.app.util.tool.Assertion;
import club.luke.cloud.shop.app.util.tool.LK;
import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.action.BaseAction;
import club.luke.cloud.shop.app.web.vo.VOInEmputy;
import club.luke.cloud.shop.app.web.vo.VORedisUser;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luke on 2018/11/1.
 */
@Controller
public class LoginAction extends BaseAction implements ILoginAction {
    private static final Logger log = LoggerFactory.getLogger(LoginAction.class) ;

    @Resource
    ILoginService loginService;


    @Override
    public ModelAndView root(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                       @ApiParam VOInEmputy vo, BindingResult bindingResult) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        String rdm_val = LK.vilidateCode(6) ;
        String pageId = "rdm_val-"+LK.uuid() ;
        mav.getModel().put(pageId, rdm_val) ;
        log.debug("url / pageId is "+pageId+"    rdm is "+rdm_val);
        loginService.rootPageIdAndRdmVal(pageId,rdm_val) ;
        return mav;
    }

    @Override
    public ActionResult findAllCom(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                                          @ApiParam
                                          VOInEmputy vo, BindingResult bindingResult) throws Exception {
        List<VOOutValText> lstVO = this.loginService.findAllCom() ;
        return actionResult.OK("登录首页面，公司信息",lstVO) ;
    }

    @Override
    public ActionResult login(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                              @RequestBody @Valid
                              VOInLogin vo, BindingResult bindingResult) throws Exception {
        VOOutUser voOutUser = this.loginService.findByLoginNameAndPassword(vo);
        return actionResult.OK("登录",voOutUser);
    }

    @Override
    public ActionResult getInfo(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                                @ApiParam @RequestBody @Valid
                                VOInLoginInfo vo, BindingResult bindingResult) throws Exception {
        VORedisUser voRedisUser = this.getRedisUser(vo) ;
        Map<String,Object> result = this.loginService.getInfo(voRedisUser) ;
        return actionResult.OK("登录后查询系统信息与个人信息,系统时间，当前操作人权限 ，信息，配置",result) ;
    }

    @Override
    public ActionResult logout(HttpServletRequest request, HttpServletResponse response,
                               @ApiParam(value = "登出请求", required = true) @Valid @RequestBody
                               VOInLoginInfo vo, BindingResult bindingResult, ActionResult actionResult) throws Exception {
        return null;
    }

    @Override
    public ActionResult editPassword(HttpServletRequest request, HttpServletResponse response, @ApiParam(value = "用户修改密码", required = true) @Valid @RequestBody VOInEditPassword vo, BindingResult bindingResult, ActionResult actionResult) throws Exception {
        return null;
    }

    @Override
    public ActionResult getUserInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam(value = "用户基本信息查看", required = true) @Valid VOInLoginInfo vo, BindingResult bindingResult, ActionResult actionResult) throws Exception {
        return null;
    }
}
