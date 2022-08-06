package com.example.quizconnectionpool.dao;

import com.example.quizconnectionpool.model.Question;

import java.util.List;

public interface QuestionDao {
    int createQuestion(Question question);
    int updateQuestion(Question question);
    List<Question> getAllQuestions();
    List<Question> getQuestionsByCategory(String catName);
    Question findQuestionById(int id);
}
