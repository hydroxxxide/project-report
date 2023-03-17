package com.example.projectreport.service;

import com.example.projectreport.entity.User;

import java.util.List;

public interface UsersServiceForLogin {
    public void saveUser(User user);
    public List<Object> isUserPresent(User user);
}
