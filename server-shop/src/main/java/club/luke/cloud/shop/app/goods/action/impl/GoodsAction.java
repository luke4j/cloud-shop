package club.luke.cloud.shop.app.goods.action.impl;

import club.luke.cloud.shop.app.goods.action.IGoodsAction;
import club.luke.cloud.shop.app.goods.action.vo.VOInKindAndGoods;
import club.luke.cloud.shop.app.goods.action.vo.VOInNode;
import club.luke.cloud.shop.app.goods.action.vo.VOOutNode;
import club.luke.cloud.shop.app.goods.service.IGoodsService;
import club.luke.cloud.shop.app.model.TG_Kind_Setup;
import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.vo.VOInId;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by luke on 2018/11/19.
 */
@RestController
public class GoodsAction implements IGoodsAction {

    @Resource
    IGoodsService goodsService ;

    @Override
    public ActionResult findGoodsNode(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                                      @ApiParam @RequestBody @Valid VOInNode vo, BindingResult bindingResult) throws Exception {
        List<VOOutNode> lstKind = this.goodsService.findGoodsNode(vo) ;
        return actionResult.OK("查询商品树",lstKind);
    }

    @Override
    public ActionResult addKindAndGoods(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                                        @ApiParam @RequestBody @Valid
                                        VOInKindAndGoods vo, BindingResult bindingResult) throws Exception {
        this.goodsService.addKindAndGoods(vo) ;
        return actionResult.OK("添加品类品牌型号颜色商品");
    }

    @Override
    public ActionResult findKindSetupByKindId(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                                              @ApiParam @RequestBody @Valid
                                              VOInId vo, BindingResult bindingResult) throws Exception {
        List<TG_Kind_Setup> lstKindSetups = this.goodsService.findKindSetupByKindId(vo) ;
        return actionResult.OK("以品类id查询出所需要的商品扩展属性配置",lstKindSetups);
    }
}
