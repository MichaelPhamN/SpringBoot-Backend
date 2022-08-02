package com.example.quizconnectionpool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    private Integer quizId;
    private String quizName;
    private String quizCategoryId;
    private Integer quizAccountId;
    private Date quizStartTime;
    private Date quizEndTime;
    private Double score;
}
