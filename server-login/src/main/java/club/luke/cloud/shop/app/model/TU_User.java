package club.luke.cloud.shop.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by luke on 2018/11/1.
 */

@Entity
public class TU_User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String sex ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
