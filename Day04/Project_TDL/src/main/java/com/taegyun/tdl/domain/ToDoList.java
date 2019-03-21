package com.taegyun.tdl.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Table
@NoArgsConstructor
@Entity
public class ToDoList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idx;

    @Column
    private Boolean status;

    @Column
    private String description;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime completedDate;

//    @Column
//    private String operation;
//    public void operation(ToDoList toDoList){
//        this.operation = toDoList.getOperation();
//    }
    public void setCreatedDate() {
        this.createdDate = LocalDateTime.now();
    }
    public void update(ToDoList toDoList) {
        this.status = toDoList.getStatus();
        this.description = toDoList.getDescription();
//        this.createdDate = LocalDateTime.now();
//        this.completedDate = toDoList.getCompletedDate();
    }
    public void showhide(ToDoList toDoList) {
        this.status = !this.status;
    }
    @Builder
    public ToDoList(Boolean status, String description, LocalDateTime createdDate, LocalDateTime completedDate, String operation) {
        this.status = status;
        this.description = description;
        this.createdDate = createdDate;
        this.completedDate = completedDate;
//        this.operation = operation;
    }
}
