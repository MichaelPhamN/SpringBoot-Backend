package com.example.quizconnectionpool.service;

import com.example.quizconnectionpool.model.Question;

import java.util.List;

public interface QuestionService {
    Integer createQuestion(Question question);
    Question updateQuestion(Question question);
    List<Question> getAllQuestions();
    List<Question> getQuestionsByCategory(String category);
    Question findQuestion(Integer id);
}
