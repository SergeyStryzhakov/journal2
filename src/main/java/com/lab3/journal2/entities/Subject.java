package com.lab3.journal2.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LAB3_SSM_SUBJECTS")
public class Subject {
    @Id
    @Column(name = "SUBJECT_ID")
    private int id;
    @Column(name = "NAME")
    private String title;
    @Column
    private int hours;

    @OneToMany(mappedBy = "subject")
    private List<Teacher> teacherList;

    public Subject(int id, String title, int hours) {
        super();
        this.id = id;
        this.title = title;
        this.hours = hours;
    }

    public Subject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", hours=" + hours +
                '}';
    }
}
