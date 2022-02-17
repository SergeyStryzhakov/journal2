package com.lab3.journal2.entities;

import javax.persistence.*;

@Entity
@Table(name = "LAB3_SSM_STUDENTS")
public class Student {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FNAME", nullable = false)
    private String firstName;
    @Column(name = "LNAME", nullable = false)
    private String lastName;
    @Column
    private int age;
    @Column(name = "GROUPNAME", nullable = false)
    private String groupName;

    public Student(String firstName, String lastName, int age, String groupNumber) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.groupName = groupNumber;
    }

    public Student() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", groupNumber='" + groupName + '\'' +
                '}';
    }
}
