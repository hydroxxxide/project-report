package com.example.projectreport.controller;

import com.example.projectreport.config.JwtUtil;
import com.example.projectreport.dto.UserDto;
import com.example.projectreport.entity.User;
import com.example.projectreport.mapper.UserMapper;
import com.example.projectreport.service.DetailsUser;
import com.example.projectreport.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;
    private JwtUtil jwtUtil;

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
    @GetMapping("/all")
    public List <UserDto> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return userMapper.userListToUserDtoList(users);
    }

    @PostMapping("/save")
    public String register(@RequestBody UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userService.createUser(user);
        DetailsUser detailsUser = new DetailsUser(user);

        return jwtUtil.generateToken(user);
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

    @ExceptionHandler
    private ResponseEntity<String> handler(EntityNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
