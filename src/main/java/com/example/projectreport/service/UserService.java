package com.example.projectreport.service;

import com.example.projectreport.dto.UserDto;
import com.example.projectreport.entity.User;
import com.example.projectreport.enums.UserRole;
import com.example.projectreport.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

//    @Override
//    public User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException {
//        if (emailExists(userDto.getEmail())) {
//            throw new UserAlreadyExistException("There is an account with that email address: "
//                    + userDto.getEmail());
//        }
//
//        User user = new User();
//        user.setUsername(userDto.getUsername());
//        user.setPassword(userDto.getPassword());
//        user.setEmail(userDto.getEmail());
//        user.setUserStatus(userDto.getUserStatus());
//
//        return userRepository.save(user);
//    }
//
//    private boolean emailExists(String email) {
//        return userRepository.findByEmail(email) != null;
//    }

    //для теста Хашемчика
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + "not found"));
    }
    public User createUser(User user){
        user.setUserRole(UserRole.USER);
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
    public User login(String email, String password){
        return userRepository.findByEmailAndPassword(email, password);
    }
}
