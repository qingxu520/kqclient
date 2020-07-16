package co.goho.qingxu.kq.entity;

import com.mumu.msg.RE_MSG_Private;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "MSG_PRIVATE")
@ToString
public class MsgPrivate implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nick;
    @Column
    private String sex;
    @Column
    private String age;
    @Column
    private String error;
    @Column
    private String act;
    @Column
    private String fromqq;
    @Column
    private String subtype;
    @Column
    private String time;
    @Column
    private String font;
    @Column
    private String msg;
    @Column
    private Date createDate;

    public MsgPrivate(RE_MSG_Private m) {
        this.nick = m.getNick();
        this.sex = m.getSex();
        this.age = m.getAge();
        this.error = m.getError();
        this.act = m.getAct();
        this.fromqq = m.getFromqq();
        this.subtype = m.getSubtype();
        this.time = m.getTime();
        this.font = m.getFont();
        this.msg = m.getMsg();
        this.createDate = new Date();
    }
}
