package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Ben Lemke
Students and college students
Uses inheritance to manage infromation on students including college students
23/05/2019
 */

public class M4 {
    public static void main(String[] args) throws IOException {
        // Request info for, create, and print the data of a normal student
        System.out.println("Student: ");
        System.out.println(new Student(Integer.parseInt(get("ID Number")), Double.parseDouble(get("GPA"))));
        // Request info for, create, and print the data of a College Student
        System.out.println("College Student: ");
        System.out.println(new CollegeStudent(Integer.parseInt(get("ID Number")), Double.parseDouble(get("GPA")), get("Major")));


    }
    // prevent having to type sout etc. all the time
    static String get(String message) throws IOException {
        // setup inputs and outputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        System.out.println(message);
        return br.readLine();
    }

    // prevent having to type sout etc. all the time
    static String get() throws IOException {
        //setup inputs and outputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        return br.readLine();
    }
}
// Class for students
class Student{
    int IDNumber;
    double GPA;
    // Default constructor
    Student(){
        IDNumber = 0;
        GPA = 0;
    }
    // Constructor
    Student(int number, double gpa){
        IDNumber = number;
        GPA = gpa;
    }
    // Setters
    void setIDNumber(int number){
        IDNumber = number;
    }
    void setGPA(double gpa){
        GPA = gpa;
    }
    // Getters
    double getGPA(){
        return GPA;
    }
    int getIDNumber(){
        return IDNumber;
    }
    // To String override for printing
    public String toString(){
        return ("ID Number: " + IDNumber + " GPA: " + GPA);
    }
}

// Class for Collge Students
class CollegeStudent extends Student{
    String Major;
    // Default Constructor
    CollegeStudent(){
        // Calls super default constructor
        super();
        Major = "Undecided";
    }

    // Constructor method
    CollegeStudent(int number, double gpa, String major){
        // calls super constructor method
        super(number,gpa);
        Major = major;
    }
    // Setter for the major
    void setMajor(String major){
        Major = major;
    }
    // Getter for the major
    String getMajor(){
        return Major;
    }
    // To String method that generates a string for printing
    public String toString(){
        return ("ID Number: " + IDNumber + " GPA: " + GPA + " Major: " + Major);
    }
}
