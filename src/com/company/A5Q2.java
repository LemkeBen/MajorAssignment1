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

            // call methods and print values
            double size = z1.modulus();
            System.out.println(size);
            z2.scale(5);
            System.out.println(z2.toString());
            System.out.println(z1.plus(z3).toString());
            System.out.println(z1.times(z3).toString());

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
    public String toString(){
        return (real + "+ i" + imaginary);
    }
    public double modulus(){
        return (Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2)));
    }
    public void scale(double x){
        real*= x;
        imaginary*= x;
    }
    public FancyComplex plus(FancyComplex other){
        return new FancyComplex(this.real + other.real, this.imaginary + other.imaginary);
    }
    public FancyComplex times(FancyComplex other){
        return new FancyComplex(this.real * other.real, this.imaginary * other.imaginary);
    }
}
