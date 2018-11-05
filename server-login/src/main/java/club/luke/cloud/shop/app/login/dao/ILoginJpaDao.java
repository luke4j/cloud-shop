package club.luke.cloud.shop.app.login.dao;

import club.luke.cloud.shop.app.login.vo.VOInLogin;
import club.luke.cloud.shop.app.login.vo.VOOutUser;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * Created by luke on 2018/11/5.
 */
public interface ILoginJpaDao <T,ID extends Serializable> extends Repository<T, ID> {

    VOOutUser findByloginNameAndPassword(VOInLogin vo) throws Exception;
}
