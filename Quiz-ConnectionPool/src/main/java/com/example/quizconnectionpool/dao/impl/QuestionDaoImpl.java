package com.example.quizconnectionpool.dao.impl;

import com.example.quizconnectionpool.config.DBConfig;
import com.example.quizconnectionpool.dao.QuestionDao;
import com.example.quizconnectionpool.model.Category;
import com.example.quizconnectionpool.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {
    @Autowired
    private DBConfig config;
    @Override
    public int createQuestion(Question question) {
        int executedRow = 0;
        try {
            String sql = "INSERT INTO question(description, cat_id, choice_a, choice_b, choice_c, choice_d, answer) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, question.getQuestionDescription());
            preparedStatement.setInt(2, question.getCategory().getCatId());
            preparedStatement.setString(3, question.getQuestionChoiceA());
            preparedStatement.setString(4, question.getQuestionChoiceB());
            preparedStatement.setString(5, question.getQuestionChoiceC());
            preparedStatement.setString(6, question.getQuestionChoiceD());
            preparedStatement.setString(7, question.getQuestionAnswer());
            executedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executedRow;
    }

    @Override
    public int updateQuestion(Question question) {
        int executedRow = 0;
        try {
            String sql = "UPDATE question SET question.description = ?, question.cat_id = ?, question.choice_a = ?" +
                    ", question.choice_b = ?, question.choice_c = ?, question.choice_d = ?, question.answer = ? WHERE question.question_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, question.getQuestionDescription());
            preparedStatement.setInt(2, question.getCategory().getCatId());
            preparedStatement.setString(3, question.getQuestionChoiceA());
            preparedStatement.setString(4, question.getQuestionChoiceB());
            preparedStatement.setString(5, question.getQuestionChoiceC());
            preparedStatement.setString(6, question.getQuestionChoiceD());
            preparedStatement.setString(7, question.getQuestionAnswer());
            preparedStatement.setInt(8, question.getQuestionId());
            executedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executedRow;
    }

    @Override
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        try {
            String sql = "SELECT question.question_id as q_id, question.cat_id as q_catId, question.description as q_description, " +
                    "question.choice_a as q_ChoiceA, question.choice_b as q_ChoiceB, question.choice_c as q_ChoiceC, " +
                    "question.choice_d as q_ChoiceD, question.answer as q_Answer, category.cat_id as c_catId, " +
                    "category.category_name as c_catName FROM question JOIN category ON question.cat_id = category.cat_id";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Question question = new Question();
                question.setQuestionId(resultSet.getInt("q_id"));
                question.setQuestionDescription(resultSet.getString("q_description"));
                question.setQuestionChoiceA(resultSet.getString("q_ChoiceA"));
                question.setQuestionChoiceB(resultSet.getString("q_ChoiceB"));
                question.setQuestionChoiceC(resultSet.getString("q_ChoiceC"));
                question.setQuestionChoiceD(resultSet.getString("q_ChoiceD"));
                question.setQuestionAnswer(resultSet.getString("q_Answer"));
                Category category = new Category();
                category.setCatId(resultSet.getInt("c_catId"));
                category.setCatName(resultSet.getString("c_catName"));
                question.setCategory(category);
                questions.add(question);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return questions;
    }

    @Override
    public List<Question> getQuestionsByCategory(String catName) {
        List<Question> questions = new ArrayList<>();
        try {
            String sql = "SELECT question.question_id as q_id, question.cat_id as q_catId, question.description as q_description, " +
                    "question.choice_a as q_ChoiceA, question.choice_b as q_ChoiceB, question.choice_c as q_ChoiceC, " +
                    "question.choice_d as q_ChoiceD, question.answer as q_Answer, category.cat_id as c_catId, " +
                    "category.category_name as c_catName FROM question JOIN category ON question.cat_id = category.cat_id " +
                    "WHERE category.category_name LIKE %?%";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, catName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Question question = new Question();
                question.setQuestionId(resultSet.getInt("q_id"));
                question.setQuestionDescription(resultSet.getString("q_description"));
                question.setQuestionChoiceA(resultSet.getString("q_ChoiceA"));
                question.setQuestionChoiceB(resultSet.getString("q_ChoiceB"));
                question.setQuestionChoiceC(resultSet.getString("q_ChoiceC"));
                question.setQuestionChoiceD(resultSet.getString("q_ChoiceD"));
                question.setQuestionAnswer(resultSet.getString("q_Answer"));
                Category category = new Category();
                category.setCatId(resultSet.getInt("c_catId"));
                category.setCatName(resultSet.getString("c_catName"));
                question.setCategory(category);
                questions.add(question);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return questions;
    }

    @Override
    public Question findQuestionById(int id) {
        Question question = null;
        try {
            String sql = "SELECT question.question_id as q_id, question.cat_id as q_catId, question.description as q_description, " +
                    "question.choice_a as q_ChoiceA, question.choice_b as q_ChoiceB, question.choice_c as q_ChoiceC, " +
                    "question.choice_d as q_ChoiceD, question.answer as q_Answer, category.cat_id as c_catId, " +
                    "category.category_name as c_catName FROM question JOIN category ON question.cat_id = category.cat_id " +
                    "WHERE question.question_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                question = new Question();
                question.setQuestionId(resultSet.getInt("q_id"));
                question.setQuestionDescription(resultSet.getString("q_description"));
                question.setQuestionChoiceA(resultSet.getString("q_ChoiceA"));
                question.setQuestionChoiceB(resultSet.getString("q_ChoiceB"));
                question.setQuestionChoiceC(resultSet.getString("q_ChoiceC"));
                question.setQuestionChoiceD(resultSet.getString("q_ChoiceD"));
                question.setQuestionAnswer(resultSet.getString("q_Answer"));
                Category category = new Category();
                category.setCatId(resultSet.getInt("c_catId"));
                category.setCatName(resultSet.getString("c_catName"));
                question.setCategory(category);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return question;
    }
}
