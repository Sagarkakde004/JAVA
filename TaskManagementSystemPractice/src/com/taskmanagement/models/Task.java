package com.taskmanagement.models;

public class Task {
    private int taskID;
    private String title;
    private String description;
    private String priority;
    private String deadline;
    private String status;
    private User assignedUser;

    public Task(int taskID, String title, String description, String priority, String deadline, String status) {
        this.taskID = taskID;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
        this.status = status;
        this.assignedUser = null;
    }


    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {

        this.assignedUser = assignedUser;
    }

    public int getTaskID() {

        return taskID;
    }

    public void setTaskID(int taskID) {

        this.taskID = taskID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {

        return priority;
    }

    public void setPriority(String priority) {

        this.priority = priority;
    }

    public String getDeadline() {

        return deadline;
    }

    public void setDeadline(String deadline) {

        this.deadline = deadline;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }


    public void displayTaskDetails() {
        System.out.println("Task ID: " + taskID);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Priority: " + priority);
        System.out.println("Deadline: " + deadline);
        System.out.println("Status: " + status);
        if (assignedUser != null) {
            System.out.println("Assigned User: " + assignedUser.getName() + " (ID: " + assignedUser.getUserID() + ")");
        } else {
            System.out.println("Assigned User: None");
        }
    }
}
