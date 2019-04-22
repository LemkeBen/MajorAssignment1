package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;


public class A5Q4 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader (System.in);
        BufferedReader br = new BufferedReader (reader);
        boolean another = true;
        // loop until the user doesn't want to do more
        while (another){
            //ask whether to use specs from question
            System.out.println("use defaults?");
            double x1;
            double x2;
            double y1;
            double y2;
            double r1;
            double r2;

            if ("yes".equals(br.readLine())){
                x1 = 4;
                y1 = -1;
                r1 = 3;
                x2 = 3;
                y2 = -2;
                r2 = 5;
            }
            else {
                // get the coordinates and radii
                System.out.println("x1");
                x1 = Integer.parseInt(br.readLine());
                System.out.println("y1");
                y1 = Integer.parseInt(br.readLine());
                System.out.println("r1");
                r1 = Integer.parseInt(br.readLine());
                System.out.println("x2");
                x2 = Integer.parseInt(br.readLine());
                System.out.println("y2");
                y2 = Integer.parseInt(br.readLine());
                System.out.println("r2");
                r2 = Integer.parseInt(br.readLine());
            }

            //create the circles and do the operations
            FancyCircle c1 = new FancyCircle(x1,y1,r1);
            FancyCircle c2 = new FancyCircle(x2,y2,r2);
            System.out.println("c1 area");
            System.out.println(c1.area());
            System.out.println("smaller center and radius");
            System.out.println(c1.smaller(c2).toString());
            if (c2.isInside(c1)){
                System.out.println("C2 is in C1");
            }
            else{
                System.out.println("C2 is not in C1");
            }

            // ask user whether or not to do it again
            another = (!br.readLine().equals("quit"));
        }
    }
}
/*
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
        centerDist = sqrt(pow(x,2) + pow(y,2));
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

    public String toSting(){
        return "(" + this.centerX + "," + this.centerY + ") R:" + this.radius;
    }

}
*/