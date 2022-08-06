package com.example.quizconnectionpool.service;

import com.example.quizconnectionpool.model.Account;

import java.util.List;

public interface AccountService {
    Account login(String username, String password);
    int register(String email, String username, String password);
    List<Account> getAllAccounts();
    List<Account> findAccountByUsername(String username);
    int suspendAccount(Integer id);
    int activateAccount(Integer id);
}
