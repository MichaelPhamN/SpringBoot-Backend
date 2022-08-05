package com.example.quizconnectionpool.dao.impl;

import com.example.quizconnectionpool.config.DBConfig;
import com.example.quizconnectionpool.dao.MessageDao;
import com.example.quizconnectionpool.model.Account;
import com.example.quizconnectionpool.model.Feedback;
import com.example.quizconnectionpool.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageDaoImpl implements MessageDao {
    @Autowired
    private DBConfig config;
    @Override
    public int createMessage(Message message) {
        int executedRow = 0;
        try {
            String sql = "INSERT INTO message(acct_id, title, content, sent) VALUES (?,?,?,now())";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, message.getAccount().getAccountId());
            preparedStatement.setString(2, message.getTitle());
            preparedStatement.setString(3, message.getContent());
            executedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executedRow;
    }

    @Override
    public List<Message> getAllMessages() {
        List<Message> messages = new ArrayList<>();
        try {
            String sql = "SELECT message.id as m_id, message.acct_id as m_aId, message.title as m_title, " +
                    "message.content as m_content, message.sent as m_sent, message.unread as m_unread, " +
                    "account.acct_id as a_id, account.username as a_username, account.email as a_email, " +
                    "account.phone as a_email, account.firstname as a_firstname, account.lastname as a_lastname" +
                    "FROM message JOIN account ON message.acct_id = account.acct_id";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Message message = new Message();
                message.setMessageId(resultSet.getInt("m_id"));
                message.setTitle(resultSet.getString("m_title"));
                message.setContent(resultSet.getString("m_content"));
                message.setSent(resultSet.getDate("m_sent"));
                message.setUnread(resultSet.getBoolean("m_unread"));
                Account account = new Account();
                account.setAccountId(resultSet.getInt("a_id"));
                account.setUsername(resultSet.getString("a_username"));
                account.setEmail(resultSet.getString("a_email"));
                account.setPhone(resultSet.getString("a_email"));
                account.setFirstname(resultSet.getString("a_firstname"));
                account.setLastname(resultSet.getString("a_lastname"));
                message.setAccount(account);
                messages.add(message);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return messages;
    }

    @Override
    public Message findMessageById(int id) {
        Message message = null;
        try {
            String sql = "SELECT message.id as m_id, message.acct_id as m_aId, message.title as m_title, " +
                    "message.content as m_content, message.sent as m_sent, message.unread as m_unread, " +
                    "account.acct_id as a_id, account.username as a_username, account.email as a_email, " +
                    "account.phone as a_email, account.firstname as a_firstname, account.lastname as a_lastname" +
                    "FROM message JOIN account ON message.acct_id = account.acct_id WHERE message.id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                message = new Message();
                message.setMessageId(resultSet.getInt("m_id"));
                message.setTitle(resultSet.getString("m_title"));
                message.setContent(resultSet.getString("m_content"));
                message.setSent(resultSet.getDate("m_sent"));
                message.setUnread(resultSet.getBoolean("m_unread"));
                Account account = new Account();
                account.setAccountId(resultSet.getInt("a_id"));
                account.setUsername(resultSet.getString("a_username"));
                account.setEmail(resultSet.getString("a_email"));
                account.setPhone(resultSet.getString("a_email"));
                account.setFirstname(resultSet.getString("a_firstname"));
                account.setLastname(resultSet.getString("a_lastname"));
                message.setAccount(account);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public int updateMessage(int id) {
        int executedRow = 0;
        try {
            String sql = "UPDATE message SET message.unread = !message.unread WHERE message.id = ?";
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
