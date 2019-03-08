# One Day
---
#### ```한 것들```

* To Do List 프로젝트 생성

* ToDo.java 생성
~~~java
//ToDo.java
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
public class ToDo implements Serializable {

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
    private LocalDateTime copletedDate;

    @Builder
    public ToDo(Boolean status, String description, LocalDateTime createdDate, LocalDateTime copletedDate) {
        this.status = status;
        this.description = description;
        this.createdDate = createdDate;
        this.copletedDate = copletedDate;
    }
}
~~~
