package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.*;

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
    @Column(length = 40)
    private String funword4 ;
    /**
     * 色觉
     */
    @Column(length = 40)
    private String colorFeel ;

    /**
     * 立体视锐度
     */
    @Column(length = 40)
    private String funacuity ;

    /**
     * 5m眼位
     */
    @Column(length = 40)
    private String funm5 ;
    /**
     * 40cm眼位
     */
    @Column(length = 40)
    private String funcm40 ;

    /**
     * AC/A
     */
    @Column(length = 40)
    private String fun_ac_a ;

    /**
     * 角膜
     */
    @Column(length = 40)
    private String jm ;

    /**
     * 晶状体
     */
    @Column(length = 40)
    private String jzt ;


}
