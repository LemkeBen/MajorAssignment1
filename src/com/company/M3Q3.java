package com.company;
/*
Ben Lemke
Floor Tiles
Finds optimal tiling options given room dimensions
27/04/2019
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class M3Q3 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        boolean another = true;
        // loop until the user doesn't want to do more
        while (another) {
            int l;
            int w;

            //ask what dimensions to use
            System.out.println("l");
            l = Integer.parseInt(br.readLine());
            System.out.println("w");
            w = Integer.parseInt(br.readLine());

            // make possible room orientations
            Room [] rooms = new Room [5];
            rooms[0] = new Room(1,1, w,l);
            rooms[1] = new Room(1,2, w,l);
            rooms[2] = new Room(2,1, w,l);
            rooms[3] = new Room(2,3, w,l);
            rooms[4] = new Room(3,2, w,l);

            // find which one has the least tiles
            int lowest = rooms[0].tilecount;
            int lowestindex = 0;
            for (int i = 0; i < rooms.length; i++){
                if (rooms[i].tileUsed != null){
                    if (rooms[i].tilecount < lowest){
                        lowest = rooms[i].tilecount;
                        lowestindex = i;
                    }
                }
            }

            // output the best option
            System.out.println(rooms[lowestindex]);

            // ask user whether or not to do it again
            System.out.println("again?");
            another = (!br.readLine().equals("quit"));
        }

    }
}

// class for tiles
class Tile{
    int width;
    int length;
    // constructor method
    Tile(int width, int length){
        this.length = length;
        this.width = width;
    }
    // returns the area that the tile takes up
    int getArea(){
        return this.width * this.length;
    }
}

// class for rooms
class Room{
    int width;
    int length;
    int tileWidthRatio;
    int tileLengthRatio;
    int tilecount;
    int tileScaleFactor;
    Tile tileUsed;

    // constructor method
    Room(int tileWidthRatio, int tileLengthRatio, int width, int length){
        this.tileWidthRatio = tileWidthRatio;
        this.tileLengthRatio = tileLengthRatio;
        this.width = width;
        this.length = length;
        // normal case when all tiles share an orientation
        if (this.width % tileWidthRatio == 0 && this.length % tileLengthRatio == 0 ){
            tileScaleFactor = gcd(this.width / tileWidthRatio, this.length / tileLengthRatio);
            tileUsed = new Tile(tileScaleFactor * this.tileWidthRatio, tileScaleFactor * this.tileLengthRatio);
            tilecount = (this.width * this.length) / tileUsed.getArea();
        }
        // Special case
        else if(this.width >= 5 && this.length % 6 == 0 && ((tileWidthRatio == 2 && tileLengthRatio == 3) || (tileWidthRatio == 3 && tileLengthRatio == 2))){
            //// If it's actually non-special case skip//
            if (this.width % (this.length / 3 * 2) == 0){
                tileScaleFactor = this.length / 3;
            }
            else if (this.length % (this.width / 2 * 3) == 0) {
                tileScaleFactor = this.length / 2;
            }
            /////////////////////////////////////////////    //This could just be added to the boolean logic but that would be hard to understand
            else{ // Special case
                boolean failed = true;
                for (int i = this.length - 3; i >= 3; i-= 3){
                    int possibleScaleFactor = i / 3;
                    System.out.println("possible scale factor: " + possibleScaleFactor + " width: " + width);
                    if (width % possibleScaleFactor == 0 && width >= possibleScaleFactor * 2 && length % possibleScaleFactor * 6 == 0){
                        tileScaleFactor = possibleScaleFactor;
                        failed = false;
                        System.out.println(tileScaleFactor);
                        break;
                    }
                }
                if (failed) {
                    tileScaleFactor = 1;
                    System.out.println("Special Case Failure");
                }

                tileUsed = new Tile(tileScaleFactor * this.tileWidthRatio, tileScaleFactor * this.tileLengthRatio);
                tilecount = (this.width * this.length) / tileUsed.getArea();
            }
        }
        // catchcase for when there are no configs
        else{
            tilecount = -1;
        }
    }

    // convert to a string for outputting
    public String toString() {
        return ("For a " + width + " x " + length + " room use " + tilecount + " " + this.tileUsed.width + " x " + this.tileUsed.length + " tiles");
    }

    // algorithm for finding greatest common divisors
    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}