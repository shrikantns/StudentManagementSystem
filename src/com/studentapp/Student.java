package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    //Instance Variable are always non-static
    //if mark them static those are class variable
    //Attributes are always are Instance variable
    //Instance variable are always mark as private
    //Data Type of name is non-primitive data type

    private String name;  //name is non primitive = default value is null
    private int age;  // age is primitive = default value is 0
    private String studentId; // studentID is non primitive = default value is null
    private List<String> courses; // courses is non primitive = default value is null

    public Student(String name, int age, String studentId) {
        super(); // Parent Class Constructor
        if (validateAge(age) && validatename(name) && validateStudentId(studentId)) {
            this.name = name;  // this word can differentiate between local and instance variable
            this.age = age;
            this.studentId = studentId;
            courses = new ArrayList<String>(); // Intialization of courses//
            //Hashcode store in heap memory
        }
    }
    public void enrollCourse(String course) {
        if (validateCourseName(course)) {
            if (!courses.contains(course)) {
                courses.add(course);
                System.out.println("Student is enrolled to "  +course+  " successfully!!");
            } else {
                System.err.println("Student is already enrolled to the Course Java");
            }
        }
    }

        public void printStudentInfo () {
            System.out.println("====================Student Information========================");
            System.out.println("Student Name: " + name);
            System.out.println("Student age: " + age);
            System.out.println("Student Id: " + studentId);
            System.out.println("Enrolled For " + courses);
        }

        @Override
        public String toString () {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", studentId='" + studentId + '\'' +
                    ", courses=" + courses +
                    '}';
        }

        //Validation Methods : Error handling
        public boolean validateAge (int age){
            if (age >= 19 && age <= 35) {
                return true;
            } else {
                System.err.println("Invalid age !!! Student Age needs to between 19 to 35");
                return false;
            }
            // if you are going to have instance variable you must have validation method
        }

        //Regex - Regular Expression
        public boolean validatename (String name){
            //kajal
            // \\s = White Spaces are allowed
            String nameRegex = "^[a-zA-Z\\s]+$";
            Pattern namePattern = Pattern.compile(nameRegex);
            Matcher nameMatcher = namePattern.matcher(name);
            //^ Indicates to start alphabets
            // S means no of alphabets
            // $ end with alphabets
            // Remember instance variable always mark with private keyword
            if (nameMatcher.matches()) {
                return true;
            } else {
                System.err.println("Invalid Name!!!!!! Student name must be in Alphabets");
                return false;
            }
        }

        public boolean validateStudentId (String studentId){
            String studentIdRegex = "S-\\d+$";
            Pattern studentPattern = Pattern.compile(studentIdRegex);
            Matcher studentIdMatcher = studentPattern.matcher(studentId);
            if (studentIdMatcher.matches()) {
                return true;
            } else {
                System.err.println("Invalid Student Id ... Enter Correct ID");
                return false;
            }
        }

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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public boolean validateCourseName (String course){
            if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("Devops")) {
                return true;
            } else {
                System.err.println("Invalid Course Name !!! Please enroll correct course from list [Jave,DSA,Devops]");
                return false;
            }

        }
}


