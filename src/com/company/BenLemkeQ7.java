package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BenLemkeQ7
{
    public static void main (String[] args)
    {
        // setup inputs
        InputStreamReader reader = new InputStreamReader (System.in);
        BufferedReader br = new BufferedReader (reader);

        String word;
        StringBuffer pal = new StringBuffer ("");
        int fromFront = 0;
        int fromBack = 0;
        // get a word from the user
        try
        {
            System.out.println ("Word:");
            word = br.readLine ();
        }
        catch (IOException e)
        {
            word = "";
            e.printStackTrace ();
        }
        // if it's a palindrome, output that
        if (isPalindrome (word))
        {
            System.out.println (word);
        }
        // otherwise find the smallest palindrome
        else
        {
            // Loop through each index in the word and see if the first that many characters from a palindrome
            for (int i = 0 ; i < word.length () ; i++)
            {
                if (isPalindrome (word.substring (0, i)))
                {
                    fromFront = i;
                }
            }

            // Loop through each index in the word and see if the last that many cahracters from a palindrome
            for (int i = 0 ; i < word.length () ; i++)
            {
                if (isPalindrome (word.substring (word.length () - i, word.length ())))
                {
                    fromBack = i;
                }
            }

            String subPal;
            StringBuffer nonPal = new StringBuffer ("");

            // make a palindrome around the longest subpalindrome (whether front or back)
            if (fromFront >= fromBack)
            {
                subPal = word.substring (0, fromFront);
                nonPal.append (word.substring (fromFront, word.length ()));
                pal.append (nonPal.toString ());
                pal.reverse ();
                pal.append (subPal);
                pal.append (nonPal.toString ());
                System.out.println (pal.toString ());
            }
            else
            {
                nonPal.append (word.substring (0, word.length () - fromBack));
                subPal = word.substring (word.length () - fromBack, word.length ());
                pal.append (nonPal.toString ());
                pal.append (subPal);
                pal.append (nonPal.reverse ().toString ());
                System.out.println (pal.toString ());

                subPal = word.substring (word.length () - fromBack, word.length ());
            }
        }
    }

    // determine if a word is a palindrome
    public static boolean isPalindrome (String word)
    {
        StringBuffer backword = new StringBuffer ("");
        // loop through each character backwards and make a backwards version of the string
        for (int i = 0 ; i < word.length () ; i++)
        {
            backword.append (word.charAt (word.length () - i - 1));
        }
        // return if the string is equal to the string backwards
        return (word.equals (backword.toString ()));
    }
}
