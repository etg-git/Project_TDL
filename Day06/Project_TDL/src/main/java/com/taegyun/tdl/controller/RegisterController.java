package com.taegyun.tdl.controller;


import com.taegyun.tdl.domain.ToDoList;
import com.taegyun.tdl.domain.User;
import com.taegyun.tdl.repository.ToDoListRepository;
import com.taegyun.tdl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/toDoList")
public class RegisterController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String reg() {
        return "/toDoList/register";
    }

    @PostMapping("/api/register")
    public ResponseEntity<?> postUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }
}
