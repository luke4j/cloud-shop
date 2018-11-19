package club.luke.cloud.shop.app.yw.service;

import club.luke.cloud.shop.app.model.*;

/**
 * Created by luke on 2018/11/19.
 */
public interface IYWProxy {

    /**
     * 有操作库存的才会出现流水，所以只有执行时才会有流水
     * @param ywd       业务单
     * @param ywdmx     业务单明细
     * @param kc        库存
     * @param ywCode    业务代码
     * @param num       操作数量
     * @param store     操作站点
     * @param endOpter  执行人
     * @return
     * @throws Exception
     */
    TY_YWD save_ywd (TY_YWD ywd,TY_YWDMX ywdmx,TK_KC kc,TY_Code ywCode,Long num,TU_Com store,TU_User endOpter)throws Exception ;


}
