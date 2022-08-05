package com.example.quizconnectionpool.dao;

import com.example.quizconnectionpool.model.QuizChoice;

import java.util.List;

public interface QuizChoiceDao {
    List<QuizChoice> findQuizChoiceByQuizId(int quizId);
    List<QuizChoice> findQuizChoiceByQuestionId(int questionId);
}
