package com.example.quizconnectionpool.service.impl;

import com.example.quizconnectionpool.model.Question;
import com.example.quizconnectionpool.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Override
    public Integer createQuestion(Question question) {
        return null;
    }

    @Override
    public Question updateQuestion(Question question) {
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
    public Question findQuestion(Integer id) {
        return null;
    }
}
