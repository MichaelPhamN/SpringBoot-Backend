package com.example.quizconnectionpool.service.impl;

import com.example.quizconnectionpool.model.QuizChoice;
import com.example.quizconnectionpool.service.QuizChoiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizChoiceServiceImp implements QuizChoiceService {
    @Override
    public List<QuizChoice> findQuizChoiceByQuizId(Integer quizId) {
        return null;
    }

    @Override
    public List<QuizChoice> findQuizChoiceByQuestionId(Integer questionId) {
        return null;
    }
}
