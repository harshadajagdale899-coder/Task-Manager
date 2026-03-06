package com.todo;

public class Task {

    //Variables
    private int id ;
    private String title;
    private boolean isComplete ;

    //Constructor
    public Task(int id , String title , boolean isComplete){
        this.id = id ;
        this.title = title;
        this.isComplete = isComplete ;
    }

    //Getter for id and title
    public int  getId(){
        return id;
    }

    //Getter for title
    public String getTitle(){
        return title;
    }

    //getter to know if task is complete or not.
    public boolean isComplete() {
        return isComplete;
    }

    //Setter to set that task is complete.
    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    @Override
    public String toString(){
        return id + ". "+ title+ " [" + (isComplete ? "Complete" : "Pending") + " ]" ;
    }



}
