package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo_list")
public class Todo{

    //makes it so an id is generated each and every time a new todo item is added
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean completed;

    public Todo(String title, boolean completed){

        this.title = title;
        this.completed = false; //so it always starts as incompleted 
    }

    public Todo(){

    }

    //getters & Setters -------------------
    public Long getId(){
        return id;
    }

    public String gettitle(){
        return title;
    }
    
    public boolean getCompleted(){
        return completed;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }
    
    public void setCompleted(boolean completed){
        this.completed = completed;
    }


}