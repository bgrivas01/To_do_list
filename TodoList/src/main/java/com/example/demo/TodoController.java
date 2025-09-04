package com.example.demo;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping
    public List<Todo> getAllTodos() {
        return service.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id){
        if(id<=0){
            throw new IllegalArgumentException("Id Must be Positive");
        }
        return service.getTodoById(id);
    }
    
    @PostMapping("/{userId}")
    public Todo addTodo(@PathVariable Long userId, @RequestBody Todo todoRequest) {
        return service.addTodoForUser(userId, todoRequest.getTitle());
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id){
        if(id<=0){
            throw new IllegalArgumentException("Id must be positive");
        }
        service.deleteTodo(id);
    }

    @PutMapping("/{id}")
    public Todo updateTodo (@PathVariable Long id, @RequestBody Map<String, Object> body) {
        String title = (String) body.get("title");
        boolean completed = (Boolean) body.get("completed");
        return service.updateTodo(id, title, completed);
    }
}
