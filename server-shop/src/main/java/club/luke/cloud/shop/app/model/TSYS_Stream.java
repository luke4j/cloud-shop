package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.util.V;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by luke on 2018/11/12.
 */
public class TSYS_Stream {



    @Enumerated(EnumType.STRING)
    @Column(length = 10,nullable = false)
    V.Streamtype stype = V.Streamtype.加工 ;

    @Column(length = 30,nullable = false)
    String name ;
    @Column(length = 200,nullable = false)
    String nextId ;
    @Column(nullable = false)
    Boolean over ;

    public V.Streamtype getStype() {
        return stype;
    }

    public void setStype(V.Streamtype stype) {
        this.stype = stype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNextId() {
        return nextId;
    }

    public void setNextId(String nextId) {
        this.nextId = nextId;
    }

    public Boolean getOver() {
        return over;
    }

    public void setOver(Boolean over) {
        this.over = over;
    }
}
