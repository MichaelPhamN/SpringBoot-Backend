package com.example.quizconnectionpool.dao;

import com.example.quizconnectionpool.model.Account;

import java.util.List;

public interface AccountDao {
    Account login(String username, String password);
    int register(String email, String username, String password);
    List<Account> getAllAccounts();
    List<Account> findAccountByUsername(String username);
    int suspendAccount(int id);
    int activateAccount(int id);
}
