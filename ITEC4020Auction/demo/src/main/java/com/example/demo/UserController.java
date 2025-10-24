package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService = new UserService();

    // Register a new user
    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String firstName,
                               @RequestParam String lastName) {

        userService.registerUser(username, email, password, firstName, lastName);
         return "redirect:/confirm.html";
    }

    // Get user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        User user = userService.getUserByID(id);
        if (user != null) {
            return user;
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }

    // Sign in
    @PostMapping("/signin")
    public String signIn(@RequestParam String username, @RequestParam String password) {
        User user = userService.signIn(username, password);
        if (user != null) {
            return "Welcome back, " + user.getFirstName() + "!";
        } else {
            return "Invalid username or password.";
        }
    }

    // Forgot password flow
    @PutMapping("/reset-password")
    public String resetPassword(@RequestParam String username,
                                @RequestParam String email,
                                @RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam String newPassword) {

        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.forgetPassWord(username, email, firstName, lastName, newPassword);
        return success ? "Password reset successfully!" : "User verification failed — password not changed.";
    }
}
