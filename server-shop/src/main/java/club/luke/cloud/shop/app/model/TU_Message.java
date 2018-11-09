package club.luke.cloud.shop.app.model;

import club.luke.cloud.shop.app.database.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by luke on 2018/11/9.
 */
@Entity
public class TU_Message extends Model {

    public enum MessageType{
        /**个人消息*/
        gr,
        /**站点消息*/
        zd,
        /**角色消息*/
        js,
        /**全公司消息*/
        allCom,
        /**全系统消息*/
        all,
    }

    @Column(length = 500,nullable = false)
    private String msg ;
    @Column(length = 50,nullable = false)
    private String title ;

    @Enumerated(EnumType.STRING)
    @Column(length = 12,nullable = false)
    private MessageType messageType = MessageType.gr ;

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

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public TU_User getReader() {
        return reader;
    }

    public void setReader(TU_User reader) {
        this.reader = reader;
    }
}
