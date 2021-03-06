package club.luke.cloud.shop.app.system.action;


import club.luke.cloud.shop.app.web.vo.system.VOInKindSetup;
import club.luke.cloud.shop.app.web.vo.system.VOInNode;
import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.vo.VOInId;
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


@Api(value = "shop server kindSetupAction api")
@RequestMapping(path = "sys/kindSetup")
public interface IKindSetupAction {

    /**
     * 查询商品树<br>一级为品类，二级为品牌，三级为型号，四级为颜色，五级为商品<br>
     *     url: goods/findGoodsNode.act
     * @param request
     * @param response
     * @param actionResult
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @ApiOperation("查询商品树")
    @RequestMapping(path = "findGoodsNode.act",method = RequestMethod.POST)
    ActionResult findGoodsNode(HttpServletRequest request , HttpServletResponse response , ActionResult actionResult,
                               @ApiParam @RequestBody @Valid
                                       VOInNode vo , BindingResult bindingResult) throws Exception ;


    /**
     * 查询品类对应的商品扩展属性
     * <br>
     *     goods/findKindSetupConfig.act
     *     <br>
     *         以品类Id查询
     * @param request
     * @param response
     * @param actionResult
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @ApiOperation("查询品类对应的商品扩展属性")
    @RequestMapping(path = "findKindSetupConfig.act",method = RequestMethod.POST)
    ActionResult findKindSetupConfig(HttpServletRequest request , HttpServletResponse response , ActionResult actionResult,
                                     @ApiParam @RequestBody @Valid
                                             VOInId vo , BindingResult bindingResult) throws Exception ;

    /**
     * 修改商品品类配置属性
     * @param request
     * @param response
     * @param actionResult
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @ApiOperation("修改商品品类配置属性")
    @RequestMapping(path = "editKindSetupConfigById.act",method = RequestMethod.POST)
    ActionResult editKindSetupConfigById(HttpServletRequest request , HttpServletResponse response , ActionResult actionResult,
                                         @ApiParam @RequestBody @Valid
                                                 VOInKindSetup vo , BindingResult bindingResult) throws Exception ;
}
