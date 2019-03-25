package com.taegyun.tdl.controller;

import com.taegyun.tdl.domain.ToDoList;
import com.taegyun.tdl.domain.User;
import com.taegyun.tdl.repository.ToDoListRepository;
import com.taegyun.tdl.repository.UserRepository;
import com.taegyun.tdl.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping("/toDoList")
public class ToDoListController {
    @Autowired
    ToDoListService toDoListService;
    @Autowired
    ToDoListRepository toDoListRepository;
    @Autowired
    UserRepository userRepository;

    private User id;

    @GetMapping("/list")
    public String list(Model model) {
        if (this.id == null) return "redirect:/toDoList/login";

        else {
            model.addAttribute("toDoList", toDoListService.findToDoList(this.id));
            return "/toDoList/list";
        }
    }
    @GetMapping("/logout")
    public String logout() {
        this.id = null;
        return "redirect:/toDoList/login";
    }
    @PostMapping
    public ResponseEntity<?> postTDL(@RequestBody ToDoList toDoList) {
        toDoList.setUser(id);
        toDoList.setCreatedDate();
        toDoListRepository.save(toDoList);
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

    @PutMapping("/update/{idx}")
    public ResponseEntity<?> putTDL(@PathVariable("idx") Long idx, @RequestBody ToDoList toDoList) {
        ToDoList persistToDoList = toDoListRepository.getOne(idx);
        persistToDoList.update(toDoList);
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

        this.id = userRepository.findById(user.get("id"));
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}

//    @GetMapping({"", "/"})
//    public String toDoList(@RequestParam(value = "idx", defaultValue = "0") Long idx,
//                           Model model) {
//        model.addAttribute("toDoList", toDoListService.findToDoListByIdx(idx));
//
//        return "/toDoList/form";
//    }


