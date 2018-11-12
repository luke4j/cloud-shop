package club.luke.cloud.shop.app.dao;

import club.luke.cloud.shop.app.database.BaseDao;
import club.luke.cloud.shop.app.web.vo.VOIn;
import org.springframework.stereotype.Component;

/**
 * Created by luke on 2018/11/12.
 */
@Component
public class BDao extends BaseDao {
    public String getRedisUser(VOIn vo) throws Exception{
        return this.getRedisValue(vo.getLoginTuken()) ;
    }
}
