package com.example.techtask.service.impl;

import com.example.techtask.model.User;
import com.example.techtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Override
    public User findUser() {
        return null;
    }

    @Override
    public List<User> findUsers() {
        return List.of();
    }
}
