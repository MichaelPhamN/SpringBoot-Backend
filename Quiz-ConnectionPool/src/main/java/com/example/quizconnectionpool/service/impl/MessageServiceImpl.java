package com.example.quizconnectionpool.service.impl;

import com.example.quizconnectionpool.dao.impl.MessageDaoImpl;
import com.example.quizconnectionpool.model.Account;
import com.example.quizconnectionpool.model.Message;
import com.example.quizconnectionpool.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDaoImpl messageDao;
    @Override
    public int createMessage(Message message) {
        return messageDao.createMessage(message);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageDao.getAllMessages();
    }

    @Override
    public Message findMessageById(Integer id) {
        return messageDao.findMessageById(id);
    }

    @Override
    public int updateMessage(int id) {
        return messageDao.updateMessage(id);
    }
}
