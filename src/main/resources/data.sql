Insert into LAB3_SSM_STUDENTS (STUDENT_FNAME, STUDENT_LNAME, AGE, GROUPNAME)
values ('Artemiy', 'Laskov', '15', 'B52');
Insert into LAB3_SSM_STUDENTS (STUDENT_FNAME, STUDENT_LNAME, AGE, GROUPNAME)
values ('Igor', 'Puh', '16', 'B52');
Insert into LAB3_SSM_STUDENTS (STUDENT_FNAME, STUDENT_LNAME, AGE, GROUPNAME)
values ('Yasha', 'Dikiy', '18', 'B51');
Insert into LAB3_SSM_STUDENTS (STUDENT_FNAME, STUDENT_LNAME, AGE, GROUPNAME)
values ('Toha', 'Pupkin', '10', 'Z14');
Insert into LAB3_SSM_STUDENTS (STUDENT_FNAME, STUDENT_LNAME, AGE, GROUPNAME)
values ('Irina', 'Valueva', '21', 'C25');

Insert into LAB3_SSM_SUBJECTS (TITLE, HOURS)
values ('Geometry', '200');
Insert into LAB3_SSM_SUBJECTS (TITLE, HOURS)
values ('Phisics', '300');
Insert into LAB3_SSM_SUBJECTS (TITLE, HOURS)
values ('Math', '150');
Insert into LAB3_SSM_SUBJECTS (TITLE, HOURS)
values ('Geo', '120');
Insert into LAB3_SSM_SUBJECTS (TITLE, HOURS)
values ('Lang', '125');

Insert into LAB3_SSM_TEACHERS (TEACHER_FNAME, TEACHER_LNAME, SALARY, SUBJECT)
values ('Vasiliy', 'Alibabaev', '300', '1');
Insert into LAB3_SSM_TEACHERS (TEACHER_FNAME, TEACHER_LNAME, SALARY, SUBJECT)
values ('Andrey', 'Kasparov', '450', '3');
Insert into LAB3_SSM_TEACHERS (TEACHER_FNAME, TEACHER_LNAME, SALARY, SUBJECT)
values ('Antin', 'Mukharsky', '650', '4');
Insert into LAB3_SSM_TEACHERS (TEACHER_FNAME, TEACHER_LNAME, SALARY, SUBJECT)
values ('Artur', 'Pirojkov', '100', '2');
Insert into LAB3_SSM_TEACHERS (TEACHER_FNAME, TEACHER_LNAME, SALARY, SUBJECT)
values ('Maksim', 'Galkin', '200', '2');
Insert into LAB3_SSM_TEACHERS (TEACHER_FNAME, TEACHER_LNAME, SALARY, SUBJECT)
values ('Valentin', 'Ivanov', '125', '5');
Insert into LAB3_SSM_TEACHERS (TEACHER_FNAME, TEACHER_LNAME, SALARY, SUBJECT)
values ('Matvey', 'Ivanov', '147', '5');

Insert into LAB3_SSM_MARKS (STUDENT_ID, SUBJECT_ID, CREATED, VALUE, TEACHER_ID)
values ('3', '1', to_date('24.02.2022', 'DD.MM.YYYY'), '2', '3');
Insert into LAB3_SSM_MARKS (STUDENT_ID, SUBJECT_ID, CREATED, VALUE, TEACHER_ID)
values ('2', '3', to_date('26.02.2022', 'DD.MM.YYYY'), '3', '2');
Insert into LAB3_SSM_MARKS (STUDENT_ID, SUBJECT_ID, CREATED, VALUE, TEACHER_ID)
values ('3', '2', to_date('23.02.2022', 'DD.MM.YYYY'), '2', '1');
Insert into LAB3_SSM_MARKS (STUDENT_ID, SUBJECT_ID, CREATED, VALUE, TEACHER_ID)
values ('1', '1', to_date('23.02.2022', 'DD.MM.YYYY'), '4', '3');

INSERT INTO lab3_ssm_users (username, password, role)
VALUES ('teacher', '$2a$10$VuL0gmhr172f01YcLjLpQ.kBG2E.Fn2MNie738P7k4lfQkg1Q6JSi', 'ROLE_TEACHER');
INSERT INTO lab3_ssm_users (username, password, role)
VALUES ('admin', '$2a$10$nMmsqpQMqY3FZ81iaDiVOeXklO8hXGaedUSSbLr9k7KhqhcNyMXJq', 'ROLE_ADMIN');
INSERT INTO lab3_ssm_users (username, password, role)
VALUES ('student', '$2a$10$PZ0sBjkogfOO/pNogF57c.sBcpnKmy3I8GAQ0RJqqR7x0WhIVb4wS', 'ROLE_STUDENT');