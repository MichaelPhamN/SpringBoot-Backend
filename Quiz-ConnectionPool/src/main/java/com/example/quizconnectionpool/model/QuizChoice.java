package com.example.quizconnectionpool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizChoice {
    private Integer quizChoiceId;
    private Integer quizId;
    private Integer questionId;
    private String userSection;
}
