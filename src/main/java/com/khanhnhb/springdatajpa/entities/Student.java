package com.khanhnhb.springdatajpa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private long id;
    private String name;
    private double testScore;

    public Student() {
    }

    public Student(long id, String name, double testScore) {
        this.id = id;
        this.name = name;
        this.testScore = testScore;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTestScore() {
        return testScore;
    }

    public void setTestScore(double testScore) {
        this.testScore = testScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", testScore=" + testScore +
                '}';
    }
}
