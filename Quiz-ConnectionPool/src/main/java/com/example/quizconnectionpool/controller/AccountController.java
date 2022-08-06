package com.example.quizconnectionpool.controller;

import com.example.quizconnectionpool.model.Account;
import com.example.quizconnectionpool.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    AccountServiceImpl accountService;

    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestParam String username, @RequestParam String password) {
        Account categories = accountService.login(username, password);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Integer> register(@RequestParam String email, @RequestParam String username, @RequestParam String password) {
        int executedRow = accountService.register(email, username, password);
        return new ResponseEntity<>(executedRow, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Account>> findUserByUsername(@RequestParam String username) {
        List<Account> accounts = accountService.findAccountByUsername(username);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public int suspendUser(@PathVariable int id) {
        return accountService.suspendAccount(id);
    }

    @PutMapping("/{id}")
    public int activateUser(@PathVariable int id) {
        return accountService.activateAccount(id);
    }

}
