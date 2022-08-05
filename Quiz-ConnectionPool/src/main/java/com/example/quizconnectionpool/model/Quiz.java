package com.example.quizconnectionpool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    private Integer quizId;
    private String quizName;
    private Category category;
    private Account account;
    private Date quizStartTime;
    private Date quizEndTime;
    private Double score;
}
