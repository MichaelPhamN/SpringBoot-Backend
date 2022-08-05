package com.example.quizconnectionpool.dao.impl;

import com.example.quizconnectionpool.config.DBConfig;
import com.example.quizconnectionpool.dao.QuizChoiceDao;
import com.example.quizconnectionpool.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuizChoiceDaoImp implements QuizChoiceDao {
    @Autowired
    private DBConfig config;
    @Override
    public List<QuizChoice> findQuizChoiceByQuizId(int quizId) {
        List<QuizChoice> quizChoices = new ArrayList<>();
        try {
            String sql = "SELECT quiz_question.id as qquest_id, quiz_question.user_selection as qquestion_userSelection, " +
                    "quiz.quiz_id as q_id, quiz.quiz_name as q_name, quiz.starttime as q_starttime, quiz.endtime as q_endtime, quiz.score as q_score, " +
                    "question.question_id as ques_id, question.description as ques_description, question.choice_a as ques_choiceA, question.choice_b as ques_choiceB, " +
                    "question.choice_c as ques_choiceC, question.choice_d as ques_choiceD, question.answer as ques_answer, question.cat_id as quest_catId " +
                    "FROM quiz_question " +
                    "JOIN question " +
                    "   ON quiz_question.question_id = question.question_id " +
                    "JOIN quiz " +
                    "   ON quiz_question.quiz_id = quiz.quiz_id " +
                    "WHERE quiz_question.quiz_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, quizId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                QuizChoice quizChoice = new QuizChoice();
                quizChoice.setQuizChoiceId(resultSet.getInt("qquest_id"));
                quizChoice.setUserSection(resultSet.getString("qquestion_userSelection"));
                Quiz quiz = new Quiz();
                quiz.setQuizId(resultSet.getInt("q_id"));
                quiz.setQuizName(resultSet.getString("q_name"));
                quiz.setQuizStartTime(resultSet.getDate("q_starttime"));
                quiz.setQuizEndTime(resultSet.getDate("q_endtime"));
                quiz.setScore(resultSet.getDouble("q_score"));
                quizChoice.setQuiz(quiz);
                Question question = new Question();
                question.setQuestionId(resultSet.getInt("ques_id"));
                question.setQuestionDescription(resultSet.getString("ques_description"));
                question.setQuestionChoiceA(resultSet.getString("ques_choiceA"));
                question.setQuestionChoiceB(resultSet.getString("ques_choiceB"));
                question.setQuestionChoiceC(resultSet.getString("ques_choiceC"));
                question.setQuestionChoiceD(resultSet.getString("ques_choiceD"));
                question.setQuestionAnswer(resultSet.getString("ques_answer"));
                Category category = new Category();
                category.setCatId(resultSet.getInt("quest_catId"));
                question.setCategory(category);
                quizChoice.setQuestion(question);
                quizChoices.add(quizChoice);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizChoices;
    }

    @Override
    public List<QuizChoice> findQuizChoiceByQuestionId(int questionId) {
        List<QuizChoice> quizChoices = new ArrayList<>();
        try {
            String sql = "SELECT quiz_question.id as qquest_id, quiz_question.user_selection as qquestion_userSelection, " +
                    "quiz.quiz_id as q_id, quiz.quiz_name as q_name, quiz.starttime as q_starttime, quiz.endtime as q_endtime, quiz.score as q_score, " +
                    "question.question_id as ques_id, question.description as ques_description, question.choice_a as ques_choiceA, question.choice_b as ques_choiceB, " +
                    "question.choice_c as ques_choiceC, question.choice_d as ques_choiceD, question.answer as ques_answer, question.cat_id as quest_catId " +
                    "FROM quiz_question " +
                    "JOIN question " +
                    "   ON quiz_question.question_id = question.question_id " +
                    "JOIN quiz " +
                    "   ON quiz_question.quiz_id = quiz.quiz_id " +
                    "WHERE quiz_question.question_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, questionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                QuizChoice quizChoice = new QuizChoice();
                quizChoice.setQuizChoiceId(resultSet.getInt("qquest_id"));
                quizChoice.setUserSection(resultSet.getString("qquestion_userSelection"));
                Quiz quiz = new Quiz();
                quiz.setQuizId(resultSet.getInt("q_id"));
                quiz.setQuizName(resultSet.getString("q_name"));
                quiz.setQuizStartTime(resultSet.getDate("q_starttime"));
                quiz.setQuizEndTime(resultSet.getDate("q_endtime"));
                quiz.setScore(resultSet.getDouble("q_score"));
                quizChoice.setQuiz(quiz);
                Question question = new Question();
                question.setQuestionId(resultSet.getInt("ques_id"));
                question.setQuestionDescription(resultSet.getString("ques_description"));
                question.setQuestionChoiceA(resultSet.getString("ques_choiceA"));
                question.setQuestionChoiceB(resultSet.getString("ques_choiceB"));
                question.setQuestionChoiceC(resultSet.getString("ques_choiceC"));
                question.setQuestionChoiceD(resultSet.getString("ques_choiceD"));
                question.setQuestionAnswer(resultSet.getString("ques_answer"));
                Category category = new Category();
                category.setCatId(resultSet.getInt("quest_catId"));
                question.setCategory(category);
                quizChoice.setQuestion(question);
                quizChoices.add(quizChoice);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizChoices;
    }
}
