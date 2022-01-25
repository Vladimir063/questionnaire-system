INSERT INTO users (email, name, password, role)
VALUES ('admin@mail.com', 'Admin', '$2a$12$e7g3K/CTygBiGk8Xqtrj7O1EQqafthvOk6nX/9AW2PcMSInZxErda', 'ADMIN'),
       ('ivan@mail.com', 'Ivan', '$2a$12$bQpRgYoq8HbfT3W9tOzDo.awjpxmhJ6YPDGBDbSjLLDZycp/KIBbO', 'USER'),
       ('petr@mail.com', 'Petr', '$2a$12$bQpRgYoq8HbfT3W9tOzDo.awjpxmhJ6YPDGBDbSjLLDZycp/KIBbO', 'USER');

INSERT INTO questionnaires (id, name)
values (1, 'О себе'),
       (2, 'Фильмы'),
       (3, 'Сериалы');

INSERT INTO questions (id, name, count_answer, questionnaire_id)
values (1, 'Сколько вам лет?', 4, 1),
       (2, 'Ваш пол', 2, 1),
       (3, 'Вы работаете?', 2, 1);

INSERT INTO answers (id, name, question_id)
values (1, 'Меньше 20', 1),
       (2, 'От 20 до 50', 1),
       (3, 'Больше 50', 1);

INSERT INTO answers (id, name, question_id)
values (4, 'Мужской', 2),
       (5, 'Женский', 2);

INSERT INTO answers (id, name, question_id)
values (6, 'Да', 3),
       (7, 'Нет', 3);

INSERT INTO user_questionnaire (id, user_id, questionnaire_id)
values (1, 3, 1);

INSERT INTO users_answer (id, answer_id, user_id)
values (1, 1, 3),
       (2, 4, 3),
       (3, 6, 3);



