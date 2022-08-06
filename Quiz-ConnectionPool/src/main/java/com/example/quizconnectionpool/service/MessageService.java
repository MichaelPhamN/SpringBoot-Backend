package com.example.quizconnectionpool.service;

import com.example.quizconnectionpool.model.Account;
import com.example.quizconnectionpool.model.Message;

import java.util.List;

public interface MessageService {
    int createMessage(Message message);
    List<Message> getAllMessages();
    Message findMessageById(Integer id);
    int updateMessage(int id);
}
