package com.taskmanagement.services;

import com.taskmanagement.models.User;

import java.util.List;

public class UserService {

    public void addUser(List<User> userList, User user) {
        userList.add(user);
    }


    public void updateUser(User user, String name, String email) {
        user.setName(name);
        user.setEmail(email);
    }


    public void deleteUser(List<User> userList, int userID) {
        userList.removeIf(user -> user.getUserID() == userID);
    }

    public User getUserById(List<User> userList, int userID) {
        for (User user : userList) {
            if (user.getUserID() == userID) {
                return user;
            }
        }
        return null;
    }


    public void displayAllUsers(List<User> userList) {
        for (User user : userList) {
            user.displayUserDetails();
        }
    }
}
