package club.luke.cloud.shop.app.ribbon.action;

import club.luke.cloud.shop.app.web.vo.VOInEmputy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by luke on 2018/11/6.
 */
@Api(value = "ribbon server api")
public interface IRibbonAction {



    @RequestMapping(value = "/test.act",method = RequestMethod.POST)
    @ResponseBody
    String test() throws Exception ;

    @ApiOperation("welcome page")
    @RequestMapping(path = "/",method = RequestMethod.GET)
    @ResponseBody
    String welcome(HttpServletRequest request ,HttpServletResponse response ,
                   @ApiParam @Valid
                   VOInEmputy vo) throws Exception ;




}
