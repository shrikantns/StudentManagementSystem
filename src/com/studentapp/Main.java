package com.studentapp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("**************Student Management System ***************");
        System.out.println("******************Welcome*******************");
        Student s1; // S1 is reference variable // Unique identification of array created in Heap Memory
        s1 = new Student("Shrikant", 22, "S-1"); //RHS - Right Hand Side
        s1.enrollCourse("Java");
        s1.enrollCourse("DSA");
        s1.enrollCourse("Devops");
        /*System.out.println(s1); */
        s1.printStudentInfo();
        Student s2 = new Student("Rahul", 25,"S-2");
        s2.enrollCourse("Java");
        s2.printStudentInfo();
        Student s3 = new Student("Man",25,"S-4");
        s3.enrollCourse("DSA");
        s3.printStudentInfo();
        //Array list is Impotent in nature , Array list can accept duplicate elements
        //Class will be loaded in the memory
        //Instance variable will be created
        //Constructor will be called
        //Method always been called in Stack Memory
        //Arguments are always local variables

        }
    }
