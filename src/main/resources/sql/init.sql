CREATE TABLE questionnaires (
    id bigserial primary key,
    name varchar(255)
);

CREATE TABLE questions (
  id bigserial primary key,
  name varchar(500),
  count_answer int,
  questionnaire_id bigint REFERENCES questionnaires (id)
);

CREATE TABLE answers (
    id bigserial primary key,
    name varchar(255),
    question_id bigint REFERENCES questions (id)
);

CREATE TABLE users_answer (
    id bigserial primary key,
    answer_id bigint REFERENCES answers (id),
    user_id bigint REFERENCES users(id)
);


CREATE TABLE users (
    id bigserial PRIMARY KEY,
    email varchar(255) NOT NULL UNIQUE,
    name varchar(255) NOT NULL,
    password varchar(255) NOT NULL ,
    role varchar(255) NOT NULL,
    status varchar(255) default 'ACTIVE'
);

INSERT INTO users (email, name , password, role)
VALUES ('admin@mail.com', 'admin', '$2a$12$e7g3K/CTygBiGk8Xqtrj7O1EQqafthvOk6nX/9AW2PcMSInZxErda', 'ADMIN'),
       ('user@mail.com' , 'user', '$2a$12$bQpRgYoq8HbfT3W9tOzDo.awjpxmhJ6YPDGBDbSjLLDZycp/KIBbO', 'USER' );