package com.example.quizconnectionpool.dao.impl;

import com.example.quizconnectionpool.dao.MessageDao;
import com.example.quizconnectionpool.model.Account;
import com.example.quizconnectionpool.model.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDaoImpl implements MessageDao {
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
