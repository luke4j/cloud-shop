package club.luke.cloud.shop.app.user.service;

import club.luke.cloud.shop.app.model.TU_Role;
import club.luke.cloud.shop.app.web.vo.VOIn;

import java.util.List;

/**
 * Created by luke on 2018/11/15.
 */
public interface IRoleService {
    /**
     * 查询所有权限（带公司限制）
     * @param vo
     * @return
     * @throws Exception
     */
    List<TU_Role> findAllRole(VOIn vo) throws Exception;
}
