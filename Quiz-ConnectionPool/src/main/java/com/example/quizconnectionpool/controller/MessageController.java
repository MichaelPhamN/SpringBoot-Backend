package com.example.quizconnectionpool.controller;

import com.example.quizconnectionpool.model.Message;
import com.example.quizconnectionpool.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    MessageServiceImpl messageService;

    @GetMapping("")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.getAllMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> findMessageById(@PathVariable int id) {
        Message message = messageService.findMessageById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/create")
    public int createMessage(@RequestBody Message message) {
        int executedRow = messageService.createMessage(message);
        return executedRow;
    }

    @PutMapping("/update")
    public int updateMessage(@PathVariable int id) {
        int executedRow = messageService.updateMessage(id);
        return executedRow;
    }
}
