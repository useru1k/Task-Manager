package view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import controller.AuthController;
import controller.TaskController;
import model.Task;
import model.User;

public class Main {

	private static final Scanner scanner = new Scanner(System.in);
    private static final AuthController authController = new AuthController();
    private static final TaskController taskController = new TaskController();
    
    public static void main(String arsa[]) {
    	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
    	System.out.println("++++++++++++ Welcome to Task Manager +++++++++++");
    	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");

    	while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
            	register();
            	login();
            }
            else if (choice == 2) {
            	login();
            }
            else {
            	System.out.println("Bye..! See you again");
            	break;
            }
        }
    }
    
    private static void register() {
    	
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean success = authController.register(username, password);
        System.out.println(success ? "Registered!" : "Failed to register.");
        
    }
    
    private static void login() {
    	
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = authController.login(username, password);
        if (user != null) {
            System.out.println("Welcome " + user.getUsername() + "!");
            taskMenu(user);
        } else {
            System.out.println("Login failed!");
        }
    }
    
    private static void taskMenu(User user) {
        while (true) {
            System.out.println("\n1. View Tasks\n2. Add Task\n3. Update Task\n4. Delete Task\n5. Logout");
            System.out.print("Choice: ");
            int ch = Integer.parseInt(scanner.nextLine());

            if (ch == 1) {
                List<Task> tasks = taskController.getUserTasks(user.getId());
                tasks.forEach(t -> System.out.println(t.getId() + ": " + t.getTitle() + " [" + t.getStatus() + "]"));
            } else if (ch == 2) {
                System.out.print("Title: ");
                String title = scanner.nextLine();
                
                System.out.print("Description: ");
                String desc = scanner.nextLine();
                
                System.out.print("Due Date (YYYY-MM-DD): ");
                LocalDate date = LocalDate.parse(scanner.nextLine());

                Task task = new Task(0, title, desc, "Pending", date, user.getId());
                System.out.println(taskController.createTask(task) ? "Task Added!" : "Failed to add task.");
            } else if (ch == 3) {
                System.out.print("Task ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                
                System.out.print("New Title: ");
                String title = scanner.nextLine();
                
                System.out.print("New Description: ");
                String desc = scanner.nextLine();
                
                System.out.print("New Status: ");
                String status = scanner.nextLine();
                
                System.out.print("New Due Date (YYYY-MM-DD): ");
                LocalDate date = LocalDate.parse(scanner.nextLine());

                Task task = new Task(id, title, desc, status, date, user.getId());
                System.out.println(taskController.updateTask(task) ? "Updated!" : "Update Failed!");
            } else if (ch == 4) {
                System.out.print("Task ID to delete: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println(taskController.deleteTask(id) ? "Deleted!" : "Delete Failed!");
            } else {
                break;
            }
        }
    }
}
