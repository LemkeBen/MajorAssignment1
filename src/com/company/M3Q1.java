package com.company;

/*
Ben Lemke
Pretty Pictures
Uses arrays to add mats and frames to pictures
27/04/2019
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class M3Q1 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        boolean another = true;
        // loop until the user doesn't want to do more
        while (another) {
            int m;
            int n;
            int p;
            int q;

            //ask whether to use specs from question
            System.out.println("use defaults?");

            if ("yes".equals(br.readLine())) {
                m = 4;
                n = 3;
                p = 2;
                q = 1;
            } else {
                // get the lengths and widths
                System.out.println("m");
                m = Integer.parseInt(br.readLine());
                System.out.println("n");
                n = Integer.parseInt(br.readLine());
                System.out.println("p");
                p = Integer.parseInt(br.readLine());
                System.out.println("q");
                q = Integer.parseInt(br.readLine());
            }

            // Create an array of dots
            char [] [] image = new char[m + 2 * p + 2 * q][n + 2 * q + 2 * p];
            System.out.println(image.length);
            for (int i = 0; i < image.length; i++){
                for (int x = 0; x < image[i].length; x++){
                    image[i][x] = '.';
                }
            }

            // Make the frame
            for (int i = 0; i < p; i++){ // Loop through each layer of framage
                for (int x = i; x < image[i].length - i; x++){ // Loops through the first line and sets the characters
                    image[i][x] = '#';
                }
                for (int x = i; x < image.length - i; x++){ // Loops through the middle lines and sets the first and last characters
                    image[x][i] = '#';
                    image[x][image[x].length - i - 1] = '#';
                }
                for (int x = i; x < image[i].length - i; x++){ // Loop through the last line and sets all the characters
                    image[image.length - i - 1][x] = '#';
                }
            }
            // Make the mat
            for (int i = p; i < p + q; i++){
                for (int x = i; x < image[i].length - i; x++){// Loops through the first line and sets the characters
                    image[i][x] = '+';
                }
                for (int x = i; x < image.length - i; x++){// Loops through the middle lines and sets the first and last characters
                    image[x][i] = '+';
                    image[x][image[x].length - i - 1] = '+';
                }
                for (int x = i; x < image[i].length - i; x++){// Loop through the last line and sets all the characters
                    image[image.length - i - 1][x] = '+';
                }
            }

            // Output the image
            for (int i = 0; i < image.length; i ++){
                for (int x = 0; x < image[i].length; x ++){
                    System.out.print(image[i][x]);
                }
                System.out.println();
            }

            // ask user whether or not to do it again
            System.out.println("again?");
            another = (!br.readLine().equals("quit"));
        }
    }
}
