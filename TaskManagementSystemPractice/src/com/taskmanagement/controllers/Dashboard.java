package com.taskmanagement.controllers;

import com.taskmanagement.models.Task;

import java.util.List;

public class Dashboard {

    public void displayDashboard(List<Task> taskList) {
        int totalTasks = taskList.size();
        int completedTasks = (int) taskList.stream().filter(task -> task.getStatus().equals("Completed")).count();
        int pendingTasks = totalTasks - completedTasks;

        System.out.println("\n--- Dashboard ---");
        System.out.println("Total Tasks: " + totalTasks);
        System.out.println("Completed Tasks: " + completedTasks);
        System.out.println("Pending Tasks: " + pendingTasks);
    }
}
