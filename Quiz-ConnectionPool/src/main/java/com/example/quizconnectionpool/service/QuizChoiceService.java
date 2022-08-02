package com.example.quizconnectionpool.service;

import com.example.quizconnectionpool.model.QuizChoice;

import java.util.List;

public interface QuizChoiceService {
    List<QuizChoice> findQuizChoiceByQuizId(Integer quizId);
    List<QuizChoice> findQuizChoiceByQuestionId(Integer questionId);
}
