drop table if exists lab3_ssm_marks cascade;
drop table if exists lab3_ssm_students cascade;
drop table if exists lab3_ssm_teachers cascade;
drop table if exists lab3_ssm_subjects cascade;
drop table if exists lab3_ssm_users cascade;
create table LAB3_SSM_STUDENTS
(
    STUDENT_ID    SERIAL primary key,
    STUDENT_FNAME varchar(50) not null,
    STUDENT_LNAME varchar(50) not null,
    AGE           int,
    GROUPNAME     varchar(20) not null
);
create table LAB3_SSM_SUBJECTS
(
    SUBJECT_ID SERIAL primary key,
    TITLE      varchar(40) not null,
    HOURS      int         not null

);
create table LAB3_SSM_TEACHERS
(
    TEACHER_ID    serial primary key,
    TEACHER_FNAME varchar(50) not null,
    TEACHER_LNAME varchar(50) not null,
    SALARY        int         not null,
    SUBJECT       int         not null,
    constraint fk_teachers_subject
        foreign key (SUBJECT)
            references LAB3_SSM_SUBJECTS (subject_id)
            on delete cascade
);
create table LAB3_SSM_MARKS
(
    MARK_ID    serial primary key,
    STUDENT_ID int  not null,
    SUBJECT_ID int  not null,
    CREATED    DATE not null default CURRENT_DATE,
    VALUE      int,
    TEACHER_ID int  not null,
    constraint fk_marks_student
        foreign key (STUDENT_ID)
            references LAB3_SSM_STUDENTS (student_id)
            on delete cascade,
    constraint fk_marks_subject
        foreign key (SUBJECT_ID)
            references LAB3_SSM_SUBJECTS (subject_id)
            on delete cascade,
    constraint fk_marks_teachers
        foreign key (TEACHER_ID)
            references LAB3_SSM_TEACHERS (teacher_id)
            on delete cascade
);
create table LAB3_SSM_USERS
(
    USERNAME varchar(50)  not null
        primary key,
    PASSWORD varchar(100) not null,
    ROLE     varchar(20)  not null
);