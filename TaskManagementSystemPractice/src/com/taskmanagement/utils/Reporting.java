package com.taskmanagement.utils;

import com.taskmanagement.models.Task;

import java.util.List;

public class Reporting {

    // Private constructor to prevent instantiation
    private Reporting() {
        throw new UnsupportedOperationException("Utility class");
    }

    // Method to generate a report for all tasks
    public static void generateTaskReport(List<Task> taskList) {
        System.out.println("\n--- Task Report ---");

        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (Task task : taskList) {
            System.out.println("ID: " + task.getTaskID() +
                    ", Title: " + task.getTitle() +
                    ", Description: " + task.getDescription() +
                    ", Status: " + task.getStatus() +
                    ", Priority: " + task.getPriority() +
                    ", Deadline: " + task.getDeadline());
        }
    }
}
