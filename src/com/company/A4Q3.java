package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;
import static java.lang.Math.abs;

public class A4Q3 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader (System.in);
        BufferedReader br = new BufferedReader (reader);
        boolean another = true;
        while (another){
            //ask whether to use specs from question
            System.out.println("use defaults?");
            double a1;
            double a2;
            double b1;
            double b2;

            if ("yes".equals(br.readLine())){
                a1 = 2;
                b1 = 3;
                a2 = 5;
                b2 = -4;
            }
            else {
                // get the coordinates and radii
                System.out.println("a1");
                a1 = Integer.parseInt(br.readLine());
                System.out.println("b1");
                b1 = Integer.parseInt(br.readLine());
                System.out.println("a2");
                a2 = Integer.parseInt(br.readLine());
                System.out.println("b2");
                b2 = Integer.parseInt(br.readLine());
            }

            // create complex numbers with default values
            Complex z1 = new Complex(a1,b1);
            Complex z2 = new Complex(a2,b2);
            // add them and print them
            z1 = new Complex((z1.real + z2.real),(z1.imaginary + z2.imaginary));
            System.out.println(z1.real + " " + z1.imaginary + "i");

            // ask user whether or not to do it again
            another = (!br.readLine().equals("quit"));
        }

    }

}

// Define a class for complex numbers
class Complex{
    double real;
    double imaginary;
    // constructor method
    Complex(double a, double b){
        real = a;
        imaginary = b;
    }
}
