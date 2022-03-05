drop TABLE LAB3_SSM_MARKS;
drop TABLE LAB3_SSM_TEACHERS;
drop TABLE LAB3_SSM_SUBJECTS;
drop TABLE LAB3_SSM_STUDENTS;
drop sequence LAB3_SSM_STUDENTS_SEQ;
drop sequence LAB3_SSM_SUBJECTS_SEQ;
drop sequence LAB3_SSM_TEACHERS_SEQ;
drop sequence LAB3_SSM_MARKS_SEQ;
drop trigger LAB3_SSM_STUDENTS_TRIGGER;
drop trigger LAB3_SSM_SUBJECT_TRIGGER;
drop trigger LAB3_SSM_TEACHERS_TRIGGER;
drop trigger LAB3_SSM_MARKS_TRIGGER;

create table LAB3_SSM_STUDENTS
(
    STUDENT_ID    NUMBER(10)   not null
        constraint LAB3_SSM_STUDENTS_PK
            primary key,
    STUDENT_FNAME VARCHAR2(50) not null,
    STUDENT_LNAME VARCHAR2(50) not null,
    AGE           NUMBER(2),
    GROUPNAME     VARCHAR2(20) not null
);
create table LAB3_SSM_SUBJECTS
(
    TITLE      VARCHAR2(40) not null,
    HOURS      NUMBER(3)    not null,
    SUBJECT_ID NUMBER(3)    not null
        constraint SUBJECTS_PK
            primary key
);
create table LAB3_SSM_TEACHERS
(
    TEACHER_ID    NUMBER(4)     not null
        constraint LAB3_SSM_TEACHERS_PK
            primary key,
    TEACHER_FNAME VARCHAR2(100) not null,
    TEACHER_LNAME VARCHAR2(20)  not null,
    SALARY        NUMBER        not null,
    SUBJECT       NUMBER
        constraint LAB3_SSM_TEACHERS_FK1
            references LAB3_SSM_SUBJECTS
);
create table LAB3_SSM_MARKS
(
    MARK_ID    NUMBER(3) not null
        constraint LAB3_SSM_MARKS_PK
            primary key,
    STUDENT_ID NUMBER(3) not null
        constraint LAB3_SSM_MARKS_FK3
            references LAB3_SSM_STUDENTS,
    SUBJECT_ID NUMBER(3) not null
        constraint LAB3_SSM_MARKS_FK1
            references LAB3_SSM_SUBJECTS,
    CREATED    DATE      not null,
    VALUE      NUMBER,
    TEACHER_ID NUMBER(3) not null
        constraint LAB3_SSM_MARKS_FK2
            references LAB3_SSM_TEACHERS
);
create sequence LAB3_SSM_STUDENTS_SEQ
    nocache;
create sequence LAB3_SSM_SUBJECTS_SEQ
    nocache;
create sequence LAB3_SSM_TEACHERS_SEQ
    nocache;
create sequence LAB3_SSM_MARKS_SEQ
    nocache;
create trigger LAB3_SSM_STUDENTS_TRIGGER
    before insert
    on LAB3_SSM_STUDENTS
    for each row
BEGIN
    SELECT LAB3_SSM_STUDENTS_SEQ.nextval
    INTO :new.STUDENT_ID
    FROM dual;
END;
/
create trigger LAB3_SSM_SUBJECT_TRIGGER
    before insert
    on LAB3_SSM_SUBJECTS
    for each row
BEGIN
    SELECT LAB3_SSM_SUBJECTS_SEQ.nextval
    INTO :new.SUBJECT_ID
    FROM dual;
END;
/
create trigger LAB3_SSM_TEACHERS_TRIGGER
    before insert
    on LAB3_SSM_TEACHERS
    for each row
BEGIN
    SELECT LAB3_SSM_TEACHERS_SEQ.nextval
    INTO :new.TEACHER_ID
    FROM dual;
END;
/
create trigger LAB3_SSM_MARKS_TRIGGER
    before insert
    on LAB3_SSM_MARKS
    for each row
BEGIN
    SELECT LAB3_SSM_MARKS_SEQ.nextval
    INTO :new.MARK_ID
    FROM dual;
END;


