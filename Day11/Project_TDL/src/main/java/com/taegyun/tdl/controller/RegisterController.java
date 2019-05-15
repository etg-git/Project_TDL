package com.taegyun.tdl.controller;


import com.taegyun.tdl.domain.ToDoList;
import com.taegyun.tdl.domain.UserDTO;
import com.taegyun.tdl.repository.ToDoListRepository;
import com.taegyun.tdl.repository.UserRepository;
import com.taegyun.tdl.service.ToDoListService;
import com.taegyun.tdl.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    ToDoListService toDoListService;
    @Autowired
    PasswordEncoder passwordEncoder;

    private UserDTO userDTO;
    private User user;
    @GetMapping
    public String reg() {
        return "/toDoList/register";
    }

    @PostMapping
    public ResponseEntity<?> postUser(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) {
        System.out.println(userDTO);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return new ResponseEntity<>("{}", HttpStatus.BAD_REQUEST);
        }
            userService.save(userDTO.dto());

            return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }
    @PostMapping("/dto")
    public ResponseEntity<?> dtoUser(@RequestBody Map<String, String> user) {
        if (userRepository.findById(user.get("uid")) == null) {
            return new ResponseEntity<>("{}", HttpStatus.OK);
        }
        return user.get("uid").equals(userRepository.findById(user.get("uid")).getId()) ? new ResponseEntity<>("{}", HttpStatus.BAD_REQUEST) : new ResponseEntity<>("{}", HttpStatus.OK);
    }
}

