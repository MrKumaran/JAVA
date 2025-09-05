package Learning.TaskManagement.taskManager;

import Learning.TaskManagement.data.Task;
import Learning.TaskManagement.data.TaskStorage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TaskManager {

    private final TaskStorage taskStorage = new TaskStorage();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Scanner scan;

    public TaskManager(Scanner scan){
        this.scan = scan;
    }

    public void addTaskView(){
        Date dueDate;
        System.out.print("Enter Task ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter Task Name: ");
        String name = scan.nextLine();
        System.out.print("Enter Task description: ");
        String description = scan.nextLine();

        while(true){
            System.out.println("Enter due date(DD-MM-YYYY): ");
            String date = scan.next();
            scan.nextLine();
            try{
                dueDate = dateFormat.parse(date);
                if (new Date().compareTo(dueDate) > 0){
                    System.out.println("Enter valid date");
                }
                else {
                    break;
                }
            }
            catch (ParseException e){
                System.out.println("Enter date in valid Format");
            }
        }

        var task = new Task.Builder()
                .setId(id)
                .setName(name)
                .setDescription(description)
                .setDueDate(dueDate)
                .build();
        taskStorage.addTask(task);
        String message;
        if (taskStorage.isContainTask(task)){
            message = "Task added successfully \nAdd another task?(Y/N): ";
        }
        else {
            message = "Task not added, try adding again \nTry again?(Y/N): ";
        }
        System.out.print(message);
        char selection = scan.next().toLowerCase().charAt(0);
        if (selection == 'y') addTaskView();
        else System.out.println();
    }

    public void showTasks(){
        for (Task task: taskStorage.getTaskList()){
            System.out.printf(
                    "Task ID: %-2d | Task Name: %-10s | Task Description: %-20s | Due Date: %10s \n",
                    task.getId(),
                    task.getName(),
                    task.getDescription(),
                    dateFormat.format(task.getDueDate())
            );
        }
        if (taskStorage.isEmpty()){
            System.out.println("No Task to display");
            System.out.println("Wanna add task?(Y/N): ");
            char selection = scan.next().toLowerCase().charAt(0);
            if (selection == 'y') addTaskView();
            System.out.println();
        }
        else {
            System.out.println("\n\nPress any key to go back to main screen...");
            scan.nextLine();
        }
    }

    public void removeTask(){
        System.out.print("Enter id of task to remove: ");
        int id = scan.nextInt();
        scan.nextLine();
        Task task = taskStorage.getTaskById(id);
        if (task == null) System.out.println("No task with Such ID");
        else{
            taskStorage.removeTask(task);
            if (!taskStorage.isContainTask(task)) System.out.println("Task removed successfully...");
            else {
                System.out.println("Task didn't removed, retry...");
            }
        }
    }

}
