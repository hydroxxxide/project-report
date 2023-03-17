package com.example.projectreport.controller;

import com.example.projectreport.dto.UserDto;
import com.example.projectreport.entity.User;
import com.example.projectreport.mapper.UserMapper;
import com.example.projectreport.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;



@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        User createdUser = userService.createUser(user);
        return userMapper.userToUserDto(createdUser);
    }
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return userMapper.userToUserDto(user);
    }

    @PutMapping("/update/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        User user = userService.getUserById(id);
        User updatedUser = userService.updateUser(id, user);
        return userMapper.userToUserDto(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
