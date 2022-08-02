CREATE DATABASE IF NOT EXISTS `quiz`;
USE `quiz`;

-- account: who is taking the quiz
CREATE TABLE IF NOT EXISTS `account`(
      `acct_id` INT AUTO_INCREMENT PRIMARY KEY,
      `username` VARCHAR(20),
      `password` VARCHAR(50),
      `email` VARCHAR(100),
      `phone` VARCHAR(20),
      `birthday` TIMESTAMP,
      `firstname` VARCHAR(25),
      `lastname` VARCHAR(25),
      `isAdmin` BOOLEAN DEFAULT FALSE,
      `status` BOOLEAN DEFAULT TRUE
);

-- category: what kind of categories that a question belongs to
CREATE TABLE IF NOT EXISTS `category`(
       `cat_id` INT AUTO_INCREMENT PRIMARY KEY,
       `category_name` VARCHAR(50)
);

-- choices: question content and answers
CREATE TABLE IF NOT EXISTS `question`(
       `question_id` INT AUTO_INCREMENT PRIMARY KEY,
       `description` VARCHAR(255),
       `cat_id` INT,
       `choice_a` VARCHAR(200),
       `choice_b` VARCHAR(200),
       `choice_c` VARCHAR(200),
       `choice_d` VARCHAR(200),
       `answer` VARCHAR(10) CHECK ( answer IN ('A','B','C','D') )
);

-- quiz: quiz information
CREATE TABLE IF NOT EXISTS `quiz`(
       `quiz_id` INT AUTO_INCREMENT PRIMARY KEY,
       `quiz_name` VARCHAR(50),
       `starttime` TIMESTAMP,
       `endtime` TIMESTAMP,
       `score` DOUBLE,
       `acct_id` INT,
       `cat_id` INT
);

-- quiz_question: assign the questions for each quiz
CREATE TABLE IF NOT EXISTS `quiz_question`(
        `id` INT AUTO_INCREMENT PRIMARY KEY,
        `question_id` INT,
        `quiz_id` INT,
        `user_selection` VARCHAR(255)
);

-- feedback: how much you like this app
CREATE TABLE IF NOT EXISTS `feedback`(
       `feedback_id` INT AUTO_INCREMENT PRIMARY KEY,
       `a_id` INT,
       `stars` TINYINT,
       `comment` VARCHAR(500),
       `commitTime` TIMESTAMP
);

-- message: users send messages
CREATE TABLE IF NOT EXISTS `message` (
       id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
       acct_id INT,
       title VARCHAR(100),
       content VARCHAR(500),
       sent DATETIME,
       unread BOOLEAN DEFAULT TRUE
);