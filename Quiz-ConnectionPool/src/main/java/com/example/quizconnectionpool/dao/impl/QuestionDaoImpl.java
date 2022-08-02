package com.example.quizconnectionpool.dao.impl;

import com.example.quizconnectionpool.dao.QuestionDao;
import com.example.quizconnectionpool.model.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {
    @Override
    public Integer createQuestion(String category, String description, String choiceA, String choiceB, String choiceC, String choiceD, String answer) {
        return null;
    }

    @Override
    public Question editQuestion(Integer id, String category, String description, String choiceA, String choiceB, String choiceC, String choiceD, String answer) {
        return null;
    }

    @Override
    public List<Question> getAllQuestions() {
        return null;
    }

    @Override
    public List<Question> getQuestionsByCategory(String category) {
        return null;
    }

    @Override
    public List<Question> findQuestions(Integer quizId) {
        return null;
    }

    @Override
    public Question findQuestion(Integer id) {
        return null;
    }
}
