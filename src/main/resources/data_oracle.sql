Insert into LAB3_SSM_STUDENTS (STUDENT_ID, STUDENT_FNAME, STUDENT_LNAME, AGE, GROUPNAME)
values ('1', 'Artemiy', 'Laskov', '15', 'B52');
Insert into LAB3_SSM_STUDENTS (STUDENT_ID, STUDENT_FNAME, STUDENT_LNAME, AGE, GROUPNAME)
values ('2', 'Igor', 'Puh', '16', 'B52');
Insert into LAB3_SSM_STUDENTS (STUDENT_ID, STUDENT_FNAME, STUDENT_LNAME, AGE, GROUPNAME)
values ('3', 'Yasha', 'Dikiy', '18', 'B51');
Insert into LAB3_SSM_STUDENTS (STUDENT_ID, STUDENT_FNAME, STUDENT_LNAME, AGE, GROUPNAME)
values ('4', 'Toha', 'Pupkin', '10', 'Z14');
Insert into LAB3_SSM_STUDENTS (STUDENT_ID, STUDENT_FNAME, STUDENT_LNAME, AGE, GROUPNAME)
values ('5', 'Irina', 'Valueva', '21', 'C25');

Insert into LAB3_SSM_SUBJECTS (SUBJECT_ID, TITLE, HOURS)
values ('3', 'Geometry', '200');
Insert into LAB3_SSM_SUBJECTS (SUBJECT_ID, TITLE, HOURS)
values ('4', 'Phisics', '300');
Insert into LAB3_SSM_SUBJECTS (SUBJECT_ID, TITLE, HOURS)
values ('1', 'Math', '150');
Insert into LAB3_SSM_SUBJECTS (SUBJECT_ID, TITLE, HOURS)
values ('2', 'Geo', '120');
Insert into LAB3_SSM_SUBJECTS (SUBJECT_ID, TITLE, HOURS)
values ('5', 'Lang', '125');

Insert into LAB3_SSM_TEACHERS (TEACHER_ID, TEACHER_FNAME, TEACHER_LNAME, SALARY, SUBJECT)
values ('3', 'Vasiliy', 'Alibabaev', '300', '1');
Insert into LAB3_SSM_TEACHERS (TEACHER_ID, TEACHER_FNAME, TEACHER_LNAME, SALARY, SUBJECT)
values ('6', 'Andrey', 'Kasparov', '450', '3');
Insert into LAB3_SSM_TEACHERS (TEACHER_ID, TEACHER_FNAME, TEACHER_LNAME, SALARY, SUBJECT)
values ('7', 'Antin', 'Mukharsky', '650', '4');
Insert into LAB3_SSM_TEACHERS (TEACHER_ID, TEACHER_FNAME, TEACHER_LNAME, SALARY, SUBJECT)
values ('1', 'Artur', 'Pirojkov', '100', '2');
Insert into LAB3_SSM_TEACHERS (TEACHER_ID, TEACHER_FNAME, TEACHER_LNAME, SALARY, SUBJECT)
values ('2', 'Maksim', 'Galkin', '200', '2');
Insert into LAB3_SSM_TEACHERS (TEACHER_ID, TEACHER_FNAME, TEACHER_LNAME, SALARY, SUBJECT)
values ('8', 'Valentin', 'Ivanov', '125', '5');
Insert into LAB3_SSM_TEACHERS (TEACHER_ID, TEACHER_FNAME, TEACHER_LNAME, SALARY, SUBJECT)
values ('9', 'Matvey', 'Ivanov', '147', '5');

Insert into LAB3_SSM_MARKS (MARK_ID, STUDENT_ID, SUBJECT_ID, CREATED, VALUE, TEACHER_ID)
values ('5', '3', '1', to_date('24.02.2022', 'DD.MM.RRRR'), '2', '3');
Insert into LAB3_SSM_MARKS (MARK_ID, STUDENT_ID, SUBJECT_ID, CREATED, VALUE, TEACHER_ID)
values ('4', '2', '3', to_date('26.02.2022', 'DD.MM.RRRR'), '3', '2');
Insert into LAB3_SSM_MARKS (MARK_ID, STUDENT_ID, SUBJECT_ID, CREATED, VALUE, TEACHER_ID)
values ('1', '3', '2', to_date('23.02.2022', 'DD.MM.RRRR'), '2', '1');
Insert into LAB3_SSM_MARKS (MARK_ID, STUDENT_ID, SUBJECT_ID, CREATED, VALUE, TEACHER_ID)
values ('3', '1', '1', to_date('23.02.2022', 'DD.MM.RRRR'), '4', '3');