package com.example.projectreport.controller;

import com.example.projectreport.entity.User;
import com.example.projectreport.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PostMapping("/update/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody User user){
        User newUser = userService.getUserById(id);
        return userService.updateUserById(id, user);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }
    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
