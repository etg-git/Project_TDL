package com.taegyun.tdl.controller;

import com.taegyun.tdl.domain.Comment;
import com.taegyun.tdl.domain.ToDoList;
import com.taegyun.tdl.repository.CommentRepository;
import com.taegyun.tdl.repository.ToDoListRepository;
import com.taegyun.tdl.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ToDoListRepository toDoListRepository;

    @Autowired
    CommentService commentService;

    private Comment com;

    private ToDoList toDoList;
/*
    @GetMapping
    public String Reply(){
        return "/toDoList/list";
    }
*/
    @PostMapping("/{idx}")
    public ResponseEntity<?> postComment(@PathVariable("idx") Long idx, @RequestBody Comment comment) {

        ToDoList toDoList = commentService.com(idx);

        comment.setCreatedDate();
        comment.setToDoList(toDoList);
        toDoList.add(comment);

        commentRepository.save(comment);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);

    }
    @PutMapping("/repUpdate/{idx}")
    public ResponseEntity<?> putTDL(@PathVariable("idx") Long idx, @RequestBody String content) {
        Comment persistComment = commentRepository.getOne(idx);
        persistComment.RepUpdate(content);
        commentRepository.save(persistComment);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
    @DeleteMapping("/repDelete/{idx}")
    public ResponseEntity<?> deleteTDL(@PathVariable("idx") Long idx) {
        commentRepository.deleteById(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
