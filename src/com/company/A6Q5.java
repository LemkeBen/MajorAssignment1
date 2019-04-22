package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.min;

public class A6Q5 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        boolean another = true;
        // loop until the user doesn't want to do more
        while (another) {
            //ask whether to use specs from question
            System.out.println("use defaults?");
            int n1;
            int d1;
            int n2;
            int d2;
            int n3;
            int d3;

            if ("yes".equals(br.readLine())) {
                n1 = 151;
                n2 = 40;
                n3 = 40;
                d1 = 150;
                d2 = 40;
                d3 = 40;
            } else {
                // get the numerators and denominators
                System.out.println("n1");
                n1 = Integer.parseInt(br.readLine());
                System.out.println("n2");
                n2 = Integer.parseInt(br.readLine());
                System.out.println("n3");
                n3 = Integer.parseInt(br.readLine());
                System.out.println("d1");
                d1 = Integer.parseInt(br.readLine());
                System.out.println("d2");
                d2 = Integer.parseInt(br.readLine());
                System.out.println("d3");
                d3 = Integer.parseInt(br.readLine());
            }

            //create the instances of the class and do the operations to them
            FancyFraction f1 = new FancyFraction(n1,d1);
            FancyFraction f2 = new FancyFraction(n2,d2);
            FancyFraction f3 = new FancyFraction(n3,d3);
            FancyFraction f4 = f1.times(f2).minus(f3.times(f3));
            for (int i = 0; i < 10; i++){
                f1 = new FancyFraction(1 , 2 * i + 1);
                f2 = new FancyFraction(1 , 2 * i - 1);
                FancyFraction fthis = f1.minus(f2);
                System.out.println(fthis.toString());
            }




            // ask user whether or not to do it again
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
    //add a fraction to current fraction
    public void plusEquals(FancyFraction fraction){
        numerator = numerator * fraction.denominator + fraction.numerator * denominator;
        denominator = denominator * fraction.denominator + fraction.denominator * numerator;
    }
    //add a fraction to current fraction
    public FancyFraction plus(FancyFraction fraction){
        return new FancyFraction(this.numerator * fraction.denominator + fraction.numerator * this.denominator,this.denominator * fraction.denominator + fraction.denominator * this.numerator);
    }
    //subtract a fraction from current fraction
    public FancyFraction minus(FancyFraction fraction){
        return new FancyFraction(this.numerator * fraction.denominator - fraction.numerator * this.denominator,this.denominator * fraction.denominator - fraction.denominator * this.numerator);
    }
    //return the product of this fraction and another fraction
    public FancyFraction times(FancyFraction fraction){
        return new FancyFraction(this.numerator * fraction.numerator, this.denominator * fraction.denominator);
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

    public boolean equals(FancyFraction other) {
        this.reduce();
        other.reduce();
        return (this.numerator == other.numerator) && (this.denominator == other.denominator);
    }
}