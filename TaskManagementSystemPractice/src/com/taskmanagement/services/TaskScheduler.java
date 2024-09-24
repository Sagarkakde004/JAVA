package com.taskmanagement.services;

import com.taskmanagement.models.Task;

public class TaskScheduler implements Runnable {

    private final Task task;

    public TaskScheduler(Task task) {
        this.task = task;
    }

    @Override //runnable run()
    public void run() {
        try {
            System.out.println("Task ID: " + task.getTaskID() + " is being processed...");
            Thread.sleep(2000);
            task.setStatus("Completed");
            System.out.println("Task ID: " + task.getTaskID() + " has been completed.");
        } catch (InterruptedException e) {
            System.out.println("Task processing interrupted for Task ID: " + task.getTaskID());
        }
    }
}
