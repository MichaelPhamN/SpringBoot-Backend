package com.example.quizconnectionpool.service;

import com.example.quizconnectionpool.model.Account;

import java.util.List;

public interface AccountService {
    Account validateLogin(String username, String password);
    Account register(String name, String email, String username, String password);
    List<Account> getAllUsers();
    Account findUserByUsername(String username);
    Account suspendUser(Integer id);
    Account activateUser(Integer id);
}
