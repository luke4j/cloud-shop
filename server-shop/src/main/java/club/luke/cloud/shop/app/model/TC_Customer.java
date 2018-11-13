package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by luke on 2018/11/12.
 */
@Entity
public class TC_Customer extends Model {

    @Column(length = 20)
    private String name ;

    private Date birthday ;




}
