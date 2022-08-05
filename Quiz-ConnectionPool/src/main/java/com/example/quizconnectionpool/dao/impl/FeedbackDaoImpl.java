package com.example.quizconnectionpool.dao.impl;

import com.example.quizconnectionpool.config.DBConfig;
import com.example.quizconnectionpool.dao.FeedbackDao;
import com.example.quizconnectionpool.model.Account;
import com.example.quizconnectionpool.model.Category;
import com.example.quizconnectionpool.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {
    @Autowired
    private DBConfig config;
    @Override
    public int createFeedback(Feedback feedback) {
        int executedRow = 0;
        try {
            String sql = "INSERT INTO feedback(a_id, stars, comment, commitTime) VALUES (?,?,?,now())";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, feedback.getAccount().getAccountId());
            preparedStatement.setInt(2, feedback.getFeedbackStars());
            preparedStatement.setString(3, feedback.getFeedbackComment());
            executedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executedRow;
    }

    @Override
    public int updateFeedback(Feedback feedback) {
        int executedRow = 0;
        try {
            String sql = "UPDATE feedback SET feedback.a_id = ?, feedback.stars = ?, feedback.comment = ? WHERE feedback.feedback_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, feedback.getAccount().getAccountId());
            preparedStatement.setInt(2, feedback.getFeedbackStars());
            preparedStatement.setString(3, feedback.getFeedbackComment());
            preparedStatement.setInt(4, feedback.getFeedbackId());
            executedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executedRow;
    }

    @Override
    public Feedback findFeedbackByAccountId(int account_id) {
        Feedback feedback = null;
        try {
            String sql = "SELECT feedback.feedback_id as f_id, feedback.a_id as f_aId, feedback.stars as f_stars, " +
                    "feedback.comment as f_comment, feedback.commitTime as f_commitTime, account.acct_id as a_id, " +
                    "account.username as a_username, account.email as a_email, account.phone as a_phone, " +
                    "account.firstname as a_firstname, account.lastname as a_lastname" +
                    "FROM feedback JOIN account ON feedback.a_id = account.acct_id WHERE feedback.a_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, account_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                feedback = new Feedback();
                feedback.setFeedbackId(resultSet.getInt("f_id"));
                feedback.setFeedbackStars(resultSet.getInt("f_stars"));
                feedback.setFeedbackComment(resultSet.getString("f_comment"));
                feedback.setFeedbackTimestamp(resultSet.getTimestamp("f_commitTime"));
                Account account = new Account();
                account.setAccountId(resultSet.getInt("a_id"));
                account.setUsername(resultSet.getString("a_username"));
                account.setEmail(resultSet.getString("a_email"));
                account.setPhone(resultSet.getString("a_phone"));
                account.setFirstname(resultSet.getString("a_firstname"));
                account.setLastname(resultSet.getString("a_lastname"));
                feedback.setAccount(account);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedback;
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        List<Feedback> feedbacks = new ArrayList<>();
        try {
            String sql = "SELECT feedback.feedback_id as f_id, feedback.a_id as f_aId, feedback.stars as f_stars, " +
                    "feedback.comment as f_comment, feedback.commitTime as f_commitTime, account.acct_id as a_id, " +
                    "account.username as a_username, account.email as a_email, account.phone as a_phone, " +
                    "account.firstname as a_firstname, account.lastname as a_lastname" +
                    "FROM feedback JOIN account ON feedback.a_id = account.acct_id";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Feedback feedback = new Feedback();
                feedback.setFeedbackId(resultSet.getInt("f_id"));
                feedback.setFeedbackStars(resultSet.getInt("f_stars"));
                feedback.setFeedbackComment(resultSet.getString("f_comment"));
                feedback.setFeedbackTimestamp(resultSet.getTimestamp("f_commitTime"));
                Account account = new Account();
                account.setAccountId(resultSet.getInt("a_id"));
                account.setUsername(resultSet.getString("a_username"));
                account.setEmail(resultSet.getString("a_email"));
                account.setPhone(resultSet.getString("a_phone"));
                account.setFirstname(resultSet.getString("a_firstname"));
                account.setLastname(resultSet.getString("a_lastname"));
                feedback.setAccount(account);
                feedbacks.add(feedback);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return feedbacks;
    }

    @Override
    public double getAvgRate() {
        double avgScore = 0;
        try {
            String sql = "SELECT AVG(stars) as avgScore FROM feedback";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                avgScore = resultSet.getDouble("avgScore");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avgScore;
    }

    @Override
    public int countRate(int rate) {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) as countRate FROM feedback WHERE feedback.stars = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, rate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("countRate");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
