package com.company;

import java.io.*;
/*
Ben Lemke
Markbook 2.0
Uses a file to manage the marks of students
21/05/2019
 */
public class A10Q3and4 {
    public static void main(String[] args) throws IOException {
        // setup inputs and outputs
        FileWriter fw = new FileWriter ("C:\\Users\\ben_l\\Desktop\\marks.txt");
        FileReader fr = new FileReader ("C:\\Users\\ben_l\\Desktop\\marks.txt");
        PrintWriter pw = new PrintWriter (fw);
        BufferedReader br = new BufferedReader (fr);

        // Counter to count to 4
        int counter = 0;

        String[] names = new String[4];
        int [][] marks = new int[4][4]; // First layer is students second layer assignments

        // loop 4 times
        while (counter < 4) {
            // get the specs
            names[counter] = get("name");
            for (int i = 0; i < 4; i++){
                marks[counter] [i] = Integer.parseInt(get(names[counter] + "'s mark on assignment" + (i + 1)));
            }
            // Count the counter
            counter ++;
        }

        // Write the info to a file
        // File convention is that each line is a new datapoint and four lines is one person
        for (int i = 0; i < 4; i++){
            pw.println(names[i]);
            for (int x = 0; x < 4; x++){
                pw.println(marks[i][x]);
            }
        }
        pw.close();

        counter = 0;
        // loop 4 times
        while (counter < 4) {
            // get the specs
            names[counter] = br.readLine();
            for (int i = 0; i < 4; i++){
                marks[counter] [i] = Integer.parseInt(br.readLine());
            }
            // Count the counter
            counter ++;
        }

        br.close();

        double[] overallAverages = new double[5];
        double[] assignmetnAverages = new double[4];

        // Loop through assignments and individuals to determine their respective average marks
        for (int i = 0; i < 4; i++){
            assignmetnAverages[i] = (marks[0][i] + marks[1][i] + marks[2][i] + marks[3][i]) / 4.0;
            overallAverages[i] = (marks[i][0] + marks[i][1] + marks[i][2] + marks[i][3]) / 4.0;
        }
        overallAverages[4] = (overallAverages[0] + overallAverages[1] + overallAverages[2] + overallAverages[3]) / 4;

        // Loop through students and print the marks
        for (int s = 0; s < 4; s++){
            System.out.print(format("Student's name"));
            System.out.print(format("Test 1"));
            System.out.print(format("Test 2"));
            System.out.print(format("Test 3"));
            System.out.print(format("Test 4"));
            System.out.println(format("Average"));
            System.out.print("------------------- ");
            System.out.print("------------------- ");
            System.out.print("------------------- ");
            System.out.print("------------------- ");
            System.out.print("------------------- ");
            System.out.println("------------------- ");
            System.out.print(format(names[s]));
            for (int i = 0; i < 4; i++){
                System.out.print(format(String.valueOf(marks[s][i])));
            }
            System.out.println(overallAverages[s]);
            System.out.print(format("Test averages"));
            for (int i = 0; i < 4; i++){
                System.out.print(format(String.valueOf(assignmetnAverages[i])));
            }
            System.out.println();
            System.out.println();
        }

    }

    // Method to format messages so that the output looks like a nice table
    static String format(String message){
        StringBuffer output = new StringBuffer();
        output.append(message);
        for (int i = 0; i < 20 - message.length(); i++){
            output.append(" ");
        }
        return output.toString();
    }

    // prevent having to type sout etc. all the time
    static String get(String message) throws IOException {
        // setup inputs and outputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        System.out.println(message);
        return br.readLine();
    }

    // prevent having to type sout etc. all the time
    static String get() throws IOException {
        //setup inputs and outputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        return br.readLine();
    }
}
