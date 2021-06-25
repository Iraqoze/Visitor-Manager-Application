package com.iraqoz.visitormanager;

public class User {
    String Name,Nationality,Education;
    Integer Age;


    public User(String name, String nationality, String education, Integer age) {
        Name = name;
        Nationality = nationality;
        Education = education;
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Nationality='" + Nationality + '\'' +
                ", Education='" + Education + '\'' +
                ", Age=" + Age +
                '}';
    }
}
