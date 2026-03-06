package com.todo;
import java.util.*;

public class TaskService {
    //Declaration of List to Store task.
    private List<Task> tasks;

    //Constructor.
    public TaskService(){
        tasks = new ArrayList<>();
    }

    //Id variable
    private int  nextId = 1 ;

    //Add new Id method
    public Task addTask(String newTitle){
        //Exception if the title entered is null
        if(newTitle == null){
            throw new IllegalArgumentException("You can't enter a empty String.");
        }

        //Trimmed the string.(Title)
        String trimString = newTitle.trim();

        //Catched Exception if trimmed title if empty.
        if(trimString.isEmpty()){
            throw new IllegalArgumentException("Invalid Title");
        }

        //Assigned the ID and incremented.
        int currId = nextId ;
        nextId++;

        // Created a new task
        Task newTask = new Task(currId , trimString , false);

        //Added to list
        tasks.add(newTask);

        //Finally returned the task
        return newTask ;
    }

     public List<Task>  getAllTask(){
        return new ArrayList<>(tasks);
    }

    public void markTaskComplete(int id){
        boolean idFound = false;
        for(Task el : tasks){
            if(el.getId() == id){
                el.setComplete(true);
                idFound  = true;
                return;
            }
        }
        if(!idFound){
            throw new NoSuchElementException("id not found");
        }
    }

    public void deleteTasks(int id){
        boolean isFound = false;
        Iterator<Task> it = tasks.iterator();
        while(it.hasNext()){
            Task el = it.next();

            if(el.getId() == id){
                it.remove();
                isFound = true;
                return ;
            }
        }
        if(!isFound){
            throw new IllegalArgumentException("ID not Found!");
        }
    }

}
