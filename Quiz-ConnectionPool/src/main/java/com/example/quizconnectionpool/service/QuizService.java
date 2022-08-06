package com.example.quizconnectionpool.service;

import com.example.quizconnectionpool.model.Account;
import com.example.quizconnectionpool.model.Quiz;

import java.util.Date;
import java.util.List;

public interface QuizService {
    List<Quiz> findQuizzes(int acct_id, int cat_id);
    List<Quiz> findQuizzes(int acct_id);
    Quiz findQuizById(int id);
    List<Quiz> getAllQuizzes();
    int createQuiz(Quiz quiz);
    int updateQuiz(int quizId, String quizName, int catId);
    int updateQuiz(int quizId, double score);
    int countQuizzes(int acct_id, int cat_id);
}
