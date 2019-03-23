package com.company;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Math.min;
/*
Ben Lemke
Fancy Fractions
Implements a FancyFractionclass to manipulate fractions
22/03/2019
 */

public class A5Q1 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader (System.in);
        BufferedReader br = new BufferedReader (reader);
        boolean another = true;
        // loop until the user doesn't want to do more
        while (another){
            // get the numerators and denominators
            System.out.println("numerator");
            int n1 = Integer.parseInt(br.readLine());
            System.out.println("denominator");
            int d1 = Integer.parseInt(br.readLine());
            //create the factions and do the operations
            FancyFraction f1 = new FancyFraction(n1,d1);
            f1.PlusEquals(new FancyFraction(6,7));
            f1 = f1.Plus(new FancyFraction(3,5));
            f1.Reduce();
            // print the fractions
            System.out.println(f1.getString());
            // ask the user whether or not to continue
            another = (!br.readLine().equals("quit"));
        }
    }
}
// class for fractions
class FancyFraction {
    //fractions have numerators and denominators
    private int numerator;
    private int denominator;

    //fraction constructor setting the numerator and the denominator
    public FancyFraction(int n, int d){
        numerator = n;
        denominator = d;
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

    //return a fraction that is the PlusEquals of the current fraction and an input
    public FancyFraction Plus(FancyFraction fraction){
        return new FancyFraction(this.numerator + fraction.numerator, this.denominator + fraction.denominator);
    }
    //add a fraction to current fraction
    public void PlusEquals(FancyFraction fraction){
        numerator = numerator * fraction.denominator + fraction.numerator * denominator;
        denominator = denominator * fraction.denominator + fraction.denominator * numerator;
    }
    // convert fraction to lowest terms
    public void Reduce(){
        // if either numerator or denominator in 1 fraction is not reducable
        if (numerator == 1 || denominator == 1){
            return;
        }
        // loop through integers less than numerator and denominator to look for common factors
        for (int i = 2; i < min(numerator, denominator); i++){
            // If an integer is a factor of both devide both by that factor and reduce the result
            if ((numerator % i)== 0 && denominator % i == 0){
                numerator/= i;
                denominator/= i;
                Reduce();
            }
        }
        // if there are no common factors, return
        return;
    }
}