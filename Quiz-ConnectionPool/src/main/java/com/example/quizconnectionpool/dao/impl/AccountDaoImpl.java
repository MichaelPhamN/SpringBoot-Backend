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
import java.util.List;

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
    public Account register(String email, String username, String password) {
        return null;
    }

    @Override
    public List<Account> getAllUsers() {
        return null;
    }

    @Override
    public Account findUserByUsername(String username) {
        return null;
    }

    @Override
    public Account suspendUser(Integer id) {
        return null;
    }

    @Override
    public Account activateUser(Integer id) {
        return null;
    }
}
