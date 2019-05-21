package com.company;

import java.io.*;

public class A10Q1and2 {
    public static void main(String[] args) throws IOException {
        // setup inputs and outputs
        FileWriter fw = new FileWriter ("C:\\Users\\ben_l\\Desktop\\name_address.txt");
        FileReader fr = new FileReader ("C:\\Users\\ben_l\\Desktop\\name_address.txt");
        PrintWriter pw = new PrintWriter (fw);
        BufferedReader br = new BufferedReader (fr);

        // Counter to count to 4
        int counter = 0;

        // Parallel lists to store info
        String[] names = new String[4];
        String[] addresses = new String[4];
        String[] cities = new String[4];
        String[] phoneNumbers = new String[4];

        // loop 4 times
        while (counter < 4) {
            // get the specs
            names[counter] = get("name");
            addresses[counter] = get("address");
            cities[counter] = get("city");
            phoneNumbers[counter] = get("phone number");

            // Count the counter
            counter ++;
        }

        // Write the info to a file
        // File convention is that each line is a new datapoint and four lines is one person
        for (int i = 0; i < 4; i++){
            pw.println(names[i]);
            pw.println(addresses[i]);
            pw.println(cities[i]);
            pw.println(phoneNumbers[i]);
        }
        pw.close();

        String line = null;
        int typeCounter = 0;
        //read from buffer by using readline method, it returns "null" at the end of file
        while ((line = br.readLine ()) != null) {
            // Ouput the datapoint
            if (typeCounter %4  == 0){
                System.out.println("Name:");
            }
            if (typeCounter %4 == 1){
                System.out.println("Address:");
            }
            if (typeCounter %4 == 2){
                System.out.println("City:");
            }
            if (typeCounter %4 == 3){
                System.out.println("Phone Number:");
            }
            System.out.println("-----");
            System.out.println(line);
            System.out.println();
            typeCounter ++;
        }

        //close buffer
        br.close ();
    }
    static String get(String message) throws IOException {
        // setup inputs and outputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        System.out.println(message);
        return br.readLine();
    }

    static String get() throws IOException {
        //setup inputs and outputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        return br.readLine();
    }
}
