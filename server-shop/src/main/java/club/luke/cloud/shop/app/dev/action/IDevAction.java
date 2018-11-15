package club.luke.cloud.shop.app.dev.action;

import club.luke.cloud.shop.app.dev.action.vo.VOInFun;
import club.luke.cloud.shop.app.web.ActionResult;
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
 * Created by luke on 2018/11/15.
 */
@Api(value = "shop server dev api")
@RequestMapping(path = "dev")
public interface IDevAction {

    /**
     * 查询所有功能<br>
     *     url: dev/findAllCom.act
     * @param request
     * @param response
     * @param actionResult
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @ApiOperation("查询所有功能")
    @RequestMapping(path = "findAllFun.act",method = RequestMethod.POST)
    ActionResult findAllCom(HttpServletRequest request ,HttpServletResponse response ,ActionResult actionResult,
                            @ApiParam @RequestBody @Valid
                            VOInEmputy vo ,BindingResult bindingResult) throws Exception ;

    /**
     * 保存或修改功能数据<br>
     *     url: dev/editFun.act
     * @param request
     * @param response
     * @param actionResult
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @ApiOperation("查询所有功能")
    @RequestMapping(path = "editFun.act",method = RequestMethod.POST)
    ActionResult editFun(HttpServletRequest request ,HttpServletResponse response ,ActionResult actionResult,
                            @ApiParam @RequestBody @Valid
                            VOInFun vo ,BindingResult bindingResult) throws Exception ;
}
