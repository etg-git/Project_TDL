package com.taegyun.tdl.service;

import com.taegyun.tdl.domain.ToDoList;
import com.taegyun.tdl.domain.User;
import com.taegyun.tdl.repository.ToDoListRepository;
import com.taegyun.tdl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService {
    @Autowired
    ToDoListRepository toDoListRepository;

    @Autowired
    UserRepository userRepository;

    //    public ToDoListService(ToDoListRepository toDoListRepository, UserRepository userRepository) {
    //        this.toDoListRepository = toDoListRepository;
    //        this.userRepository = userRepository;
    //    }
    private User user;
    public List<ToDoList> findToDoList(User user) {
        return toDoListRepository.findAllByUserOrderByIdxAsc(user);
    }

    public User findUser() {
        return userRepository.getOne(1L);
    }
    // 1. 비밀번호가 틀린경우
    // 2. 아디가 없는경우
    // 3. 아디와 비밀번호가 같은경우
//    public boolean findLogin(String id, String password) {
//        if(id.equals(user.getId()) && password.equals(user.getPassword())) {
//            return true;
//        }
//        else return false;
//    }
//    public ToDoList findTDL() {
//        return toDoListRepository.getOne(1);
//    }
}
