package com.example.quizconnectionpool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    private Integer feedbackId;
    private Account account;
    private Integer feedbackStars;
    private String feedbackComment;
    private Timestamp feedbackTimestamp;
}
