package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by luke on 2018/11/8.
 */
@Entity
public class TU_Role extends Model {

    @Column(length = 40)
    private String name ;

    @Column(length = 80)
    private String bz ;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinTable(name="TU_Role_Fun",
            joinColumns = {@JoinColumn(name="roleId",foreignKey = @ForeignKey(name = "fk_role_fun"))},
            inverseJoinColumns = {@JoinColumn(name="funId",foreignKey = @ForeignKey(name = "fk_fun_fole"))})
    @JsonIgnore
    private List<TU_Fun> listFun ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comId",foreignKey = @ForeignKey(name = "fk_role_com"))
    @JsonIgnore
    private TU_Com com ;


    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TU_Fun> getListFun() {
        return listFun;
    }

    public void setListFun(List<TU_Fun> listFun) {
        this.listFun = listFun;
    }

    public TU_Com getCom() {
        return com;
    }

    public void setCom(TU_Com com) {
        this.com = com;
    }
}
