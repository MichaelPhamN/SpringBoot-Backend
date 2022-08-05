package com.example.quizconnectionpool.service.impl;

import com.example.quizconnectionpool.model.Account;
import com.example.quizconnectionpool.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountService accountService;
    @Override
    public Account validateLogin(String username, String password) {
        return accountService.validateLogin(username,password);
    }
    @Override
    public int register(String email, String username, String password) {
        return accountService.register(email, email, password);
    }
    @Override
    public List<Account> getAllUsers() {
        return accountService.getAllUsers();
    }
    @Override
    public List<Account> findUserByUsername(String username) {
        return accountService.findUserByUsername(username);
    }
    @Override
    public int suspendUser(Integer id) {
        return accountService.suspendUser(id);
    }
    @Override
    public int activateUser(Integer id) {
        return accountService.activateUser(id);
    }
}
