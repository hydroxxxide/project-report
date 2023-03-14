package com.example.projectreport.service;

import com.example.projectreport.entity.User;
import com.example.projectreport.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + "not found"));
    }
    public User createUser(User user){
        return userRepository.save(user);
    }
    public User updateUserById(Long id, User user){
        User newUser = getUserById(id);
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        return userRepository.save(newUser);
    }
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
