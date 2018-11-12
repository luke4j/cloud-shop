package club.luke.cloud.shop.app.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by luke on 2018/11/12.
 */
public class TSYS_Stream {

    /**流程类型*/
    public enum  Stype{
        /**成品*/
        cp,
        /**定制*/
        dz,
        /**加工*/
        jg,
        /**定制加工*/
        zdjg,
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 10,nullable = false)
    Stype stype = Stype.jg ;

    @Column(length = 30,nullable = false)
    String name ;
    @Column(length = 200,nullable = false)
    String nextId ;
    @Column(nullable = false)
    Boolean over ;

    public Stype getStype() {
        return stype;
    }

    public void setStype(Stype stype) {
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
