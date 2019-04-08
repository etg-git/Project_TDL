package com.taegyun.tdl.controller;

import com.taegyun.tdl.domain.ToDoList;
import com.taegyun.tdl.domain.User;
import com.taegyun.tdl.repository.ToDoListRepository;
import com.taegyun.tdl.repository.UserRepository;
import com.taegyun.tdl.service.ToDoListService;
import com.taegyun.tdl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/toDoList")
public class ToDoListController {
    @Autowired
    ToDoListService toDoListService;
    @Autowired
    UserService userService;
    @Autowired
    ToDoListRepository toDoListRepository;
    @Autowired
    UserRepository userRepository;

    private User id;
    private ToDoList id2;

    @GetMapping("/hello")
    public String hello() {
        User user = new User();
        user.setId("hello");
        user.setPassword("hello");
        userService.save(user);

        return "/toDoList/hello";
    }

    @GetMapping("/list")
    public String list(Model model) {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        id = toDoListService.findUser(user.getUsername());

        model.addAttribute("toDoList", toDoListService.findUser2(id.getIdx()));
        return "/toDoList/list";
    }

    @PostMapping
    public ResponseEntity<?> postTDL(@RequestBody ToDoList toDoList) {
        id.add(toDoList);
        toDoList.setCreatedDate();
        toDoListRepository.save(toDoList);
        System.out.println(id.toString());
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @PutMapping("/status/{idx}")
    public ResponseEntity<?> putStatus(@PathVariable("idx") Long idx) {
        ToDoList pstTDL = toDoListRepository.getOne(idx);
        System.out.println(pstTDL);

        if (pstTDL.getStatus() == false) pstTDL.status();
        else pstTDL.status2();

        toDoListRepository.save(pstTDL);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
    @PostMapping("/show")
    public ResponseEntity<?> showTDL(@PathVariable("idx") Long idx) {
        ToDoList pstToDoList = toDoListRepository.getOne(idx);
        toDoListRepository.save(pstToDoList);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
    @PutMapping("/update/{idx}")
    public ResponseEntity<?> putTDL(@PathVariable("idx") Long idx, @RequestBody ToDoList toDoList) {
        ToDoList persistToDoList = toDoListRepository.getOne(idx);
        persistToDoList.update(toDoList);
        toDoListRepository.save(persistToDoList);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @PutMapping("/update2/{idx}")
    public ResponseEntity<?> putTDL2(@PathVariable("idx") Long idx, @RequestBody ToDoList toDoList) {
        ToDoList persistToDoList = toDoListRepository.getOne(idx);
        persistToDoList.update2(toDoList);
        toDoListRepository.save(persistToDoList);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idx}")
    public ResponseEntity<?> deleteTDL(@PathVariable("idx") Long idx) {
        toDoListRepository.deleteById(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @PostMapping("/complete")
    public ResponseEntity<?> completeTDL(@RequestBody Map<String, String> user) {
        return null;
    }

}

//    @GetMapping({"", "/"})
//    public String toDoList(@RequestParam(value = "idx", defaultValue = "0") Long idx,
//                           Model model) {
//        model.addAttribute("toDoList", toDoListService.findToDoListByIdx(idx));
//
//        return "/toDoList/form";
//    }


