package com.example.quizhibernate.service;

import com.example.quizhibernate.model.Account;

import java.util.List;

public interface AccountService {
    public int addAccount(Account account);
    public int editAccount(Account account);
    public Account findAccountById(Integer id);
    public List<Account> findAccounts();
    public int deleteAccount(Integer id);
}
