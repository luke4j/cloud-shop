package club.luke.cloud.shop.app.database;

import club.luke.cloud.shop.app.util.tool.Assertion;
import club.luke.cloud.shop.app.util.tool.LK;
import club.luke.cloud.shop.app.web.Page;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by luke on 2018/11/1.
 */
public class BaseDao {

    private Logger log = LoggerFactory.getLogger(BaseDao.class) ;


    private RedisTemplate redisTemplate;

    @Resource
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;

    }

    @Resource
    private JdbcTemplate jdbcTemplate ;

    @Resource
    private SessionFactory sessionFactory ;

    public Session getSession()throws Exception{
        Session session = null ;
        try{
            session = this.sessionFactory.getCurrentSession() ;
            log.debug("current session");
            return session ;
        }catch (Exception e){
            log.debug("open session");
            return sessionFactory.openSession() ;
        }
    }

    /**
     * @return
     * @throws Exception
     */
    public RedisTemplate getRedisTemplate() throws Exception{
        return this.redisTemplate ;
    }

    /**
     * 以key 从redis里取值
     * @param key
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> T getRedisValue(String key) throws Exception{
        return  (T)this.redisTemplate.opsForValue().get(key) ;
    }

    /**
     *  保存 key  与 val 到redis
     * @param key
     * @param val
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> T setRedisValue(String key,T val) throws Exception{
        this.redisTemplate.opsForValue().set(key,val);
        return val ;
    }

    /**
     * 保存 key 与 val 到redis 并设置过期时间
     * @param key
     * @param val
     * @param time
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> T setRedisValueAndEX(String key ,T val ,Long time) throws Exception{
        this.redisTemplate.opsForValue().set(key,val);
        this.redisTemplate.expire(key, time, TimeUnit.MINUTES) ;
        return val ;
    }



    /**
     * hibernate session save ;
     * @param obj
     * @param <T>
     * @return
     */
    public <T> T save(T obj) throws Exception{
        if(obj==null) Assertion.Error("保存对象为空");
        if(obj instanceof Model){
            Model m = (Model)obj ;
            m.setB_isDel(false);
            m.setB_wtime(new Date());
        }
        this.getSession().save(obj) ;
        return obj ;
    }

    /**
     * hibernate ql　删除<br>
     * this.delete_ql("delete from TG_Price p where p.goods.id=:goodsId", vo) ; vo中要有goodsId属性并且有值
     * @param ql
     * @param param
     * @return
     * @throws Exception
     */
    public boolean delete_hql(String ql,Object param) throws Exception{
        if(LK.StrIsEmpty(ql) ) Assertion.Error("delete_ql语句为空");
        if(param instanceof Map){
            Map<String,Object> p = (Map<String,Object>) param ;
            this.getSession().createQuery(ql).setProperties(p).executeUpdate() ;
        }else{
            this.getSession().createQuery(ql).setProperties(param).executeUpdate() ;
        }
        return true ;
    }

    /**
     * this.delete_jdbc("delete from tg_price where goodsId=?",vo.getGoodsId()) ;
     * @param sql
     * @param params
     * @return
     * @throws Exception
     */
    public boolean delete_jdbc(String sql,Object... params) throws Exception{
        if(LK.StrIsEmpty(sql) ) Assertion.Error("delete_sql语句为空");
        log.info("jdbcTemplate sql is =>"+sql);
        this.jdbcTemplate.update(sql, params) ;
        return true ;
    }

    /**
     * hibernate qh 更新
     * @param ql
     * @param param
     * @return
     * @throws Exception
     */
    public boolean update_ql(String ql,Object param) throws Exception{
        if(LK.StrIsEmpty(ql) ) Assertion.Error("dupdate_ql语句为空");
        if(param instanceof Map){
            Map<String,Object> p = (Map<String,Object>) param ;
            this.getSession().createQuery(ql).setProperties(p).executeUpdate() ;
        }else{
            this.getSession().createQuery(ql).setProperties(param).executeUpdate() ;
        }
        return true ;
    }




    /**
     * hibernate session 更新对象
     * @param obj
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> T updateObj(T obj) throws Exception{
        if(obj instanceof Model){
            Model m = (Model) obj ;
            this.getSession().update(obj);
        }else{
            throw DBMsgException.create("删除对象不是映射对象");
        }
        return obj ;
    }

    /**
     * hibernate session get+update
     * @param clss
     * @param id
     * @param val
     * @param <T>
     * @param <C>
     * @return
     * @throws Exception
     */
    public <T,C> T updateObj(Class<T> clss ,Long id,C val) throws Exception{
        T obj = this.getSession().get(clss,id) ;
        BeanUtils.copyProperties(val, obj);
        this.getSession().update(obj);
        return obj ;
    }



    /**
     * hibernate 批量保存
     * @param list
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> List<T> saveAll(List<T> list) throws Exception{
        Date now = new Date() ;
        for(int i = 0 ;i<list.size();i++){
            if(i!=0&&i%20==0){
                this.getSession().flush();
            }
            if(list.get(i) instanceof Model){
                Model m = (Model)list.get(i) ;
                m.setB_wtime(now);
                m.setB_isDel(false);
            }
            this.save(list.get(i)) ;
        }
        this.getSession().flush();
        return list ;
    }

    /**
     * 以条件查询唯一值,可以返回null 值
     * @param ql
     * @param param
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> T getUnique(String ql ,Object param) throws Exception{
        if(LK.StrIsEmpty(ql)) Assertion.Error("getUnique查询语句为空");
        if(param instanceof Map){
            Map<String,Object> p = (Map<String,Object>) param ;
            return (T)this.getSession().createQuery(ql).setProperties(p).uniqueResult() ;
        }else{
            return (T)this.getSession().createQuery(ql).setProperties(param).uniqueResult() ;
        }
    }

    /**
     * 以条件查询唯一值,可以返回null 值
     * @param ql
     * @param param
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> T getUnique(String ql ,Object param,Class<T> toBean) throws Exception{
        if(LK.StrIsEmpty(ql)) Assertion.Error("getUnique查询语句为空");
        if(param instanceof Map){
            Map<String,Object> p = (Map<String,Object>) param ;
            return (T)this.getSession().createQuery(ql).setResultTransformer(Transformers.aliasToBean(toBean)).setProperties(param).uniqueResult() ;
        }else{
            return (T)this.getSession().createQuery(ql).setResultTransformer(Transformers.aliasToBean(toBean)).setProperties(param).uniqueResult() ;
        }
    }
    /**
     * hibernate session ql查询 <br>  注意，toBean与changeMap都为空时，查询出映射类的列表 toBean与changeMap不能同时使用
     * @param ql
     * @param param
     * @param page
     * @param toBean
     * @param changeMap
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> List<T> find(String ql ,Object param ,Page page,Class<T> toBean,Boolean changeMap) throws Exception{
        if(LK.StrIsEmpty(ql)) Assertion.Error("find查询语句为空");
        Query query = null ;
        if(LK.ObjIsNull(toBean)){
            query = this.getSession().createQuery(ql) ;
        }
        if(LK.ObjIsNotNull(toBean)){
            query.setResultTransformer(Transformers.aliasToBean(toBean)) ;
        }
        if(LK.ObjIsNotNull(changeMap)&&changeMap){
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP) ;
        }
        if(LK.ObjIsNotNull(param)){
            if(param instanceof Map){
                Map<String,Object> p = (Map<String,Object>) param ;
                query.setProperties(p) ;
            }else{
                query.setProperties(param) ;
            }

        }
        if(LK.ObjIsNotNull(page)){
            query.setMaxResults(page.getLimit()) ;
            query.setFirstResult(page.getStart()) ;
        }
        return query.list() ;
    }

    /**
     * hibernate session ql查询 <br>  注意，toBean与changeMap都为空时，查询出映射类的列表 toBean与changeMap不能同时使用
     * @param ql
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> List<T> find(String ql) throws Exception{
        return this.find(ql, null, null, null, null) ;
    }

    /**
     * hibernate session ql查询   <br>  注意 这是直接查询出映射类的列表
     * @param ql
     * @param param
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> List<T> find(String ql ,Object param ) throws Exception{
        return this.find(ql, param, null, null, null) ;
    }

    /**
     * hibernate session ql查询
     * @param ql
     * @param param
     * @param page
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> List<T> find(String ql ,Object param ,Page page) throws Exception{
        return this.find(ql,param,page,null,null) ;
    }

    /**
     * 可能返回null值
     * @param clss
     * @param id
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> T get(Class<T> clss,Long id) throws Exception {
        return this.getSession().get(clss, id) ;
    }

    public<T> T update(T obj) throws Exception {
        return this.updateObj(obj) ;
    }
    /**
     * hibernate session 软删除对象
     * @param obj
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> T delObj(T obj) throws Exception{
        if(obj instanceof Model){
            Model m = (Model) obj ;
            m.setB_isDel(true);
            this.getSession().update(obj);
        }else{
            throw DBMsgException.create("删除对象不是映射对象");
        }
        return obj ;
    }
    /**
     * hibernate session 删除对象
     * @param obj
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> T delObject(T obj) throws Exception{
        this.getSession().delete(obj);
        return obj ;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public String jdbcTemplateUpdate(String sql,Object[] objs)throws Exception{
        log.info("jdbc sql is ->:"+sql);
        for(Object obj :objs){
            log.info("jdbc sql param is ->:"+obj.toString());
        };
        this.jdbcTemplate.update(sql,objs) ;
        return "success" ;
    }

}
