package com.company;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Math.abs;


public class A4Q1 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader (System.in);
        BufferedReader br = new BufferedReader (reader);
        boolean another = true;
        // loop until the user doesn't want to do more
        while (another){
            // get the numerators and denominators
            System.out.println("numerator1");
            int n1 = Integer.parseInt(br.readLine());
            System.out.println("denominator1");
            int n2 = Integer.parseInt(br.readLine());
            System.out.println("numerator2");
            int d1 = Integer.parseInt(br.readLine());
            System.out.println("denominator2");
            int d2 = Integer.parseInt(br.readLine());
            //create the factions and do the operations
            FancyFraction f1 = new FancyFraction(n1,d1);
            FancyFraction f2 = new FancyFraction(n2,d2);
            f1 = f1.timesTwo();
            f2 = f2.invert();
            f1 = f1.product(f2);
            f2 = f1.PlusEquals(f2);
            f1 = f1.absolute();
            // print the fractions
            System.out.println(f1.getString());
            System.out.println(f2.getString());
            // ask the user whether or not to continue
            another = (!br.readLine().equals("quit"));
        }
    }
}
// class for fractions
class Fraction{
    //fractions have numerators and denominators
    public int numerator;
    public int denominator;
    //fraction constructor setting the numerator and the denominator
    public Fraction(int n, int d){
        numerator = n;
        denominator = d;
    }
    // return the current fraction times two
    public FancyFraction timesTwo(){
        return new FancyFraction(this.numerator * 2, this.denominator);
    }
    // returns a string of the current fraction in # / # form
    public String getString(){
        return String.valueOf(numerator) + " / " + String.valueOf(denominator);
    }
    //return a fraction that has the absolute value o the current fraction
    public FancyFraction absolute(){
        int absNumerator;
        int absDenominator;
        if (numerator < 0){
            absNumerator = numerator * -1;
        }
        else{
            absNumerator = numerator;
        }
        if (denominator < 0){
            absDenominator = denominator * -1;
        }
        else{
            absDenominator = denominator;
        }
        return new FancyFraction(absNumerator,absDenominator);
    }
    //return a fraction that is the reciprocal of the current fraction
    public FancyFraction invert(){
        return new FancyFraction(this.denominator, this.numerator);
    }
    //return a fraction that is the PlusEquals of the current fraction and an input

    public FancyFraction sum(FancyFraction fraction){
        return new FancyFraction(this.numerator + fraction.numerator, this.denominator + fraction.denominator);
    }
    //return a fraction that is the product of the current fraction and an input
    public FancyFraction product(FancyFraction fraction){
        return new FancyFraction(this.numerator * fraction.numerator, this.denominator * fraction.denominator);
    }
}