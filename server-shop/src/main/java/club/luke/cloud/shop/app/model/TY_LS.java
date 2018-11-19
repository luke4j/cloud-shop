package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by luke on 2018/11/19.
 * 业务流水,业务完成后写流水
 */
@Entity
public class TY_LS extends Model {

    @ManyToOne
    @JoinColumn(name = "kcId",foreignKey = @ForeignKey(name = "fk_kc_ls"))
    TK_KC kc ;

    @ManyToOne
    @JoinColumn(name = "ywCodeId",foreignKey = @ForeignKey(name = "fk_ywd_ls"))
    TY_Code ywCode ;

    /**使用代理完成这个事情，代理是完成之后的数据 ，所以只有完成数据，之前数据自己算*/
    /**残品库存 */
    Long e_can_kc ;
    /**次品库存 */
    Long e_ci_kc ;
    /**赠品库存 */
    Long e_zp_kc ;
    /**正品库存 */
    Long e_z_kc ;
    Date endTime ;
    @ManyToOne
    @JoinColumn(name = "opterId")
    TU_User endOpter ;


    /**操作数量*/
    Long optNum ;

    /**业务单ID*/
    Long ywdId ;
    /**业务单表*/
    @Column(length = 20,nullable = false)
    String ywdTable ;

    /**业务单明ID*/
    Long ywmxId ;
    /**业务单明细表*/
    @Column(length = 20,nullable = false)
    String ywmxTable ;


    @ManyToOne
    @JoinColumn(name = "storeId")
    TU_Com store ;




    public Long getYwmxId() {
        return ywmxId;
    }

    public void setYwmxId(Long ywmxId) {
        this.ywmxId = ywmxId;
    }

    public String getYwmxTable() {
        return ywmxTable;
    }

    public void setYwmxTable(String ywmxTable) {
        this.ywmxTable = ywmxTable;
    }

    public TU_Com getStore() {
        return store;
    }

    public void setStore(TU_Com store) {
        this.store = store;
    }



    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public TU_User getEndOpter() {
        return endOpter;
    }

    public void setEndOpter(TU_User endOpter) {
        this.endOpter = endOpter;
    }

    @ManyToOne
    @JoinColumn(name = "goodsId",foreignKey = @ForeignKey(name = "fk_goods_ls"))
    TG_Goods goods ;

    Float sph ;
    Float cyl ;


    public Long getE_can_kc() {
        return e_can_kc;
    }

    public void setE_can_kc(Long e_can_kc) {
        this.e_can_kc = e_can_kc;
    }

    public Long getE_ci_kc() {
        return e_ci_kc;
    }

    public void setE_ci_kc(Long e_ci_kc) {
        this.e_ci_kc = e_ci_kc;
    }

    public Long getE_zp_kc() {
        return e_zp_kc;
    }

    public void setE_zp_kc(Long e_zp_kc) {
        this.e_zp_kc = e_zp_kc;
    }

    public Long getE_z_kc() {
        return e_z_kc;
    }

    public void setE_z_kc(Long e_z_kc) {
        this.e_z_kc = e_z_kc;
    }

    public TK_KC getKc() {
        return kc;
    }

    public void setKc(TK_KC kc) {
        this.kc = kc;
    }

    public TY_Code getYwCode() {
        return ywCode;
    }

    public void setYwCode(TY_Code ywCode) {
        this.ywCode = ywCode;
    }

    public Long getOptNum() {
        return optNum;
    }

    public void setOptNum(Long optNum) {
        this.optNum = optNum;
    }

    public Long getYwdId() {
        return ywdId;
    }

    public void setYwdId(Long ywdId) {
        this.ywdId = ywdId;
    }

    public String getYwdTable() {
        return ywdTable;
    }

    public void setYwdTable(String ywdTable) {
        this.ywdTable = ywdTable;
    }

    public TG_Goods getGoods() {
        return goods;
    }

    public void setGoods(TG_Goods goods) {
        this.goods = goods;
    }

    public Float getSph() {
        return sph;
    }

    public void setSph(Float sph) {
        this.sph = sph;
    }

    public Float getCyl() {
        return cyl;
    }

    public void setCyl(Float cyl) {
        this.cyl = cyl;
    }


}
