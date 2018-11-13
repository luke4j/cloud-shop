package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;
import club.luke.cloud.shop.app.util.V;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by luke on 2018/11/9.
 */
@Entity
public class TU_Message extends Model {



    @Column(length = 500,nullable = false)
    private String msg ;
    @Column(length = 50,nullable = false)
    private String title ;

    @Enumerated(EnumType.STRING)
    @Column(length = 12,nullable = false)
    private V.MessageType messageType = V.MessageType.个人 ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "readerId",foreignKey = @ForeignKey(name = "fk_msg_user"))
    private TU_User reader ;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public TU_User getReader() {
        return reader;
    }

    public void setReader(TU_User reader) {
        this.reader = reader;
    }
}
