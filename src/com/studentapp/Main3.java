package com.studentapp;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main3 {
    private static List<Student> studentList;

    public static void main(String[] args) {
        System.out.println("**************Student Management System ***************");
        System.out.println("******************Welcome*******************");
        studentList = new ArrayList<>();
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter Student Name: ");
        String name = Sc.next();
        System.out.println(" You entered the name "  +name);

        System.out.println("Enter Student Age:  ");
        int age = Sc.nextInt();
        System.out.println("You entered the Student age " +age);
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

