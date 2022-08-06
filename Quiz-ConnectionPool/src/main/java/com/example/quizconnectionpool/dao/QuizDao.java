package com.example.quizconnectionpool.dao;

import com.example.quizconnectionpool.model.Category;
import com.example.quizconnectionpool.model.Quiz;
import com.example.quizconnectionpool.model.Account;

import java.util.Date;
import java.util.List;

public interface QuizDao {
    List<Quiz> findQuizzes(int acct_id, int cat_id);
    List<Quiz> findQuizzes(int acct_id);
    Quiz findQuizById(int id);
    List<Quiz> getAllQuizzes();
    int createQuiz(Quiz quiz);
    int updateQuiz(int quizId, String quizName, int catId);
    int updateQuiz(int quizId, double score);
    int countQuizzes(int accountId, int catId);
}
