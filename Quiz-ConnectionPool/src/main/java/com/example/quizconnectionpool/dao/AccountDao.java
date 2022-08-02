package com.example.quizconnectionpool.dao;

import com.example.quizconnectionpool.model.Account;

import java.util.List;

public interface AccountDao {
    Account validateLogin(String username, String password);
    Account register(String email, String username, String password);
    List<Account> getAllUsers();
    Account findUserByUsername(String username);
    Account suspendUser(Integer id);
    Account activateUser(Integer id);
}
