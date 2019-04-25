package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/*
Ben Lemke
Generating Primes
Implements a method for outputing primes
25/04/2019
 */

public class A8Q11 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        boolean another = true;
        
        // loop until the user doesn't want to do more
        while (another) {
            System.out.println("how high d'you want to count?");
            int nums = Integer.parseInt((br.readLine()));
            // create array of booleans representing if a number may be prime
            boolean[] primeMods = new boolean[nums];
            for (int i = 0; i < nums; i++) {
                primeMods[i] = true;
            }
            int curIndex = 1;
            int numPrimes = 0;
            // loop through the set of numbers
            while (curIndex < nums) {
                // if a number is prime all numbers divisable by it are not prime
                if (primeMods[curIndex]) {
                    numPrimes++;
                    for (int i = curIndex + 1; i < nums; i++) {
                        if (((i + 1) * 1.0 / (curIndex + 1)) % 1 == 0) {
                            primeMods[i] = false;
                        }
                    }
                }
                curIndex++;
            }
            // use the boolean array to generate an array of primes
            int[] primes = new int[numPrimes +1];
            int primesIndex = 0;
            for (int i = 0; i < nums; i++){
                if (primeMods[i]){
                    primes[primesIndex] = (i + 1);
                    primesIndex++;
                }
            }

            // print all the primes in the correct format
            for (int i = 0; i < primes.length; i++) {
                Out.print(primes[i],10);
                if ((i + 1) % 8 == 0){
                    System.out.println();
                }
            }
            // ask user whether or not to do it again
            System.out.println();
            System.out.println("Do it again?");
            another = (!br.readLine().equals("quit"));
        }
    }
}
// Copied class for printing stuff
class Out
{
    public static void println ()
    {
        System.out.println();
    }

    public static void print (double n, int fieldWidth, int decimalPlaces)
    {
        String format = "0.";
        for (int i = 0; i < decimalPlaces; i++)
            format = format + "0";
        NumberFormat form = new DecimalFormat(format);
        String s = form.format(n);
        int stop = fieldWidth - s.length();
        for (int i = 0; i < stop; i++)
            s = " " + s;
        System.out.print(s);
    }

    public static void println (double n, int fieldWidth, int decimalPlaces)
    {
        print(n, fieldWidth, decimalPlaces);
        System.out.println();
    }

    public static void printCurrency (double n, int fieldWidth, int decimalPlaces)
    {
        String format = "$0.";
        for (int i = 0; i < decimalPlaces; i++)
            format = format + "0";
        NumberFormat form = new DecimalFormat(format);
        String s = form.format(n);
        int stop = fieldWidth - s.length();
        for (int i = 0; i < stop; i++)
            s = " " + s;
        System.out.print(s);
    }

    public static void printlnCurrency (double n, int fieldWidth, int decimalPlaces)
    {
        printCurrency(n, fieldWidth, decimalPlaces);
        System.out.println();
    }

    public static void print (double n)
    {
        System.out.print(n);
    }

    public static void println (double n)
    {
        print(n);
        System.out.println();
    }

    public static void print (int n, int fieldWidth)
    {
        String s = String.valueOf(n);
        int stop = fieldWidth - s.length();
        for (int i = 0; i < stop; i++)
            s = " " + s;
        System.out.print(s);
    }

    public static void println (int n, int fieldWidth)
    {
        print(n, fieldWidth);
        System.out.println();
    }

    public static void print (long n)
    {
        System.out.print(n);
    }

    public static void println (long n)
    {
        print(n);
        System.out.println();
    }

    public static void print (String s, int fieldWidth)
    {
        int stop = fieldWidth - s.length();
        if (s.length() > fieldWidth)
            s = s.substring(0, fieldWidth);
        else
            for (int i = 0; i < stop; i++)
                s = " " + s;
        System.out.print(s);
    }

    public static void println (String s, int fieldWidth)
    {
        print(s, fieldWidth);
        System.out.println();
    }

    public static void print (String s)
    {
        System.out.print(s);
    }

    public static void println (String s)
    {
        System.out.println(s);
    }

    public static void print (char c, int fieldWidth)
    {
        String s = String.valueOf(c);
        int stop = fieldWidth - 1;
        for (int i = 0; i < stop; i++)
            s = " " + s;
        System.out.print(s);
    }

    public static void println (char c, int fieldWidth)
    {
        print(c, fieldWidth);
        System.out.println();
    }

    public static void print (char c)
    {
        System.out.print(c);
    }

    public static void println (char c)
    {
        System.out.println(c);
    }
}
