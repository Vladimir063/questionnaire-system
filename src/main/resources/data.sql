INSERT INTO users (email, name, password, role)
VALUES ('admin@mail.com', 'Admin', '$2a$12$e7g3K/CTygBiGk8Xqtrj7O1EQqafthvOk6nX/9AW2PcMSInZxErda', 'ADMIN'),
       ('ivan@mail.com', 'Ivan', '$2a$12$bQpRgYoq8HbfT3W9tOzDo.awjpxmhJ6YPDGBDbSjLLDZycp/KIBbO', 'USER'),
       ('petr@mail.com', 'Petr', '$2a$12$bQpRgYoq8HbfT3W9tOzDo.awjpxmhJ6YPDGBDbSjLLDZycp/KIBbO', 'USER');

INSERT INTO questionnaires (id, name)
values (1, 'О себе'),
       (2, 'Фильмы');


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



INSERT INTO questions (id, name, count_answer, questionnaire_id)
values (4, 'Ваш любимый фильм', 4, 2),
       (5, 'Ваш любимый актер', 4, 2);


INSERT INTO answers (id, name, question_id)
values (8, 'Мстители', 4),
       (9, 'Звездне войны', 4),
       (10, 'Властелин колец', 4),
       (11, 'Другой', 4);


INSERT INTO answers (id, name, question_id)
values (12, 'Брэд Питт', 5),
       (13, 'Дэниел Крейг', 5),
       (14, 'Джейсон Стейтем', 5),
       (15, 'Другой', 5);


INSERT INTO user_questionnaire (id, user_id, questionnaire_id)
values (2, 2, 2),
       (3, 3, 2);

INSERT INTO users_answer (id, answer_id, user_id)
values (4, 8, 2),
       (5, 9, 2),
       (6, 14, 2),
       (7, 10, 3),
       (8, 12, 3);