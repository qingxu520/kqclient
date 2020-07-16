package co.goho.qingxu.kq.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_sendmsg")
@ToString
public class SendMsg implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;

    @Column
    private String qq;

    @Column
    private String msg;

    @Column
    private String createDate;

    @Column
    private String sendDate;

    /**
     *  0待发送  1已发送
     */
    private String state;

}
