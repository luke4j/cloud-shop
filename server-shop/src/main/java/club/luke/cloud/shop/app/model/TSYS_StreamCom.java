package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;
import club.luke.cloud.shop.app.util.V;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 */
@Entity
public class TSYS_StreamCom  extends Model {

    @Enumerated(EnumType.STRING)
    @Column(length = 10,nullable = false)
    V.Streamtype stype = V.Streamtype.加工 ;

    @Column(length = 30,nullable = false)
    String name ;
    @Column(length = 200,nullable = false)
    String nextId ;
    @Column(nullable = false)
    Boolean over ;
}
