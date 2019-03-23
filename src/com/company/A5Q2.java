package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A5Q2 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        boolean another = true;

        while (another) {

            double a1;
            double a2;
            double a3;
            double b1;
            double b2;
            double b3;


            // get the coordinates and radii
            System.out.println("a1");
            a1 = Integer.parseInt(br.readLine());
            System.out.println("b1");
            b1 = Integer.parseInt(br.readLine());
            System.out.println("a2");
            a2 = Integer.parseInt(br.readLine());
            System.out.println("b2");
            b2 = Integer.parseInt(br.readLine());
            System.out.println("a3");
            a3 = Integer.parseInt(br.readLine());
            System.out.println("b3");
            b3 = Integer.parseInt(br.readLine());

            // create complex numbers with values
            FancyComplex z1 = new FancyComplex(a1, b1);
            FancyComplex z2 = new FancyComplex(a2, b2);
            FancyComplex z3 = new FancyComplex(a3, b3);

            // add them and print them
            z1 = new FancyComplex((z1.real + z2.real), (z1.imaginary + z2.imaginary));
            System.out.println(z1.real + " " + z1.imaginary + "i");

            // ask user whether or not to do it again
            another = (!br.readLine().equals("quit"));
        }
    }
}
// Define a class for complex numbers
class FancyComplex{
    double real;
    double imaginary;
    // constructor method
    FancyComplex(double a, double b){
        real = a;
        imaginary = b;
    }
    public double modulus(){
        return (Math.pow((Math.pow(real, 2) + Math.pow(imaginary, 2)),1/2));
    }
}
