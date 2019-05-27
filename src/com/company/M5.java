package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/*
Ben Lemke
Triangles from files
Uses a file input desired perimeters and outputs the largest possible areas
21/05/2019
 */

public class M5 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader ("C:\\Users\\ben_l\\Desktop\\nums.txt");
        BufferedReader br = new BufferedReader (fr);
        //use to store one line at a time from file
        String line = null;


        //read from buffer by using readline method, it returns "null" at the end of file
        while ((line = br.readLine ()) != null)
        {
            largestArea(Integer.parseInt(line)); // call a function to output the largest area
        }

        //close buffer
        br.close ();
    }

    // function to output the largest area possible given a perrimeter
    private static void largestArea(int perimeter){
        double s = perimeter / 2.0;
        int largestestArea = -1;
        int[] sides = new int[3];
        // loop through all possible sets of sides and see what has the biggest area
        for (int a = 1; a < perimeter - 2; a++){
            for (int b = 1; b < perimeter - a - 1; b++){
                int c = perimeter - a - b;
                double calcedArea = Math.sqrt(s*(s-a) * (s-b )* (s-c));
                if (calcedArea % 1 == 0.0 && calcedArea > largestestArea){
                    largestestArea = (int) calcedArea;
                    sides[0] = a;
                    sides[1] = b;
                    sides[2] = c;
                }
            }
        }
        // ourput that there are none if none were found
        if (largestestArea == -1) {
            System.out.println("There are no possible integer triangles with the perimeter " + perimeter);
        }
        // output message indicating option with largest possible area
        else{
            System.out.print("Sides: ");
            for (int i = 0; i < 3; i++){
                System.out.print(sides[i] + ", ");
            }
            System.out.println("Yeild the largest area: " + largestestArea);
        }
    }
}
