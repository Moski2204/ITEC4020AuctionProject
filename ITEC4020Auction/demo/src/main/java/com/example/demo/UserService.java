package com.example.demo;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public void registerUser(String username, String email, String password, String firstName, String lastName) {
        if (username == null || username.isEmpty()) {
            System.out.println("Username cannot be empty.");
            return;
        }

        User user = new User(username, email, password, firstName, lastName);
        userDAO.addUser(user);
        System.out.println("User registered successfully!");
    }

    public User getUserByID(int id) {
        return userDAO.getUserById(id);
    }


    public User signIn(String username, String password){
        return userDAO.getUserByLogin(username, password);
    }

    
}