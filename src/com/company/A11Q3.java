package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
Ben Lemke
Odd searching
Practice basic searching and swapping elements in a list
29/05/2019
 */

public class A11Q3 {
    public static void main(String[] args) throws IOException {
        // get a list from the user
        int[] list = new int[Integer.parseInt(get("how many elements should be in the list?"))];
        for (int i = 0; i < list.length; i ++){
            list[i] = Integer.parseInt(get("number: "));
        }
        // get a number from the user and print the result of the search and swap
        System.out.println(Arrays.toString(modifiedSearch(list, Integer.parseInt(get("number to search for: ")))));

    }
    // search an array for a  number and swap it with the previous number
    private static int[] modifiedSearch(int[] originalArray, int value){
        // loop through each index of the array
        for (int i = 0; i < originalArray.length; i++){
            // if the index matches the numeric input, swap it with the previous one
            if (originalArray[i] == value && i > 0){
                int previous = originalArray[i-1];
                originalArray[i-1] = originalArray[i];
                originalArray[i] = previous;
            }
        }
        return originalArray;
    }

    // prevent having to type sout etc. all the time
    static String get(String message) throws IOException {
        // setup inputs and outputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        System.out.println(message);
        return br.readLine();
    }
}
