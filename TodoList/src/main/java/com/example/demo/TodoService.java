package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class TodoService{

    public final TodoRepository repo;

    public TodoService(TodoRepository repo){
        this.repo = repo;
    }
    

}