package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader (System.in);
        BufferedReader br = new BufferedReader (reader);

        String name = "";
        StringBuffer output;
        String [] names;
        while (!name.equals("ZZZ")){


            output = new StringBuffer("");
            names = name.split(" ");

            // add last name in full
            output.append(names[names.length - 1]);

            // loop through each name and add the letter and punctuation
            for (int i = 0; i < names.length - 1; i++) {
                //if it's the first name add a "," before it,
                if(i == 0) {
                    output.append(",");
                }
                output.append(String.valueOf(names[i].charAt(0)));
                output.append(".");
            }
            System.out.println(output.toString());

            // get next name in standard form
            name = br.readLine();



        }
    }
}
