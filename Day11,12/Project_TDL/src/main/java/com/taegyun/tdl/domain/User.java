package com.taegyun.tdl.domain;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.LazyInitializationException;

@Setter
@ToString
@Getter
@NoArgsConstructor
@Entity
@Table
public class User implements Serializable {

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


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<ToDoList> toDoLists = new ArrayList<>();

    public void add(ToDoList toDoList) {
        toDoList.setUser(this);
        getToDoLists().add(toDoList);
    }

//    public void user(User user) {
//        this.id = user.getId();
//        this.password = user.getPassword();
//        this.email = user.getEmail();
//    }
    @Builder
    public User(String id, String password, String email, List<ToDoList> toDoLists) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.toDoLists = toDoLists;
    }

}
