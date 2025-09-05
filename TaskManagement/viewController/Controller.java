package Learning.TaskManagement.viewController;

import Learning.TaskManagement.taskManager.TaskManager;

import java.util.Scanner;

public class Controller {

    private final Scanner scan = new Scanner(System.in);

    public void mainScreen() {
        TaskManager taskManager = new TaskManager(scan);
        int option;
        while (true) {
            System.out.println("""
                    1 -> Add Task
                    2 -> Remove task
                    3 -> View Task
                    4 -> Exit
                    """);
            option = scan.nextInt();
            scan.nextLine();
            if (option == 1) {
                taskManager.addTaskView();
            } else if (option == 2) {
                taskManager.removeTask();
            } else if (option == 3) {
                taskManager.showTasks();
            } else if (option == 4) {
                System.out.println("Bye Bye");
                scan.close();
                break;
            } else {
                System.out.println("\n --Pick an option from list-- \n");
            }
        }
    }
}
