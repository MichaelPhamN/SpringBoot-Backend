package com.example.quizconnectionpool.dao;

import com.example.quizconnectionpool.model.Account;

import java.util.List;

public interface AccountDao {
    Account validateLogin(String username, String password);
    int register(String email, String username, String password);
    List<Account> getAllUsers();
    List<Account> findUserByUsername(String username);
    int suspendUser(int id);
    int activateUser(int id);
}
