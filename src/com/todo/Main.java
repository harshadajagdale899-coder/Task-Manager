package com.todo;


import java.util.*;
public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        TaskService newSrev =  new TaskService();

        while(true){
            System.out.println("1. Add Task.");
            System.out.println("2. Print ALL Task.");
            System.out.println("3. Mark as Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit.");
            System.out.print("Enter Your choice : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1 :
                    System.out.print("Enter the title of new Task : ");
                    String newTitle = sc.nextLine();
                    if(newTitle.trim().isEmpty()){
                        System.out.println("Task title cannot be empty.");
                        System.out.println();
                        System.out.println();
                        break;
                    }
                    try{
                        Task t1 = newSrev.addTask(newTitle);
                        System.out.println("The tasks are Added successfully!");
                    }catch (Exception e){
                        System.out.println("Error : "+ e.getMessage());
                    }
                    System.out.println();
                    System.out.println();
                    break;

                case 2 :
                    List<Task> copy = newSrev.getAllTask();
                    if(copy.isEmpty()){
                    System.out.println("There are not any tasks yet!");
                    }
                    for(Task el : copy){
                         System.out.println("Task no : "+el.getId()+ "  Task : "+el.getTitle() + "   Status : "+(el.isComplete()? "Completed" : "Pending"));
                    }
                    System.out.println();
                    System.out.println();
                    break;

                case 3:
                    List<Task> listOfTasks = newSrev.getAllTask();
                    System.out.println("List of All Tasks.");
                    for(Task el : listOfTasks){
                        System.out.println(el.getId()+" : "+ el.getTitle());
                    }
                    System.out.print("Enter the id to mark complete : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    try{
                        newSrev.markTaskComplete(id);
                        System.out.println("Successfully marked Complete.");
                    }catch (NoSuchElementException e){
                        System.out.println("Error : "+ e.getMessage());
                    }
                    System.out.println();
                    System.out.println();
                    break;

                case 4:
                    List<Task> listOfTasks1 = newSrev.getAllTask();
                    if(listOfTasks1.isEmpty()){
                        System.out.println("No tasks available to delete.");
                        break;
                    }
                    System.out.println("List of All Tasks.");
                    for(Task el : listOfTasks1){
                        System.out.println(el.getId()+" : "+ el.getTitle());
                    }
                    System.out.print("Enter the id of Task to delete : ");
                    int Id = sc.nextInt();
                    sc.nextLine();
                    try{
                        newSrev.deleteTasks(Id);
                        System.out.println("ID Deleted Successfully.");
                    }catch (IllegalArgumentException e){
                        System.out.println("Error : "+ e.getMessage());
                    }
                    System.out.println();
                    System.out.println();
                    break;
                case 5 :
                    System.out.println("Exited");
                    return ;

                default:
                    System.out.println("Invalid Choice");
            }
        }


    }
}
