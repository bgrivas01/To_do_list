package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TodoService{

    public final TodoRepository repo;
    public final UserRepository userRepository;

    public TodoService(TodoRepository repo, UserRepository userRepository){
        this.repo = repo;
        this.userRepository = userRepository;
    }
    
    public List<Todo> getAllTodos(){
        return repo.findAll();
    }

    public Todo getTodoById(Long id){ 
        return repo.getById(id);
    }

    public Todo createTodo(String title){
        return repo.save(new Todo(title, false));
    }
    
    public void deleteTodo(Long id){
        repo.deleteById(id); 
    }

    public Todo updateTodo(Long id, String title, boolean completed){
        Optional<Todo> todoOptional = repo.findById(id);
        if (todoOptional.isPresent()){
        Todo todo = todoOptional.get();
        todo.setTitle(title);
        todo.setCompleted(completed);
        return repo.save(todo);
        }
        throw new RuntimeException("Todo not found");
    }

     public Todo addTodoForUser(Long userId, String title) {
        User user = userRepository.findById(userId).orElseThrow();
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setCompleted(false);
        todo.setUser(user);
        return repo.save(todo);
    }

}