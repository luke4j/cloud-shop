package club.luke.cloud.shop.app.service;

import club.luke.cloud.shop.app.dao.BDao;
import club.luke.cloud.shop.app.util.tool.Assertion;
import club.luke.cloud.shop.app.web.vo.VOIn;
import club.luke.cloud.shop.app.web.vo.VORedisUser;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by luke on 2018/11/12.
 */
@Service
public class BService {

    @Resource
    BDao dao ;

    public VORedisUser getRedisUser(VOIn vo)  throws Exception{
        String jsonStr_RedisUser = this.dao.getRedisUser(vo) ;
        JSONObject jonJsonObject = JSONObject.fromObject(jsonStr_RedisUser) ;
        VORedisUser voRedisUser = (VORedisUser)JSONObject.toBean(jonJsonObject,VORedisUser.class) ;
        Assertion.NotEmpty(voRedisUser,"请重新登录系统");
        return voRedisUser;
    }
}
