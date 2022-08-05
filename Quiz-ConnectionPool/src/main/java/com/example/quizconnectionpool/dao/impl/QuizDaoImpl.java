package com.example.quizconnectionpool.dao.impl;

import com.example.quizconnectionpool.config.DBConfig;
import com.example.quizconnectionpool.dao.QuizDao;
import com.example.quizconnectionpool.model.Account;
import com.example.quizconnectionpool.model.Category;
import com.example.quizconnectionpool.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class QuizDaoImpl implements QuizDao {
    @Autowired
    private DBConfig config;
    @Override
    public int createQuiz(Quiz quiz) {
        int executedRow = 0;
        try {
            String sql = "INSERT INTO quiz(quiz_name, starttime, endtime, score, acct_id, cat_id) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, quiz.getQuizName());
            preparedStatement.setDate(2, quiz.getQuizStartTime());
            preparedStatement.setDate(3, quiz.getQuizEndTime());
            preparedStatement.setDouble(4, quiz.getScore());
            preparedStatement.setInt(5, quiz.getAccount().getAccountId());
            preparedStatement.setInt(6, quiz.getCategory().getCatId());
            executedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executedRow;
    }

    @Override
    public List<Quiz> findQuiz(int acct_id, int cat_id) {
        List<Quiz> quizzes = null;
        try {
            String sql = "SELECT quiz.quiz_id as q_id, quiz.quiz_name as q_name, quiz.starttime as q_starttime, " +
                    "quiz.endtime as q_endtime, quiz.score as q_score, category.cat_id as c_id, category.category_name as c_name " +
                    "account.acct_id as a_id, account.username as a_username, account.firstname as a_firstname, account.lastname as a_lastname " +
                    "FROM quiz " +
                    "JOIN category " +
                    "   ON quiz.cat_id = category.cat_id " +
                    "JOIN account " +
                    "   ON quiz.cat_id = account.cat_id " +
                    "WHERE account.acct_id = ? AND category.cat_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, acct_id);
            preparedStatement.setInt(2, cat_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Quiz quiz = new Quiz();
                Account acct = new Account();
                acct.setAccountId(resultSet.getInt("a_id"));
                acct.setFirstname(resultSet.getString("a_username"));
                acct.setFirstname(resultSet.getString("a_firstname"));
                acct.setLastname(resultSet.getString("a_lastname"));
                Category cat = new Category();
                cat.setCatId(resultSet.getInt("c_id"));
                cat.setCatName(resultSet.getString("c_name"));
                quiz.setAccount(acct);
                quiz.setCategory(cat);
                quiz.setQuizId(resultSet.getInt("q_id"));
                quiz.setQuizName(resultSet.getString("q_name"));
                quiz.setQuizStartTime(resultSet.getDate("q_starttime"));
                quiz.setQuizEndTime(resultSet.getDate("q_endtime"));
                quiz.setScore(resultSet.getDouble("q_score"));
                quizzes.add(quiz);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzes;
    }

    @Override
    public List<Quiz> findQuiz(int acct_id) {
        List<Quiz> quizzes = null;
        try {
            String sql = "SELECT quiz.quiz_id as q_id, quiz.quiz_name as q_name, quiz.starttime as q_starttime, " +
                    "quiz.endtime as q_endtime, quiz.score as q_score, category.cat_id as c_id, category.category_name as c_name " +
                    "account.acct_id as a_id, account.username as a_username, account.firstname as a_firstname, account.lastname as a_lastname " +
                    "FROM quiz " +
                    "JOIN category " +
                    "   ON quiz.cat_id = category.cat_id " +
                    "JOIN account " +
                    "   ON quiz.cat_id = account.cat_id " +
                    "WHERE account.acct_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, acct_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Quiz quiz = new Quiz();
                Account acct = new Account();
                acct.setAccountId(resultSet.getInt("a_id"));
                acct.setFirstname(resultSet.getString("a_username"));
                acct.setFirstname(resultSet.getString("a_firstname"));
                acct.setLastname(resultSet.getString("a_lastname"));
                Category cat = new Category();
                cat.setCatId(resultSet.getInt("c_id"));
                cat.setCatName(resultSet.getString("c_name"));
                quiz.setAccount(acct);
                quiz.setCategory(cat);
                quiz.setQuizId(resultSet.getInt("q_id"));
                quiz.setQuizName(resultSet.getString("q_name"));
                quiz.setQuizStartTime(resultSet.getDate("q_starttime"));
                quiz.setQuizEndTime(resultSet.getDate("q_endtime"));
                quiz.setScore(resultSet.getDouble("q_score"));
                quizzes.add(quiz);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzes;
    }

    @Override
    public Quiz findQuizById(int id) {
        Quiz quiz = null;
        try {
            String sql = "SELECT quiz.quiz_id as q_id, quiz.quiz_name as q_name, quiz.starttime as q_starttime, " +
                    "quiz.endtime as q_endtime, quiz.score as q_score, category.cat_id as c_id, category.category_name as c_name " +
                    "account.acct_id as a_id, account.username as a_username, account.firstname as a_firstname, account.lastname as a_lastname " +
                    "FROM quiz " +
                    "JOIN category " +
                    "   ON quiz.cat_id = category.cat_id " +
                    "JOIN account " +
                    "   ON quiz.cat_id = account.cat_id " +
                    "WHERE quiz.quiz_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                quiz = new Quiz();
                Account acct = new Account();
                acct.setAccountId(resultSet.getInt("a_id"));
                acct.setFirstname(resultSet.getString("a_username"));
                acct.setFirstname(resultSet.getString("a_firstname"));
                acct.setLastname(resultSet.getString("a_lastname"));
                Category cat = new Category();
                cat.setCatId(resultSet.getInt("c_id"));
                cat.setCatName(resultSet.getString("c_name"));
                quiz.setAccount(acct);
                quiz.setCategory(cat);
                quiz.setQuizId(resultSet.getInt("q_id"));
                quiz.setQuizName(resultSet.getString("q_name"));
                quiz.setQuizStartTime(resultSet.getDate("q_starttime"));
                quiz.setQuizEndTime(resultSet.getDate("q_endtime"));
                quiz.setScore(resultSet.getDouble("q_score"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quiz;
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        List<Quiz> quizzes = null;
        try {
            String sql = "SELECT quiz.quiz_id as q_id, quiz.quiz_name as q_name, quiz.starttime as q_starttime, " +
                    "quiz.endtime as q_endtime, quiz.score as q_score, category.cat_id as c_id, category.category_name as c_name " +
                    "account.acct_id as a_id, account.username as a_username, account.firstname as a_firstname, account.lastname as a_lastname " +
                    "FROM quiz " +
                    "JOIN category " +
                    "   ON quiz.cat_id = category.cat_id " +
                    "JOIN account " +
                    "   ON quiz.cat_id = account.cat_id ";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Quiz quiz = new Quiz();
                Account acct = new Account();
                acct.setAccountId(resultSet.getInt("a_id"));
                acct.setFirstname(resultSet.getString("a_username"));
                acct.setFirstname(resultSet.getString("a_firstname"));
                acct.setLastname(resultSet.getString("a_lastname"));
                Category cat = new Category();
                cat.setCatId(resultSet.getInt("c_id"));
                cat.setCatName(resultSet.getString("c_name"));
                quiz.setAccount(acct);
                quiz.setCategory(cat);
                quiz.setQuizId(resultSet.getInt("q_id"));
                quiz.setQuizName(resultSet.getString("q_name"));
                quiz.setQuizStartTime(resultSet.getDate("q_starttime"));
                quiz.setQuizEndTime(resultSet.getDate("q_endtime"));
                quiz.setScore(resultSet.getDouble("q_score"));
                quizzes.add(quiz);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzes;
    }

    @Override
    public int updateQuiz(int quizId, String quizName, int catId) {
        int executedRow = 0;
        try {
            String sql = "UPDATE quiz SET quiz.quiz_name = ?, quiz.cat_id = ? WHERE quiz.quiz_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, quizName);
            preparedStatement.setInt(2, catId);
            preparedStatement.setInt(3, quizId);
            executedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executedRow;
    }

    @Override
    public int updateQuiz(int quizId, double score) {
        int executedRow = 0;
        try {
            String sql = "UPDATE quiz SET quiz.score = ? WHERE quiz.quiz_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setDouble(1, score);
            preparedStatement.setInt(2, quizId);
            executedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executedRow;
    }

    @Override
    public int countQuiz(int acct_id, String cat_name) {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) " +
                            "FROM quiz " +
                            "JOIN category " +
                            "   ON quiz.cat_id = category.cat_id " +
                            "JOIN account " +
                            "   ON quiz.cat_id = account.cat_id " +
                            "WHERE account.acct_id = ? AND category.category_name LIKE %?%";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, acct_id);
            preparedStatement.setString(2, cat_name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
