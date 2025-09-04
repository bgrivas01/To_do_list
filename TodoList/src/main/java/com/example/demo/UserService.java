package com.example.demo;


import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a single user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}


