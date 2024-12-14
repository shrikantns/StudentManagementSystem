package com.studentapp;

import java.util.*;

import static java.lang.System.exit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main4 {
    private static List<Student> studentList;
    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("**************Student Management System ***************");
        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("******************Welcome*******************");
            System.out.println("Select an option.......");
            System.out.println("1. Register a Student");
            System.out.println("2. Find student with studentId");
            System.out.println("3. List ALl Student Information");
            System.out.println("4. List Student information in Sorted Order");
            System.out.println("Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    enrollStudent(scanner);
                    break;
                case 2:
                    findStudentById(scanner);
                    break;
                case 3:
                    printAllStudentData();
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    exit();
                default:
                    System.out.println("Invalid option selected! ... Enter between 1 to 5");
            }
        }
    }

    private static void exit() {
        System.out.println("Exit the project");
    }

    private static void findStudentById(Scanner scanner2) {
        Student studentFound = null;
        System.out.println("Enter the Student Id");
        String studentId = scanner2.next();

        //Local variable cant called implicitly , We need it explicitly

        try {
            studentFound = studentList
                    .stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No Data Found"));
        } catch (RuntimeException e) {
            System.err.println("Student with ID " + studentId + " not found!!");
        }
        studentFound.printStudentInfo();
    }

    private static void printAllStudentData() {
        if (studentList.size() > 0) {
            System.out.println("------PRINTING ALL STUDENT DATA---------");
            for (Student student : studentList) {
                student.printStudentInfo();
            }
            System.out.println("....................*************............");
        }
        else{
            System.err.println("Student list is empty !!! NO student Record Found");
        }
    }

    private static void enrollStudent(Scanner scanner2) {

        System.out.println("Enter the Student Name: ");
        String studentName = scanner2.next();

        System.out.println("Enter the Student Age:  ");
        int studentage = scanner2.nextInt();

        System.out.println("Enter the Student Id:  ");
        String studentId = scanner2.next();
        Student newStudent = new Student(studentName, studentage, studentId);
        studentList.add(newStudent);
        while (true) {
            System.out.println("Enroll to the course to be enrolled: Type Done to exit ");
            String courseName = scanner2.next();
            if (courseName.equalsIgnoreCase("done")) {
                break;
            }
            newStudent.printStudentInfo();
        }
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

}

