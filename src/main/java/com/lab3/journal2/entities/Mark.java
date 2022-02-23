package com.lab3.journal2.entities;

import javax.persistence.*;

@Entity
@Table(name = "LAB3_SSM_MARKS")
public class Mark {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "SUBJECT")
    private Subject subject;
    @Column(name = "CREATED")
    private String created;
    @Column(name = "MARK")
    private int value;
    @ManyToOne
    @JoinColumn(name = "TEACHER")
    private Teacher teacher;

    public Mark(int id, Student student, Subject subject, String created, int value, Teacher teacher) {
        super();
        this.id = id;
        this.student = student;
        this.subject = subject;
        this.created = created;
        this.value = value;
        this.teacher = teacher;
    }

    public Mark() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
