package com.restful.webservice.entity;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

//helo
@XmlRootElement
public class Student {

    @FormParam("name")
    private String name;

    @FormParam("age")
    private int age;

    @FormParam("grade")
    private String grade;

    @FormParam("adult")
    private boolean adult;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", adult=" + adult +
                '}';
    }
}
