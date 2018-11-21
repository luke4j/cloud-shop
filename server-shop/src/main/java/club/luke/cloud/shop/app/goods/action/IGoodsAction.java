package club.luke.cloud.shop.app.goods.action;

import club.luke.cloud.shop.app.goods.action.vo.VOInKindAndGoods;
import club.luke.cloud.shop.app.goods.action.vo.VOInNode;
import club.luke.cloud.shop.app.web.ActionResult;
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
 * Created by luke on 2018/11/19.
 */
@Api(value = "shop server goods api")
@RequestMapping(path = "goods")
public interface IGoodsAction {

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
    ActionResult findGoodsNode(HttpServletRequest request ,HttpServletResponse response ,ActionResult actionResult,
                            @ApiParam @RequestBody @Valid
                            VOInNode vo ,BindingResult bindingResult) throws Exception ;


    /**
     * 添加品类品牌型号颜色商品
     * <br>
     *     url:goods/addKindAndGoods.act
     *     <br>
     *         以kindLel为标志，品类就是添加品类，商品就是添加商品
     * @param request
     * @param response
     * @param actionResult
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @ApiOperation("添加品类品牌型号颜色商品")
    @RequestMapping(path = "addKindAndGoods.act",method = RequestMethod.POST)
    ActionResult addKindAndGoods(HttpServletRequest request , HttpServletResponse response , ActionResult actionResult,
                         @ApiParam @RequestBody @Valid
                                 VOInKindAndGoods vo , BindingResult bindingResult) throws Exception ;



}
