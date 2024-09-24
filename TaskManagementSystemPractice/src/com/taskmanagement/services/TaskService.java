package com.taskmanagement.services;

import com.taskmanagement.models.Task;
import com.taskmanagement.models.User;

import java.util.List;

public class TaskService {

    private final Object lock = new Object();

    public void addTask(List<Task> taskList, Task task) { //task is reference of newTask
        synchronized (lock) {
            taskList.add(task);
        }
    }

    public void updateTask(Task task, String title, String description, String priority, String deadline, String status) {
        synchronized (lock) {
            task.setTitle(title);
            task.setDescription(description);
            task.setPriority(priority);
            task.setDeadline(deadline);
            task.setStatus(status);
        }
    }


    public void deleteTask(List<Task> taskList, int taskID) {
        synchronized (lock) {
            taskList.removeIf(task -> task.getTaskID() == taskID);//lamda expression and predefine method by list interface(removeIf)
        }
    }

    public Task getTaskById(List<Task> taskList, int taskID) {
        synchronized (lock) {
            for (Task task : taskList) {
                if (task.getTaskID() == taskID) {
                    return task;
                }
            }
            return null;
        }
    }

    public void displayAllTasks(List<Task> taskList) {
        synchronized (lock) {
            for (Task task : taskList) {
                task.displayTaskDetails();
            }
        }
    }
    public void assignUserToTask(Task task, User user) {

        task.setAssignedUser(user);
    }

    public void unassignUserFromTask(Task task) {

        task.setAssignedUser(null);
    }
}
