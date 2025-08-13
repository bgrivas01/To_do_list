package com.example.demo;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService service;


    public TodoController(TodoService service){
        this.service = service;
    }

    @GetMapping("/api/todos")
    public List<Todo> getAllTodos() {
        return service.getAllTodos();
    }
    
    @PostMapping()
    public Todo createTodo(@RequestBody Map<String, String> body){
        return service.createTodo(body.get("title"));
    }
    
    

}
