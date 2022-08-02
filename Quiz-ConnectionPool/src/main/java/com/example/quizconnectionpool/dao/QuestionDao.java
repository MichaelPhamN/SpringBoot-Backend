package com.example.quizconnectionpool.dao;

import com.example.quizconnectionpool.model.Question;

import java.util.List;

public interface QuestionDao {
    Integer createQuestion(String category, String description, String choiceA, String choiceB, String choiceC, String choiceD, String answer);
    Question editQuestion(Integer id, String category, String description, String choiceA, String choiceB, String choiceC, String choiceD, String answer);
    List<Question> getAllQuestions();
    List<Question> getQuestionsByCategory(String category);
    List<Question> findQuestions(Integer quizId);
    Question findQuestion(Integer id);
}
