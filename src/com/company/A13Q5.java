package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Ben Lemke
Median Averages
Find the median average of an array of doubles
05/06/2019
 */
public class A13Q5 {
    public static void main(String[]args) throws IOException {
        int length = Integer.parseInt(get("How long should the array be?")); // Get the length of the array
        // initialize the array and get all the values
        double[] nums = new double[length];
        for (int i = 0; i < length; i++){
            nums[i] = Double.parseDouble(get("number: "));
        }

        nums = insertSort(nums); // Sort the array

        // Output the average
        if(length % 2 == 1){ // If the length is odd print the value in the middle
            System.out.println(nums[length / 2]);
        }
        else { // If the length is odd print the average of the two middle values
            System.out.println((nums[(int) (length / 2.0 - 0.5)] + nums[(int) (length / 2.0 + 0.5)])/2);
        }
    }

    // Copied method for insertSort
    public static double[] insertSort (double[] list)
    {
        for (int top = 1; top < list.length; top++)
        {
            double item = list[top];
            int i = top;
            while (i > 0 && item < list[i-1])
            {
                list[i] = list[i-1];
                i--;
            }
            list[i] = item;
        }
        return list;
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
