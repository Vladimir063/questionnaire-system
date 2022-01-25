DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS questionnaires;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS users_answer;
DROP TABLE IF EXISTS user_questionnaire;


CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email varchar(255) NOT NULL UNIQUE,
    name varchar(255) NOT NULL,
    password varchar(255) NOT NULL ,
    role varchar(255) NOT NULL,
    status varchar(255) default 'ACTIVE'
);


CREATE TABLE questionnaires (
    id INT AUTO_INCREMENT primary key,
    name varchar(255)
);


CREATE TABLE questions (
  id INT AUTO_INCREMENT primary key,
  name varchar(500),
  count_answer int,
  questionnaire_id bigint REFERENCES questionnaires (id)
);


CREATE TABLE answers (
    id INT AUTO_INCREMENT primary key,
    name varchar(255),
    question_id bigint REFERENCES questions (id)
);


CREATE TABLE users_answer (
    id INT AUTO_INCREMENT primary key,
    answer_id bigint REFERENCES answers (id),
    user_id bigint REFERENCES users(id)
);


CREATE TABLE user_questionnaire (
    id INT AUTO_INCREMENT primary key,
    user_id bigint REFERENCES users (id) ,
    questionnaire_id bigint REFERENCES questionnaires (id)
);


