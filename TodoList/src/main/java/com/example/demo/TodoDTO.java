package com.example.demo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;




public class TodoDTO {
    
    @NotBlank(message = "title cannot be blank")
    @Size(max =100, message = "title needs to contain less than 100 characters")
    private String titleString;
    
    private boolean completed;

    public String getTitle() {
        return titleString;
    }

    public void setTitle(String titleString) {
        this.titleString = titleString;
    }

    public boolean getCompleted(){
        return completed;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }


    

}