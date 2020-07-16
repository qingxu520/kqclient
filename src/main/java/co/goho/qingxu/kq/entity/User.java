package co.goho.qingxu.kq.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_user")
@ToString
public class User implements Serializable {

    @Id
    private String qq;

    @Column
    private String pwd;

    @Column
    private String name;

}
