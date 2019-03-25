package com.taegyun.tdl.controller;


import com.taegyun.tdl.domain.ToDoList;
import com.taegyun.tdl.domain.User;
import com.taegyun.tdl.repository.UserRepository;
import com.taegyun.tdl.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/toDoList")
public class LoginController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ToDoListService toDoListService;

    @GetMapping("/login")
    public String login() {
        return "/toDoList/login";
    }
    @PostMapping("/api/login")
    public ResponseEntity<?> loginTDL(@RequestBody Map<String, String> user) {
        String id = user.get("id");
        String password = user.get("password");

        User loginUser = userRepository.findById(id);

        if(loginUser == null){

            return null;
        }

        else {
            if (!password.equals(loginUser.getPassword()))
                return null;

            else {
                return new ResponseEntity<>("{}", HttpStatus.OK);
            }
        }

    }
}
