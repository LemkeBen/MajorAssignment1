package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.min;
import static java.lang.Math.abs;

/*
Ben Lemke
Harmonic Fractions
Implements a method for the fraction class that calculates harmonic sums
27/04/2019
*/

public class M2Q6 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        boolean another = true;
        // loop until the user doesn't want to do more
        while (another) {
            //ask whether to use specs from question
            System.out.println("use defaults?");
            int n;

            if ("yes".equals(br.readLine())) {
                n = 10;
            } else {
                // get the numerators and denominators
                System.out.println("n");
                n = Integer.parseInt(br.readLine());
            }

            //create an instance and run harmonicsum
            FanciestFraction harmo = new FanciestFraction(0,1);
            harmo.harmonicSum(n);
            System.out.println(harmo);


            // ask user whether or not to do it again
            System.out.println("again?");
            another = (!br.readLine().equals("quit"));
        }
    }
}
// class for fractions
class FanciestFraction {
    //fractions have numerators and denominators
    private int numerator;
    private int denominator;

    //fraction constructor setting the numerator and the denominator
    public FanciestFraction(int n, int d){
        numerator = n;
        denominator = d;
    }

    // returns a string of the current fraction in mixed fraction form
    public String toString(){
        if (numerator == 0){
            return ("0");
        }
        int sign = numerator / abs(numerator) * denominator / abs(denominator);
        String signSymbol = "";
        if (sign == -1){
            signSymbol = "-";
        }
        reduce();
        FanciestFraction absVersion = absolute();
        if (absVersion.denominator == 1){
            return signSymbol + String.valueOf(absVersion.numerator);
        }
        else if(absVersion.numerator > absVersion.denominator){
            int modulo = absVersion.numerator % absVersion.denominator;
            return signSymbol + String.valueOf((absVersion.numerator - modulo) / absVersion.denominator) + "and" + String.valueOf(modulo) + " / " + String.valueOf(absVersion.denominator);
        }
        return signSymbol + String.valueOf(absVersion.numerator) + " / " + String.valueOf(absVersion.denominator);
    }

    //return a fraction that has the absolute value o the current fraction
    public FanciestFraction absolute(){
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
        return new FanciestFraction(absNumerator,absDenominator);
    }
    //add a fraction to current fraction
    public void plusEquals(FanciestFraction fraction){
        numerator = numerator * fraction.denominator + fraction.numerator * denominator;
        denominator = denominator * fraction.denominator;
    }
    //add a fraction to current fraction
    public FanciestFraction plus(FanciestFraction fraction){
        return new FanciestFraction(this.numerator * fraction.denominator + fraction.numerator * this.denominator,this.denominator * fraction.denominator);
    }
    //subtract a fraction from current fraction
    public FanciestFraction minus(FanciestFraction fraction){
        return new FanciestFraction(this.numerator * fraction.denominator - fraction.numerator * this.denominator,this.denominator * fraction.denominator);
    }
    //return the product of this fraction and another fraction
    public FanciestFraction times(FanciestFraction fraction){
        return new FanciestFraction(this.numerator * fraction.numerator, this.denominator * fraction.denominator);
    }
    // convert fraction to lowest terms
    public void reduce(){
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
                reduce();
            }
        }
        // if there are no common factors, return
        return;
    }

    public boolean equals(FanciestFraction other) {
        this.reduce();
        other.reduce();
        return (this.numerator == other.numerator) && (this.denominator == other.denominator);
    }

    public void harmonicSum(int n){
        numerator = 0;
        denominator = 1;
        for (int i = 1; i <= n; i++){
            plusEquals(new FanciestFraction(1,i));
            reduce();
        }
    }
}