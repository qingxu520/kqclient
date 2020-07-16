package co.goho.qingxu.kq.entity;

import co.goho.qingxu.kq.utils.DateUtil;
import com.mumu.msg.RE_MSG_Group;
import lombok.*;
import org.springframework.util.unit.DataUnit;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "MSG_GROUP")
@ToString
public class MsgGroup implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String act;
    @Column
    private String subType;
    @Column
    private String sendTime;
    @Column
    private String fromGroup;
    @Column
    private String fromQQ;
    @Column
    private String fromAnonymous;
    @Column
    private String font;
    @Column
    private String username;
    @Column
    private String nick;
    @Column
    private String sex;
    @Column
    private String age;
    @Column
    private String fromGroupName;
    @Column
    private String msg;
    @Column
    private Date createDate;

    public MsgGroup(RE_MSG_Group m) {
        this.act = m.getAct();
        this.subType = m.getSubType();
        this.sendTime = m.getSendTime();
        this.fromGroup = m.getFromGroup();
        this.fromQQ = m.getFromQQ();
        this.fromAnonymous = m.getFromAnonymous();
        this.font = m.getFont();
        this.username = m.getUsername();
        this.nick = m.getNick();
        this.sex = m.getSex();
        this.age = m.getAge();
        this.fromGroupName = m.getFromGroupName();
        this.msg = m.getMsg();
        this.createDate = new Date();
    }
}
