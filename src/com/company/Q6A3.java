package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Ben Lemke
Fancy Circles
Implements a FancyCircle class that is used to manipulate and represent circles 
01/04/2019
 */
public class Q6A3 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        boolean another = true;
        // loop until the user doesn't want to do more
        while (another) {
            //ask whether to use specs from question
            System.out.println("use defaults?");
            double x1;
            double x2;
            double y1;
            double y2;
            double r1;
            double r2;

            if ("yes".equals(br.readLine())) {
                x1 = 2;
                y1 = 3;
                r1 = 1;
            } else {
                // get the coordinates and radii
                System.out.println("x1");
                x1 = Integer.parseInt(br.readLine());
                System.out.println("y1");
                y1 = Integer.parseInt(br.readLine());
                System.out.println("r1");
                r1 = Integer.parseInt(br.readLine());
            }

            //create the circles and do the operations
            FancyCircle c1 = new FancyCircle(x1, y1, r1);
            FancyCircle c2 = c1;
            FancyCircle c3 = new FancyCircle(c1.centerX,c1.centerY,c1.radius);
            System.out.println("Are c1 and c2 the same " + c1.equals(c2));
            System.out.println("Are c1 and c3 the same " + c1.equals(c3));
            System.out.println(c1.toString());



            // ask user whether or not to do it again
            another = (!br.readLine().equals("quit"));
        }
    }
}

// Class for circles
class FancyCircle {
    double centerX;
    double centerY;
    double radius;
    double centerDist;

    // Constructor Method, sets the characteristics of the circle
    FancyCircle(double x, double y, double r){
        centerX = x;
        centerY = y;
        radius = r;
        centerDist = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    // Returns as a double value the area of the circle in units ^ 2
    public double area(){
        return (3.14159 * Math.pow(radius,2));
    }

    // Return a circle that is the smaller of the implicit circle and the parameter
    public FancyCircle smaller(FancyCircle circle){
        if (this.radius <= circle.radius){
            return this;
        }
        else{
            return circle;
        }
    }
    // Returns true if implicit circle is contained within parameter circle, otherwise false
    public boolean isInside(FancyCircle circle){
        return Math.sqrt(Math.pow((this.centerX - circle.centerX),2) + Math.pow((this.centerY - circle.centerY),2)) + this.radius < circle.radius;
    }
    // Convert the field values to a string
    public String toString(){
        return "Center: (" + this.centerX + "," + this.centerY + ") Radius: " + this.radius;
    }
    // Return whether two circles point the the same place in memory
    public boolean equals(FancyCircle other){
        return this == other;
    }

}
