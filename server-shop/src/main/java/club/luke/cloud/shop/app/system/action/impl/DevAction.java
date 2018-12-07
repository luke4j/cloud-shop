package club.luke.cloud.shop.app.system.action.impl;

import club.luke.cloud.shop.app.model.TU_Fun;
import club.luke.cloud.shop.app.system.action.IDevAction;
import club.luke.cloud.shop.app.system.service.IDevService;
import club.luke.cloud.shop.app.web.ActionResult;
import club.luke.cloud.shop.app.web.action.BaseAction;
import club.luke.cloud.shop.app.web.vo.VOInEmputy;
import club.luke.cloud.shop.app.web.vo.system.VOInFun;
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
 * Created by luke on 2018/11/15.
 */
@RestController
public class DevAction extends BaseAction implements IDevAction {


    @Resource
    IDevService devService ;

    @Override
    public ActionResult findAllCom(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                                   @ApiParam @RequestBody @Valid VOInEmputy vo, BindingResult bindingResult) throws Exception {
        List<TU_Fun> lstFun = this.devService.findAllCom(vo) ;
        return actionResult.OK("查询所有功能",lstFun);
    }

    @Override
    public ActionResult editFun(HttpServletRequest request, HttpServletResponse response, ActionResult actionResult,
                                @ApiParam @RequestBody @Valid VOInFun vo, BindingResult bindingResult) throws Exception {
        this.devService.editFun(vo) ;
        return actionResult.OK("保存或修改功能数据");
    }
}
