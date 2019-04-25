package com.company;

import java.io.IOException;

public class A8Q3 {
    public static void main(String[] args)throws IOException{
        UnfancyFraction[] fracList = new UnfancyFraction[100];
        for (int i = 0; i < 100; i++){
            fracList[i] = new UnfancyFraction(i,i+1);
        }
        for (int i = 0; i<100; i++){
            System.out.println(fracList[i]);
        }

    }
}
// class for fractions
class UnfancyFraction {
    //fractions have numerators and denominators
    private int numerator;
    private int denominator;

    //fraction constructor setting the numerator and the denominator
    public UnfancyFraction(int n, int d) {
        numerator = n;
        denominator = d;
    }

    @Override
    public String toString() {
        return (numerator + " / " + denominator);
    }
}
