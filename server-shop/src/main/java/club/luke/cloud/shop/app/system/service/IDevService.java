package club.luke.cloud.shop.app.system.service;

import club.luke.cloud.shop.app.model.TU_Fun;
import club.luke.cloud.shop.app.web.vo.system.VOInFun;
import club.luke.cloud.shop.app.web.vo.VOInEmputy;

import java.util.List;

/**
 * Created by luke on 2018/11/15.
 */
public interface IDevService {
    /**
     * 查询所有功能
     * @param vo
     * @return
     * @throws Exception
     */
    List<TU_Fun> findAllCom(VOInEmputy vo) throws Exception;

    /**
     * 保存或修改功能数据
     * @param vo
     * @return
     * @throws Exception
     */
    TU_Fun editFun(VOInFun vo)throws Exception;
}
