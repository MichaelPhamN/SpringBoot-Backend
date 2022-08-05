package com.example.quizconnectionpool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizChoice {
    private Integer quizChoiceId;
    private Quiz quiz;
    private Question question;
    private String userSection;
}
