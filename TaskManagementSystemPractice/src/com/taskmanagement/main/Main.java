package com.taskmanagement.main;

import com.taskmanagement.models.Task;
import com.taskmanagement.models.User;
import com.taskmanagement.services.TaskService;
import com.taskmanagement.services.UserService;
import com.taskmanagement.services.TaskScheduler;
//import com.taskmanagement.controllers.TaskController;
import com.taskmanagement.utils.NotificationManager;
import com.taskmanagement.controllers.Dashboard;
import com.taskmanagement.utils.Reporting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new TaskService();
        UserService userService = new UserService();

//        TaskScheduler taskScheduler = new TaskScheduler();
//        TaskController taskController = new TaskController(taskService);

        Dashboard dashboard = new Dashboard();
//        Reporting reporting = new Reporting();
        List<Task> taskList = new ArrayList<>();
        List<User> userList = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Display All Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Add User");
            System.out.println("6. Display All Users");
            System.out.println("7. Update User");
            System.out.println("8. Delete User");
            System.out.println("9. Assign User to Task");
            System.out.println("10. Unassign User from Task");
            System.out.println("11. Schedule Task");
            System.out.println("12. Dashbord");
            System.out.println("13. Reporting");
            System.out.println("14. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter task title:");
                    String title = scanner.nextLine();

                    System.out.println("Enter task description:");
                    String description = scanner.nextLine();

                    System.out.println("Enter task priority (Low, Medium, High):");
                    String priority = scanner.nextLine();

                    System.out.println("Enter task deadline (YYYY-MM-DD):");
                    String deadline = scanner.nextLine();

                    Task newTask = new Task(taskList.size() + 1, title, description, priority, deadline, "Not Started");
                    taskService.addTask(taskList, newTask);

                    System.out.println("Task added:");
                    newTask.displayTaskDetails();
                    break;

                case 2:
                    System.out.println("All Tasks:");
                    taskService.displayAllTasks(taskList);
                    break;

                case 3:
                    System.out.println("Enter task ID to update:");
                    int updateTaskID = scanner.nextInt();
                    scanner.nextLine();

                    Task taskToUpdate = taskService.getTaskById(taskList, updateTaskID);
                    if (taskToUpdate != null) {
                        System.out.println("Enter new task title:");
                        String newTitle = scanner.nextLine();

                        System.out.println("Enter new task description:");
                        String newDescription = scanner.nextLine();

                        System.out.println("Enter new task priority (Low, Medium, High):");
                        String newPriority = scanner.nextLine();

                        System.out.println("Enter new task deadline (YYYY-MM-DD):");
                        String newDeadline = scanner.nextLine();

                        System.out.println("Enter new task status (Not Started, In Progress, Completed):");
                        String newStatus = scanner.nextLine();

                        taskService.updateTask(taskToUpdate, newTitle, newDescription, newPriority, newDeadline, newStatus);
                        NotificationManager.notify("Task updated successfully!");
                        taskToUpdate.displayTaskDetails();
                    } else {
                        System.out.println("Task not found!");
                    }
                    break;

                case 4:
                    System.out.println("Enter task ID to delete:");
                    int deleteTaskID = scanner.nextInt();
                    scanner.nextLine();

                    Task taskToDelete = taskService.getTaskById(taskList, deleteTaskID);
                    if (taskToDelete != null) {
                        taskService.deleteTask(taskList, deleteTaskID);
                        NotificationManager.notify("Task deleted successfully!");
                    } else {
                        NotificationManager.logError("Task not found!");
                    }
                    break;

                case 5:
                    System.out.println("Enter user name:");
                    String name = scanner.nextLine();

                    System.out.println("Enter user email:");
                    String email = scanner.nextLine();


                    User newUser = new User(userList.size() + 1, name, email);
                    userService.addUser(userList, newUser);

                    System.out.println("User added:");
                    newUser.displayUserDetails();
                    break;

                case 6:
                    System.out.println("All Users:");
                    userService.displayAllUsers(userList);
                    break;

                case 7:
                    System.out.println("Enter user ID to update:");
                    int updateUserID = scanner.nextInt();
                    scanner.nextLine();

                    User userToUpdate = userService.getUserById(userList, updateUserID);
                    if (userToUpdate != null) {
                        System.out.println("Enter new user name:");
                        String newName = scanner.nextLine();

                        System.out.println("Enter new user email:");
                        String newEmail = scanner.nextLine();

                        userService.updateUser(userToUpdate, newName, newEmail);
                        NotificationManager.notify("User updated successfully!");
                        userToUpdate.displayUserDetails();
                    } else {
                        NotificationManager.logError("User not found!");
                    }
                    break;

                case 8:
                    System.out.println("Enter user ID to delete:");
                    int deleteUserID = scanner.nextInt();
                    scanner.nextLine();

                    User userToDelete = userService.getUserById(userList, deleteUserID);
                    if (userToDelete != null) {
                        userService.deleteUser(userList, deleteUserID);
                        NotificationManager.notify("User deleted successfully!");
                    } else {
                        NotificationManager.logError("User not found!");
                    }
                    break;

                case 9:
                    System.out.println("Enter task ID to assign:");
                    int taskIDToAssign = scanner.nextInt();
                    scanner.nextLine();

                    Task taskToAssign = taskService.getTaskById(taskList, taskIDToAssign);
                    if (taskToAssign != null) {
                        System.out.println("Enter user ID to assign:");
                        int userIDToAssign = scanner.nextInt();
                        scanner.nextLine();

                        User userToAssign = userService.getUserById(userList, userIDToAssign);
                        if (userToAssign != null) {
                            taskService.assignUserToTask(taskToAssign, userToAssign);
                            NotificationManager.notify("User assigned to task successfully!");
                        } else {
                            NotificationManager.logError("User not found!");
                        }
                    } else {
                        NotificationManager.logError("Task not found!");
                    }
                    break;

                case 10:
                    System.out.println("Enter task ID to unassign:");
                    int taskIDToUnassign = scanner.nextInt();
                    scanner.nextLine();

                    Task taskToUnassign = taskService.getTaskById(taskList, taskIDToUnassign);
                    if (taskToUnassign != null) {
                        taskService.unassignUserFromTask(taskToUnassign);
                        NotificationManager.notify("User unassigned from task successfully!");
                    } else {
                        NotificationManager.logError("Task not found!");
                    }
                    break;

                case 11:
                    System.out.println("Enter task ID to schedule:");
                    int taskIDToSchedule = scanner.nextInt();
                    scanner.nextLine();

                    Task taskToSchedule = taskService.getTaskById(taskList, taskIDToSchedule);
                    if (taskToSchedule != null && !taskToSchedule.getStatus().equals("Completed")) {
                        TaskScheduler scheduler = new TaskScheduler(taskToSchedule);
                        Thread taskThread = new Thread(scheduler);
                        taskThread.start();
                    } else {
                        NotificationManager.logError("Task not found or already completed.");
                    }
                    break;
                case 12:
                    dashboard.displayDashboard(taskList);
                    break;
                case 13:
                    Reporting.generateTaskReport(taskList);
                    break;
                case 14:
                    NotificationManager.notify("Exiting...");
//                    taskScheduler.shutdown();
                    scanner.close();
                    return;
                default:
                    NotificationManager.notify("Invalid option. Please try again.");
            }
        }
    }
}
