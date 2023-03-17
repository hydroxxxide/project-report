package com.example.projectreport.controller;

import com.example.projectreport.dto.UserDto;
import com.example.projectreport.entity.User;
import com.example.projectreport.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;



@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = mapToUser(userDto);
        User createdTask = userService.createUser(user);
        return mapToUserDto(createdTask);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return mapToUserDto(user);
    }

    @PutMapping("/update/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        User user = userService.getUserById(id);
        User updatedUser = userService.updateUser(id, user);
        return mapToUserDto(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    private User mapToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserRole(userDto.getUserRole());
        return user;
    }
    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setUserRole(user.getUserRole());
        return userDto;
    }
}
