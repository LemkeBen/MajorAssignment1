package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Ben Lemke
Efficient searching
develop an efficient method for searching alphabetically organized arrays
02/06/2019
 */
public class A11Q2 {
    public static void main(String[] args) throws IOException {
        // make a list
        String[] list = { "Adrian", "Aidan", "Ben", "Charlie","Chuck","David","Delia","Ellen","Emanuel","Finn","Fin","George","Genevieve","Henry","Harvard","Isabelle","Isabella","Jessica","James","Juliam","Kassie","Kenneth","Lucas","Lillian","Marcus","Marco","Noah","Navin","Orran","Octavious","Patricia","Patric","Quinton","Quan","Robbin","Rajaprabakaran","Sam","Susan","Troy","Tenugen","Utilla","Udilia","Vedin","Vaqueres","Wang","Wong","Yu","Yue","Zev","Zack","Zackaria"};

        // loop until the user wants to quit
        String another = "";
        while(!another.equals("quit")){
            // get a name and print it's index
            System.out.println("index: " + unSequentialSearch(list, get("name to search for")));
            // ask user if they want to do another name
            another = get("Another?");
        }

    }
    // search an array for a  number and swap it with the previous number
    private static int unSequentialSearch(String[] sortedArray, String value){
        // Approximate where in the alphabetical array the name will be
        double approximateAlphabeticalIndex = ((Character.getNumericValue(value.charAt(0)) - 10.0) / 25.0);
        double startIndexDouble = approximateAlphabeticalIndex * (sortedArray.length- 1);
        int startIndex = (int) (startIndexDouble - (startIndexDouble % 1));
        // Loop through possible matches from most to lease likely
        // Starting at most likely index then checking either side
        int counter = 0;
        while(true){
            // if a match is found, return the index of the match
            if(sortedArray[startIndex + counter].equals(value)){
                return startIndex + counter;
            }
            else if(sortedArray[startIndex - counter].equals(value)){
                return startIndex - counter;
            }
            else{
                counter ++;
                // when one end of the array is reached only check the other end
                if (startIndex - counter < 0){
                    for (int i = counter + startIndex; i < sortedArray.length; i++){
                        if(sortedArray[i].equals(value)){
                            return i;
                        }
                    }
                    return -1;
                }
                else if (startIndex + counter > sortedArray.length - 1){
                    for(int i = startIndex - counter; i > 0; i --){
                        if(sortedArray[i].equals(value))
                            return i;
                    }
                    return -1;
                }
            }
        }
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
