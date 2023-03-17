package com.example.projectreport.service;

import com.example.projectreport.entity.User;
import com.example.projectreport.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {


    UserRepository userRepository;


//    @Override
//    public User registerNewUserAccount() throws UserAlreadyExistException {
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

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User login(String email, String password){
        return userRepository.findByEmailAndPassword(email, password);
    }
}
