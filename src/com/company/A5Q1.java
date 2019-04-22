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
            f1.plusEquals(new FancyFraction(6,7));
            f1 = f1.plus(new FancyFraction(3,5));
            f1.reduce();
            // print the fractions
            System.out.println(f1.getString());
            // ask the user whether or not to continue
            another = (!br.readLine().equals("quit"));
        }
    }
}
