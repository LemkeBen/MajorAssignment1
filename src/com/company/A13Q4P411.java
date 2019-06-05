package com.company;

import java.io.IOException;
/*
Ben Lemke
Selection Sorting
Use a selection sort to sort an array of doubles from smallest to largest
05/06/2019
 */
public class A13Q4P411 {
    public static void main(String[]args) throws IOException {
        // make an array of double and sort it
        double[] sorted = selectSort(new double[]{3, 5, 23, 243, 345, 345, 23, 23, 345, 65, 24, 1.5, 5.5, 4.5, 20.0});

        // Output the sorted array
        for (int i = 0; i < sorted.length; i++){
            System.out.print(sorted[i] + ", ");
        }
    }

    /**
     * @param list the array to be sorted
     * @return the sorted array
     */
    public static double[] selectSort (double[] list)
    {
        for (int bottom = 0; bottom < list.length - 1; bottom++)
        {
            // Outputs the current array
            for (int i = 0; i < list.length; i++){
                System.out.print(list[i] + ", ");
            }
            System.out.println();

            int bottomLoc = list.length - 1;
            for (int i = list.length - 1; i >= bottom; i--)
                if (list[i] < list[bottomLoc])
                    bottomLoc = i;
            double temp = list[bottom];
            list[bottom] = list[bottomLoc];
            list[bottomLoc] = temp;
        }
        return list; // Returns the fully sorted array
    }
}
