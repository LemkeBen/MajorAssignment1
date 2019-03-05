package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String input = "";
        while(!"quit".equals(input)){
            input = br.readLine();
            System.out.println(isPalindrome(input));
        }
    }


    private static boolean isPalindrome(String word) {
        String[] ignores = {".",",",":",";"," ","!","'", String.valueOf('"'),"?", " "};
        StringBuffer pal = new StringBuffer(word.toLowerCase());
        StringBuffer newpal = new StringBuffer();
        for (int c = 0; c < pal.length(); c++){
            String letter = String.valueOf(pal.charAt(c));
            boolean isUsed = true;
            for (int i = 0; i < ignores.length; i++) {
                String ignore = ignores[i];
                if (letter.equals(ignore)) {
                    isUsed = false;
                }
            }
            if (isUsed){
                newpal.append(letter);
            }
        }


        StringBuffer backword = new StringBuffer("");
        // loop through each character backwards and make a backwards version of the string
        for (int i = 0; i < newpal.length(); i++) {
            backword.append(newpal.charAt(newpal.length() - i - 1));
        }
        // return if the string is equal to the string backwards
        return (newpal.toString().equals(backword.toString()));
    }
}