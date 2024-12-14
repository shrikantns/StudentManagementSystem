package com.studentapp;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main2 {
    private static List<Student> studentList;

    public static void main(String[] args) {
        System.out.println("**************Student Management System ***************");
        System.out.println("******************Welcome*******************");
        studentList = new ArrayList<>();
        Student s1; // S1 is reference variable // Unique identification of array created in Heap Memory
        s1 = new Student("Shrikant", 22, "S-1"); //RHS - Right Hand Side
        s1.enrollCourse("Java");
        s1.enrollCourse("DSA");
        s1.enrollCourse("Devops");
        Student s2 = new Student("Rahul", 25, "S-2");
        s2.enrollCourse("Java");
        Student s3 = new Student("Man", 22, "S-4");
        s3.enrollCourse("DSA");
        Student s4 = new Student("Teju", 26, "S-10");
        s4.enrollCourse("Java");
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        Student result = findStudentById("S-4");
        System.out.println(("Result" + result));
        sortByName();
    }

    private static void sortByName() {
        Comparator<Student> studentNameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo( o2.getName());
            }
        };
        Collections.sort(studentList, studentNameComparator);
        System.out.println(studentList);
    }

    public static Student findStudentById(String studentId) {

        Student result = null;

        //Local variable cant called implicitly , We need it explicitly
        
                try{
                    result = studentList
                            .stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("No Data Found"));
                }
                catch(RuntimeException e){
                    System.err.println("Student with ID " +studentId+" not found!!");
                }
        return result;
    }
}

