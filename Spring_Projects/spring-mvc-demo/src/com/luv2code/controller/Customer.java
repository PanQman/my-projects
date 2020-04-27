package com.luv2code.controller;

import validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {

    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$", message = "Musi być XX-XXX")
    private String postalCode;

    @NotNull(message="Nie może być puste")
    @Min(value = 18, message = "Musi być co najmniej 18")
    @Max(value = 99, message = "Musi być najwyżej 99")
    private Integer age;

    @NotNull(message="minimum 3 characters")
    @Size(min = 3, message="minimum 3 characters")
    private String lastName;

    private String firstName;

    @CourseCode()
    private String courseCode;


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
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
