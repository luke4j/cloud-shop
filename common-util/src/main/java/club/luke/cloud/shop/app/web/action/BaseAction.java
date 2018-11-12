package club.luke.cloud.shop.app.web.action;

import club.luke.cloud.shop.app.service.BService;
import club.luke.cloud.shop.app.web.vo.VOIn;
import club.luke.cloud.shop.app.web.vo.VORedisUser;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by luke on 2018/11/12.
 */
@Component
public class BaseAction  {

    @Resource
    BService service ;

    public VORedisUser getRedisUser(VOIn vo) throws Exception{
        VORedisUser ruser = this.service.getRedisUser(vo) ;
        return ruser ;
    }

}
