package com.taskmanagement.utils;

public class NotificationManager {

    public static void notify(String message) {
        System.out.println("NOTIFICATION: " + message);
    }

    public static void logError(String error) {
        System.err.println("ERROR: " + error);
    }
}
