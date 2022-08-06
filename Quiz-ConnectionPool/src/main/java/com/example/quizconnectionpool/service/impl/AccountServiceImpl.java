package com.example.quizconnectionpool.service.impl;

import com.example.quizconnectionpool.dao.impl.AccountDaoImpl;
import com.example.quizconnectionpool.model.Account;
import com.example.quizconnectionpool.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDaoImpl accountDao;
    @Override
    public Account login(String username, String password) {
        return accountDao.login(username,password);
    }
    @Override
    public int register(String email, String username, String password) {
        return accountDao.register(email, email, password);
    }
    @Override
    public List<Account> getAllAccounts() {
        return accountDao.getAllAccounts();
    }
    @Override
    public List<Account> findAccountByUsername(String username) {
        return accountDao.findAccountByUsername(username);
    }
    @Override
    public int suspendAccount(Integer id) {
        return accountDao.suspendAccount(id);
    }
    @Override
    public int activateAccount(Integer id) {
        return accountDao.activateAccount(id);
    }
}
