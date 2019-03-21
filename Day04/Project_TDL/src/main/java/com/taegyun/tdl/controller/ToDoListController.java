package com.taegyun.tdl.controller;

import com.taegyun.tdl.domain.ToDoList;
import com.taegyun.tdl.repository.ToDoListRepository;
import com.taegyun.tdl.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/toDoList")
public class ToDoListController {
    @Autowired
    ToDoListService toDoListService;

//    @GetMapping({"", "/"})
//    public String toDoList(@RequestParam(value = "idx", defaultValue = "0") Long idx,
//                           Model model) {
//        model.addAttribute("toDoList", toDoListService.findToDoListByIdx(idx));
//
//        return "/toDoList/form";
//    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("toDoList", toDoListService.findToDoList());
        return "/toDoList/list";
    }
}


