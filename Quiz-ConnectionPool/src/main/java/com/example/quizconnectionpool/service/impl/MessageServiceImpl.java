package com.example.quizconnectionpool.service.impl;

import com.example.quizconnectionpool.model.Account;
import com.example.quizconnectionpool.model.Message;
import com.example.quizconnectionpool.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public Integer createMessage(Account account, String title, String content) {
        return null;
    }

    @Override
    public List<Message> getAllMessages() {
        return null;
    }

    @Override
    public Message findMessageById(Integer id) {
        return null;
    }

    @Override
    public Message updateMessage(Integer id, Boolean unread) {
        return null;
    }
}
