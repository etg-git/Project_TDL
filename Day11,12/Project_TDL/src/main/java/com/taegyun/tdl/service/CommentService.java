package com.taegyun.tdl.service;

import com.taegyun.tdl.controller.CommentController;
import com.taegyun.tdl.domain.ToDoList;
import com.taegyun.tdl.repository.CommentRepository;
import com.taegyun.tdl.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    ToDoListRepository toDoListRepository;

    public ToDoList com(Long idx) {
        return toDoListRepository.getOne(idx);
    }
}
