package club.luke.cloud.shop.app.ribbon.action.impl;

import club.luke.cloud.shop.app.ribbon.action.IRibbonAction;
import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.vo.VOInEmputy;
import club.luke.cloud.shop.app.web.vo.login.VOInLogin;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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

    private static final Logger log = LoggerFactory.getLogger(RibbonAction.class) ;



    @Resource(name = "login-service-restTemplate")
    RestTemplate loginRestTemplate ;


    @Override
    public String test() throws Exception {
        log.info("================================ribbon test") ;
        return this.loginRestTemplate.getForObject("http://SERVER-LOGIN/test.act",String.class);
    }

    @Override
    public String welcome(HttpServletRequest request, HttpServletResponse response,
                          @ApiParam @Valid VOInEmputy vo) throws Exception {
        log.info("================================ribbon login-welcome") ;
        return this.loginRestTemplate.getForObject("http://SERVER-LOGIN/",String.class,vo);
    }

    @Override
    public ActionResult login(HttpServletRequest request, HttpServletResponse response,
                              @ApiParam @Valid @RequestBody VOInLogin vo) throws Exception {
        log.info("================================ribbon login-login") ;

        return this.loginRestTemplate.postForObject("http://SERVER-LOGIN/login/login.act", vo, ActionResult.class );


    }
}
