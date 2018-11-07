package club.luke.cloud.shop.app.login.dao;

import club.luke.cloud.shop.app.model.TU_User;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by luke on 2018/11/5.
 */
public interface ILoginJpaDao  extends Repository<TU_User, Long> {


    TU_User findByLoginNameAndPassword(String loginName, String password)throws Exception;
    List<TU_User> findByNameAndPassword(String name, String password)throws Exception;
}
