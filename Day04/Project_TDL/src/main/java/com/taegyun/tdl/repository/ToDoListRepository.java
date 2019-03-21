package com.taegyun.tdl.repository;

import com.taegyun.tdl.domain.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    List<ToDoList> findByOrderByIdxAsc();
}
