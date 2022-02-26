package com.lab3.journal2.entities;


public class Teacher {

    private int id;

    private String firstName;

    private String lastName;

    private float salary;

    private int subject;

    public Teacher(int id, String firstName, String lastName,  float salary, int subject) {
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

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }
}
