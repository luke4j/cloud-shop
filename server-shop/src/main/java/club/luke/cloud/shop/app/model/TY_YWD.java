package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;
import club.luke.cloud.shop.app.util.V;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by luke on 2018/11/19.
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class TY_YWD extends Model{

    @ManyToOne
    @JoinColumn(name = "storeId")
    TU_Com store ;

    @ManyToOne
    @JoinColumn(name = "opterId")
    TY_Code ywCode ;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    V.BillState billState = V.BillState.制单 ;

    @OneToMany
    @JoinColumn(name = "ywd_id")
    List<TY_YWDMX> ywd_mx ;


    Date startTime = new Date() ;
    @ManyToOne
    @JoinColumn(name = "opterId")
    TU_User startOpter ;


    Date endTime ;
    @ManyToOne
    @JoinColumn(name = "opterId")
    TU_User endOpter ;

    public List<TY_YWDMX> getYwd_mx() {
        return ywd_mx;
    }

    public void setYwd_mx(List<TY_YWDMX> ywd_mx) {
        this.ywd_mx = ywd_mx;
    }

    public TU_Com getStore() {
        return store;
    }

    public void setStore(TU_Com store) {
        this.store = store;
    }


    public TY_Code getYwCode() {
        return ywCode;
    }

    public void setYwCode(TY_Code ywCode) {
        this.ywCode = ywCode;
    }

    public V.BillState getBillState() {
        return billState;
    }

    public void setBillState(V.BillState billState) {
        this.billState = billState;
    }
}
