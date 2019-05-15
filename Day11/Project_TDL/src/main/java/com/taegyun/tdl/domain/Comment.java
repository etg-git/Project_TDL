package com.taegyun.tdl.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String content;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime modifiedDate;

    @ManyToOne
    private ToDoList toDoList;

    public void setCreatedDate() {
        this.createdDate = LocalDateTime.now();
    }

    public void RepUpdate(String content) {
        this.content = content;
        this.createdDate = LocalDateTime.now();
    }

    @Builder
    public Comment(String content, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
