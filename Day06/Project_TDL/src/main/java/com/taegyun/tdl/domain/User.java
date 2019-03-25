package com.taegyun.tdl.domain;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Setter
@ToString
@Getter
@NoArgsConstructor
@Entity
@Table
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String email;

//    public void user(User user) {
//        this.id = user.getId();
//        this.password = user.getPassword();
//        this.email = user.getEmail();
//    }
    @Builder
    public User(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

}
