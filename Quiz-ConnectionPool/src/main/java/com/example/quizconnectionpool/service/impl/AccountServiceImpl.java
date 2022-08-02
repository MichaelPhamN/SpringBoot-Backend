package com.example.quizconnectionpool.service.impl;

import com.example.quizconnectionpool.model.Account;
import com.example.quizconnectionpool.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public Account validateLogin(String username, String password) {
        return null;
    }

    @Override
    public Account register(String name, String email, String username, String password) {
        return null;
    }

    @Override
    public List<Account> getAllUsers() {
        return null;
    }

    @Override
    public Account findUserByUsername(String username) {
        return null;
    }

    @Override
    public Account suspendUser(Integer id) {
        return null;
    }

    @Override
    public Account activateUser(Integer id) {
        return null;
    }
}
