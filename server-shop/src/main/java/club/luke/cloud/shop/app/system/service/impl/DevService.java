package club.luke.cloud.shop.app.system.service.impl;

import club.luke.cloud.shop.app.model.TU_Fun;
import club.luke.cloud.shop.app.system.action.vo.VOInFun;
import club.luke.cloud.shop.app.system.dao.IDevDao;
import club.luke.cloud.shop.app.system.service.IDevService;
import club.luke.cloud.shop.app.util.tool.Assertion;
import club.luke.cloud.shop.app.web.vo.VOInEmputy;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by luke on 2018/11/15.
 */
@Service
public class DevService implements IDevService {

    @Resource
    IDevDao devDao ;

    @Override
    public List<TU_Fun> findAllCom(VOInEmputy vo) throws Exception {
        return this.devDao.find("From TU_Fun") ;
    }

    @Override
    @Transactional
    public TU_Fun editFun(VOInFun vo) throws Exception {
        TU_Fun tu_fun = null ;
        if(vo.getId()!=null){
            tu_fun = this.devDao.get(TU_Fun.class,vo.getId()) ;
            Assertion.NotEmpty(tu_fun,"TU_Fun.id="+vo.getId() +"异常");
            BeanUtils.copyProperties(vo, tu_fun);
            this.devDao.editFun(tu_fun) ;
        }else{
            tu_fun = new TU_Fun() ;
            tu_fun.setB_isDel(false);
            tu_fun.setB_wtime(new Date());
            BeanUtils.copyProperties(vo, tu_fun);
            this.devDao.save(tu_fun) ;
        }
        return tu_fun;
    }
}
