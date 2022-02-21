package com.lab3.journal2.entities;

import javax.persistence.*;

@Entity
@Table(name = "LAB3_SSM_TEACHERS")
public class Teacher {
    @Id
    private int id;
    @Column(name = "FNAME")
    private String firstName;
    @Column(name = "LNAME")
    private String lastName;
    @Column
    private float salary;
    @ManyToOne
    @JoinColumn(name = "SUBJECT")
    private Subject subject;

    public Teacher(int id, String firstName, String lastName,  float salary, Subject subject) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

        this.salary = salary;
        this.subject = subject;
    }

    public Teacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

       public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
