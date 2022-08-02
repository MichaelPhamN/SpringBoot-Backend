package com.example.quizconnectionpool.dao;

import com.example.quizconnectionpool.model.Quiz;
import com.example.quizconnectionpool.model.Account;

import java.util.Date;
import java.util.List;

public interface QuizDao {
    Integer createQuiz(Integer userId, String name, String category, Date startTime);
    Quiz findLastQuiz(Integer userId, String category);
    List<Quiz> findQuiz(Account user, String category);
    List<Quiz> findQuiz(Integer userId);
    Quiz findQuizById(Integer id);
    List<Quiz> getAllQuizzes();
    Integer createQuizQuestion(Integer quizId, Integer choiceQuestionId);
    Integer updateQuizQuestion(Integer quizId, Integer choiceQuestionId, String answer);
    Integer updateQuiz(Integer quizId, Date finishTime);
    Integer updateQuiz(Integer quizId, Integer score);
    Integer countQuiz(Integer userId, String category);
}