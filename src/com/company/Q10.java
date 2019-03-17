package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10 {
    public static void main(String[] args) throws IOException {
        String [][] map = {{"I", "1"},
                {"V", "5"},
                {"X","10"},
                {"L", "50"},
                {"C", "100"},
                {"D", "500"},
                {"M", "1000"}};
        // setup inputs
        InputStreamReader reader = new InputStreamReader (System.in);
        BufferedReader br = new BufferedReader (reader);
        String romanNum = "";

        while(!romanNum.equals("quit")) {
            romanNum = br.readLine();
            int[] digits = new int[romanNum.length()];
            // loop through each character and make a list of numeric digits
            for (int i = 0; i < romanNum.length(); i++) {
                for (int j = 0; j < map.length; j++) {
                    if (String.valueOf(romanNum.charAt(i)).equals(map[j][0])) {
                        digits[i] = Integer.parseInt(map[j][1]);
                        break;
                    }
                }
            }

            int arabicNum = 0;
            // Loop through each digit and add or subtract it based on the next one
            for (int i = 0; i < digits.length - 1; i++) {
                // check if it's bigger or smaller than the next one
                if (digits[i] < digits[i + 1]) {
                    arabicNum -= digits[i];
                } else {
                    arabicNum += digits[i];
                }
            }
            // add the last digit
            arabicNum += digits[digits.length - 1];

            //output the arabic number
            System.out.println(arabicNum);
        }



    }
}
