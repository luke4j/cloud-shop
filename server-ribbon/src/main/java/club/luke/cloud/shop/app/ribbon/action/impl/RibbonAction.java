package club.luke.cloud.shop.app.ribbon.action.impl;

import club.luke.cloud.shop.app.ribbon.action.IRibbonAction;
import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.vo.VO;
import club.luke.cloud.shop.app.web.vo.VOInEmputy;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by luke on 2018/11/6.
 */
@Controller
public class RibbonAction implements IRibbonAction {

    @Resource(name = "login-service-restTemplate")
    RestTemplate loginRestTemplate ;


    @Override
    public String welcome(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                          @ApiParam @Valid VOInEmputy vo, BindingResult bindingResult) throws Exception {
        return this.loginRestTemplate.getForObject("http://SERVER-LOGIN/",String.class,vo);
    }

    @Override
    public ActionResult login(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                              @ApiParam @Valid @RequestBody VO vo, BindingResult bindingResult) throws Exception {
        return null;
    }
}
