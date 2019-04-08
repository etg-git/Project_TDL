package com.taegyun.tdl.repository;

import com.taegyun.tdl.domain.ToDoList;
import com.taegyun.tdl.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

   List<ToDoList> findByUserIdx(Long idx);
   List<ToDoList> findAllByUserOrderByIdxAsc(User user);
}
