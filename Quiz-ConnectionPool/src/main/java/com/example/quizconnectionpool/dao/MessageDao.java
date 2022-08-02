package com.example.quizconnectionpool.dao;

import com.example.quizconnectionpool.model.Message;
import com.example.quizconnectionpool.model.Account;

import java.util.List;

public interface MessageDao {
    Integer createMessage(Account account, String title, String content);
    List<Message> getAllMessages();
    Message findMessageById(Integer id);
    Message updateMessage(Integer id, Boolean unread);
}
