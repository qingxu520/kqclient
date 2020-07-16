package co.goho.qingxu.kq.entity;

import co.goho.qingxu.kq.utils.DateUtil;
import com.mumu.msg.RE_MSG_Forum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@Entity(name = "MSG_FORUM")
@ToString
@NoArgsConstructor
public class MsgForum implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String subType;
    @Column
    private String sendTime;
    @Column
    private String fromDiscuss;
    @Column
    private String fromQQ;
    @Column
    private String font;
    @Column
    private String nick;
    @Column
    private String age;
    @Column
    private String sex;
    @Column
    private String act;
    @Column
    private String msg;
    @Column
    private Date createDate;

    public MsgForum(RE_MSG_Forum m) {
        this.subType = m.getSubType();
        this.sendTime = m.getSendTime();
        this.fromDiscuss = m.getFromDiscuss();
        this.fromQQ = m.getFromQQ();
        this.msg = m.getMsg();
        this.font = m.getFont();
        this.nick = m.getNick();
        this.age = m.getAge();
        this.sex = m.getSex();
        this.act = m.getAct();
        this.msg = m.getMsg();
        this.createDate = new Date();
    }
}
