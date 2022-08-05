package com.example.quizconnectionpool.service;

import com.example.quizconnectionpool.model.Account;

import java.util.List;

public interface AccountService {
    Account validateLogin(String username, String password);
    int register(String email, String username, String password);
    List<Account> getAllUsers();
    List<Account> findUserByUsername(String username);
    int suspendUser(Integer id);
    int activateUser(Integer id);
}
