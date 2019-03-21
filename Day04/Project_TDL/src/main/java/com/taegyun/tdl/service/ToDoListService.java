package com.taegyun.tdl.service;

import com.taegyun.tdl.domain.ToDoList;
import com.taegyun.tdl.repository.ToDoListRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService {
    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public List<ToDoList> findToDoList() {
//        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return toDoListRepository.findByOrderByIdxAsc();
    }
}

//    public ToDoList findToDoListByIdx(Long idx) {
//        return toDoListRepository.findById(idx).orElse(new ToDoList());
//    }
//}
