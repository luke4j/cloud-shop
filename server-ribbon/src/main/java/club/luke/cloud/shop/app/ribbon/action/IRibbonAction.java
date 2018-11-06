package club.luke.cloud.shop.app.ribbon.action;

import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.vo.VO;
import club.luke.cloud.shop.app.web.vo.VOInEmputy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by luke on 2018/11/6.
 */
@Api(value = "ribbon server api")
public interface IRibbonAction {

    @ApiOperation("welcome page")
    @RequestMapping(path = "/",method = RequestMethod.GET)
    String welcome(HttpServletRequest request ,HttpServletResponse response ,ActionResult actionResult,
                   @ApiParam @Valid
                   VOInEmputy vo,BindingResult bindingResult) throws Exception ;


    @ApiOperation("login/*")
    @RequestMapping(path = "/login/*",method = RequestMethod.GET)
    ActionResult login(HttpServletRequest request ,HttpServletResponse response ,ActionResult actionResult,
                   @ApiParam @Valid @RequestBody
                   VO vo,BindingResult bindingResult) throws Exception ;


}
