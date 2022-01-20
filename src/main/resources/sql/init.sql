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