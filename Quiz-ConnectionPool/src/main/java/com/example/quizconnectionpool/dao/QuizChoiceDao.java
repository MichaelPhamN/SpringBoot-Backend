package com.example.quizconnectionpool.dao;

import com.example.quizconnectionpool.model.QuizChoice;

import java.util.List;

public interface QuizChoiceDao {
    List<QuizChoice> findQuizChoiceByQuizId(Integer quizId);
    List<QuizChoice> findQuizChoiceByQuestionId(Integer questionId);
}
