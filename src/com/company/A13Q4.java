package com.company;

public class A13Q4 {
    public static void main(String[]args) {
        String[] array = {"Mercury", "Venus", "Earth","Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"}; // List of planets by distance from the sun
        String[] sortedArray = insertSort(array); // gets a list of planets sorted alphabetically
        // output the list of planets that is sorted alphabetically
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + ", ");
        }
    }

    // Modified method for sorting alphabetically
    public static String[] insertSort (String[] list)
    {
        for (int top = 1; top < list.length; top++)
        {
            // outputs the current array
            for (int i = 0; i < list.length; i++){
                System.out.print(list[i]+ ", ");
            }
            System.out.println();

            // puts the item at index top where it belongs ignoring the items after it
            String item = list[top];
            int i = top;
            while (i > 0 && isAlphabeticallyHigher(item , list[i-1])){ // modified using isAlphabeticallyHigher to determine whether the string belongs before or after in the list
                list[i] = list[i-1];
                i--;
            }
            list[i] = item;
        }
        return list;
    }


    /**
     * @param s1 A string to compare
     * @param s2 A string to compare
     * @return true whether s1 is alphabetically previous to s2 (AAAA is previous to ZZZZ)
     */
    public static boolean isAlphabeticallyHigher(String s1, String s2){
        int index = 0;
        // Loops until it is determined which is alphabetically previous
        while(index < s1.length() && index < s2.length()){
            // Compare the characters in the array at the current index and if they are different return whether or not the s1 is alphabetically previous
            if (Character.getNumericValue(s1.charAt(index)) < Character.getNumericValue(s2.charAt(index))){
                return true;
            }
            else if(Character.getNumericValue(s1.charAt(index)) > Character.getNumericValue(s2.charAt(index))){
                return false;
            }
            else{
                index ++; // Go to the next index
                // If one string is out of indexes check it's last character with the following characters of the other string
                if(index == s1.length()){
                    int lastCharsVal = Character.getNumericValue(s1.charAt(index - 1)); // the last character
                    // Compare to the rest of the other string
                    while(index < s2.length()){
                        if(lastCharsVal < Character.getNumericValue(s2.charAt(index))){
                            return true;
                        }
                        else if (lastCharsVal > Character.getNumericValue(s2.charAt(index))){
                            return false;
                        }
                        else{
                            index++;
                        }
                    }
                }
                else if (index == s2.length()){
                    int lastCharsVal = Character.getNumericValue(s2.charAt(index - 1)); // the last character
                    // Compare to the rest of the other string
                    while(index < s1.length()){
                        if(lastCharsVal < Character.getNumericValue(s1.charAt(index))){
                            return true;
                        }
                        else if(lastCharsVal > Character.getNumericValue(s1.charAt(index))){
                            return false;
                        }
                        else{
                            index++;
                        }
                    }
                }
            }
        }
        // If one of the strings has 0 length, return true
        return true;
    }
}
