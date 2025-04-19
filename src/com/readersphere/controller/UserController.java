package com.readersphere.controller;

import java.util.HashMap;
import java.util.Map;

import com.readersphere.model.User;

public class UserController {

  private User currentUser;

  // Simulate a simple "user database"
  private final Map<String, User> userDatabase = new HashMap<>();

  public boolean login(String username, String password) {
      User user = userDatabase.get(username);
      if (user != null && user.getPassword().equals(password)) {
          currentUser = user;
          return true;
      }
      return false;
  }

  public boolean register(String username, String email, String password) {
      if (userDatabase.containsKey(username)) return false;

      User newUser = new User(username, email, password);
      userDatabase.put(username, newUser);
      currentUser = newUser;
      return true;
  }

  public void logout() {
      currentUser = null;
  }

  public User getCurrentUser() {
      return currentUser;
  }

  public boolean updateProfile(String newUsername, String newEmail, String newPassword) {
      if (currentUser == null) return false;

      currentUser.setUsername(newUsername);
      currentUser.setEmail(newEmail);
      currentUser.setPassword(newPassword);
      return true;
  }
}
