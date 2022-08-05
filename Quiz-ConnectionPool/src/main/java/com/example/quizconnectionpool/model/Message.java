package com.example.quizconnectionpool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
    private Integer messageId;
    private Account account;
    private String title;
    private String content;
    private Date sent;
    private Boolean unread;
}
