package com.example.quizconnectionpool.dao;

import com.example.quizconnectionpool.model.Message;
import com.example.quizconnectionpool.model.Account;

import java.util.List;

public interface MessageDao {
    int createMessage(Message message);
    List<Message> getAllMessages();
    Message findMessageById(int id);
    int updateMessage(int id);
}
