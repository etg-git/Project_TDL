package com.taegyun.tdl.controller;

import com.taegyun.tdl.domain.ToDoList;
import com.taegyun.tdl.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/toDoLists")
public class TDLRestController {

    @Autowired
    ToDoListRepository toDoListRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getList() {
        List<ToDoList> toDoLists = toDoListRepository.findAll();
        return ResponseEntity.ok(toDoLists);
    }

    @PostMapping
    public ResponseEntity<?> postTDL(@RequestBody ToDoList toDoList) {
        toDoList.setCreatedDate();
        toDoListRepository.save(toDoList);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @PutMapping("/update/{idx}")
    public ResponseEntity<?> putTDL(@PathVariable("idx")Long idx, @RequestBody ToDoList toDoList) {
        ToDoList persistToDoList = toDoListRepository.getOne(idx);
        persistToDoList.update(toDoList);
        toDoListRepository.save(persistToDoList);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<?> deleteTDL(@PathVariable("idx")Long idx) {
        toDoListRepository.deleteById(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

}
