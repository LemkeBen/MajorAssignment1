package com.company;
/*
Ben Lemke
Binary searching
Implement a searching method from JohnCarter Java modified to search backwards and return the closest index
04/06/2019
 */
public class BinSearch {
    public static void main(String[] args) {
        // Array to search
        double[] array = {1,3,5,8,10,15,16,17,17,18,19,20};

        // Backwards version of the array
        double[] backArray = new double[array.length];
        for (int i = 0; i < array.length; i++){
            backArray[i] = array[array.length - 1 - i];
        }

        // search for the numbers -1 to 21 in the array and print the nearest index
        for (int i = -1; i < 21; i++){
            System.out.println(i + ": " + binSearch(array, i));
        }

        // search for the numbers -1 to 21 in the backwards array and print the nearest index
        for (int i = 0; i < backArray.length; i++){
            System.out.println(i + ": " + backBinSearch(backArray, i));
        }
    }

    // Search an array that is sorted from smallest to largest
    public static int binSearch(double[] list, double item) {
        int bottom = 0; // lower bound of subarray
        int top = list.length - 1; // upper bound of subarray
        int middle = (bottom + top) / 2; // middle of subarray
        boolean found = false; // to stop if item found
        while (bottom <= top && !found) {
            middle = (bottom + top) / 2;
            if (list[middle] == item) // success
            {
                found = true;
            } else if (list[middle] < item){ // not in bottom half
                if (middle == list.length - 1) { // no more indexes to search
                    break;
                }
                bottom = middle + 1;
            }
            else{ // item cannot be in top half
                if (middle == 0) {// no more indexes to search
                    break;
                }
                top = middle - 1;
            }
        }

        // Create an array of the distances between the possible values and the item to search for
        double[] distances = new double[3];
        distances[2] = Math.abs(list[top] - item);
        distances[1] = Math.abs(list[middle] - item);
        distances[0] = Math.abs(list[bottom] - item);

        // find the closest value and return the lowest index with that value
        double min = Math.min(Math.min(distances[0],distances[1]),distances[2]);
        if (min == distances[2]){
            return top;
        }
        else if(min == distances[1]){
            return middle;
        }
        else{
            return bottom;
        }
    }

    public static int backBinSearch(double[] list, double item) {
        int bottom = 0; // lower bound of subarray
        int top = list.length - 1; // upper bound of subarray
        int middle = (bottom + top) / 2; // middle of subarray
        boolean found = false; // to stop if item found
        while (bottom <= top && !found) {
            middle = (bottom + top) / 2;
            if (list[middle] == item) // success
            {
                found = true;
            } else if (list[middle] > item) { // not in bottom half
                if (middle == list.length - 1) {// no more indexes to search
                    break;
                }
                bottom = middle + 1;
            }
            else{ // item cannot be in top half
                if (middle == 0){// no more indexes to search
                    break;
                }
                top = middle - 1;
            }
        }

        // Create an array of the distances between the possible values and the item to search for
        double[] distances = new double[3];
        distances[2] = Math.abs(list[top] - item);
        distances[1] = Math.abs(list[middle] - item);
        distances[0] = Math.abs(list[bottom] - item);

        // find the closest value and return the lowest index with that value
        double min = Math.min(Math.min(distances[0],distances[1]),distances[2]);
        if (min == distances[2]){
            return top;
        }
        else if(min == distances[1]){
            return middle;
        }
        else{
            return bottom;
        }
    }
}
