package com.example.quizconnectionpool.dao.impl;

import com.example.quizconnectionpool.config.DBConfig;
import com.example.quizconnectionpool.dao.AccountDao;
import com.example.quizconnectionpool.model.Account;
import com.example.quizconnectionpool.model.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private DBConfig config;
    private static final Logger logger = LogManager.getLogger(AccountDaoImpl.class);
    @Override
    public Account validateLogin(String username, String password) {
        Account account = null;
        try {
            String sql = "SELECT acct_id, username, password, email, phone, birthday, firstname, " +
                    "lastname, isAdmin, status FROM account WHERE account.username = ? AND account.password = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                account = new Account();
                account.setAccountId(resultSet.getInt("acct_id"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));
                account.setEmail(resultSet.getString("email"));
                account.setPhone(resultSet.getString("phone"));
                account.setBirthday(resultSet.getTimestamp("birthday"));
                account.setFirstname(resultSet.getString("firstname"));
                account.setLastname(resultSet.getString("lastname"));
                account.setIsAdmin(resultSet.getBoolean("isAdmin"));
                account.setStatus(resultSet.getBoolean("status"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public int register(String email, String username, String password) {
        int executedRow = 0;
        if(validateAccountExisted(email, username).isEmpty()) {
            try {
                String sql = "INSERT INTO account(email, username, password) VALUES (?,?,?)";
                PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, password);
                executedRow = preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return executedRow;
    }

    private List<Account> validateAccountExisted(String email, String username) {
        List<Account> accounts = null;
        try {
            accounts = new ArrayList<>();
            String sql = "SELECT acct_id, username, password, email, phone, birthday, firstname, " +
                    "lastname, isAdmin, status FROM account WHERE account.username = ? OR account.email = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Account account = new Account();
                account.setAccountId(resultSet.getInt("acct_id"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));
                account.setEmail(resultSet.getString("email"));
                account.setPhone(resultSet.getString("phone"));
                account.setBirthday(resultSet.getTimestamp("birthday"));
                account.setFirstname(resultSet.getString("firstname"));
                account.setLastname(resultSet.getString("lastname"));
                account.setIsAdmin(resultSet.getBoolean("isAdmin"));
                account.setStatus(resultSet.getBoolean("status"));
                accounts.add(account);
                resultSet.close();
                preparedStatement.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public List<Account> getAllUsers() {
        List<Account> accounts = null;
        try {
            accounts = new ArrayList<>();
            String sql = "SELECT acct_id, username, password, email, phone, birthday, firstname, lastname, isAdmin, status FROM account";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Account account = new Account();
                account.setAccountId(resultSet.getInt("acct_id"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));
                account.setEmail(resultSet.getString("email"));
                account.setPhone(resultSet.getString("phone"));
                account.setBirthday(resultSet.getTimestamp("birthday"));
                account.setFirstname(resultSet.getString("firstname"));
                account.setLastname(resultSet.getString("lastname"));
                account.setIsAdmin(resultSet.getBoolean("isAdmin"));
                account.setStatus(resultSet.getBoolean("status"));
                accounts.add(account);
                resultSet.close();
                preparedStatement.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public List<Account> findUserByUsername(String username) {
        List<Account> accounts = null;
        try {
            accounts = new ArrayList<>();
            String sql = "SELECT acct_id, username, password, email, phone, birthday, firstname, " +
                    "lastname, isAdmin, status FROM account WHERE account.username LIKE %?%";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Account account = new Account();
                account.setAccountId(resultSet.getInt("acct_id"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));
                account.setEmail(resultSet.getString("email"));
                account.setPhone(resultSet.getString("phone"));
                account.setBirthday(resultSet.getTimestamp("birthday"));
                account.setFirstname(resultSet.getString("firstname"));
                account.setLastname(resultSet.getString("lastname"));
                account.setIsAdmin(resultSet.getBoolean("isAdmin"));
                account.setStatus(resultSet.getBoolean("status"));
                accounts.add(account);
                resultSet.close();
                preparedStatement.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public int suspendUser(int id) {
        int executedRow = 0;
        try {
            String sql = "UPDATE account SET account.status = !account.status WHERE account.acct_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            executedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executedRow;
    }

    @Override
    public int activateUser(int id) {
        int executedRow = 0;
        try {
            String sql = "UPDATE account SET account.isAdmin = !account.isAdmin WHERE account.acct_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            executedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executedRow;
    }
}
