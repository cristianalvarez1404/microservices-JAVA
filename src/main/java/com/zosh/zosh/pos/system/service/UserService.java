package com.zosh.zosh.pos.system.service;

import com.zosh.zosh.pos.system.models.User;

import java.util.List;

public interface UserService {

    User getUserFromJwtToken(String token);
    User getCurrentUser();
    User getUserByEmail(String email);
    User getUserById(Long id);
    List<User> getAllUsers();
}
