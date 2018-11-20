package club.luke.cloud.shop.app.conf;

import club.luke.cloud.shop.app.model.TU_Com;
import club.luke.cloud.shop.app.web.vo.VOIn;

import java.util.List;

/**
 * Created by luke on 2018/11/19.
 */
public interface IComBaseDao {

    TU_Com getGS(VOIn vo) throws Exception ;

    <T> List<T> find(String ql ,Object param ) throws Exception ;

    <T> List<T> find(String ql) throws Exception;

   <T> T getUnique(String ql ,Object param) throws Exception ;


    <T> T getUnique(String ql ,Object param,Class<T> toBean) throws Exception ;

    <T> T save(T obj) throws Exception ;

    <T> T get(Class<T> clss, Long id) throws Exception ;

    <T> T update(T obj) throws Exception ;
}
