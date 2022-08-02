package com.example.quizconnectionpool.service;

import com.example.quizconnectionpool.model.Account;
import com.example.quizconnectionpool.model.Message;

import java.util.List;

public interface MessageService {
    Integer createMessage(Account account, String title, String content);
    List<Message> getAllMessages();
    Message findMessageById(Integer id);
    Message updateMessage(Integer id, Boolean unread);
}
