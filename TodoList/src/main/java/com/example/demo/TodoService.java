package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService{

    public final TodoRepository repo;

    public TodoService(TodoRepository repo){
        this.repo = repo;
    }
    
    public List<Todo> getAllTodos(){
        return repo.findAll();
    }

    public Todo createTodo(String title){
        return repo.save(new Todo(title, false));
    }

}