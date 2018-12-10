package club.luke.cloud.shop.app.system.action.impl;


import club.luke.cloud.shop.app.model.TG_Kind_Setup;
import club.luke.cloud.shop.app.system.action.IKindSetupAction;
import club.luke.cloud.shop.app.web.vo.system.VOInKindSetup;
import club.luke.cloud.shop.app.web.vo.system.VOInNode;
import club.luke.cloud.shop.app.web.vo.system.VOOutNode;
import club.luke.cloud.shop.app.system.service.IKindSetupService;
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

@RestController
public class KindSetupAction implements IKindSetupAction {

    @Resource
    IKindSetupService kindSetupService ;

    @Override
    public ActionResult findGoodsNode(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                                      @ApiParam @RequestBody @Valid VOInNode vo, BindingResult bindingResult) throws Exception {
        List<VOOutNode> lstKind = this.kindSetupService.findGoodsNode(vo) ;
        return actionResult.OK("查询商品树",lstKind);
    }


    @Override
    public ActionResult findKindSetupConfig(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                                            @ApiParam @RequestBody @Valid
                                                    VOInId vo, BindingResult bindingResult) throws Exception {
        List<TG_Kind_Setup> lstKindSetup = this.kindSetupService.findKindSetupConfig(vo) ;
        return actionResult.OK("查询品类对应的商品扩展属性",lstKindSetup);
    }

    @Override
    public ActionResult editKindSetupConfigById(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                                                @ApiParam @RequestBody @Valid
                                                        VOInKindSetup vo, BindingResult bindingResult) throws Exception {
        this.kindSetupService.editKindSetupConfigById(vo) ;
        return actionResult.OK("修改商品品类配置属性");
    }
}
