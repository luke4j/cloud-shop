package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by luke on 2018/11/12.
 * 检影验光扩展
 */
@Entity
public class TC_YGMX_Ext extends Model{


    @ManyToOne
    /**在 tc_ygmx_ext 中添加列ygmxId*/
    @JoinColumn(name = "ygmxId",foreignKey = @ForeignKey(name = "fk_ygmx_ext_ygmx"))
    TC_YGMX ygmx ;

    /**
     * 双眼功能：word4点
     */
    private String funword4 ;
    /**
     * 色觉
     */
    private String colorFeel ;

    /**
     * 立体视锐度
     */
    private String funacuity ;

    /**
     * 5m眼位
     */
    private String funm5 ;
    /**
     * 40cm眼位
     */
    private String funcm40 ;

    /**
     * AC/A
     */
    private String fun_ac_a ;

    /**
     * 角膜
     */
    private String jm ;

    /**
     * 晶状体
     */
    private String jzt ;


}
