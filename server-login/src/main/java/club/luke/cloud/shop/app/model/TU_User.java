package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by luke on 2018/11/1.
 */

@Entity
public class TU_User extends Model{

    @Column(length = 10)
    String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
