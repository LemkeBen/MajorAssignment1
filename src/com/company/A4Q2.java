package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;


public class A4Q2 {
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
                x1 = 1;
                y1 = 2;
                r1 = 4;
                x2 = -2;
                y2 = 0;
                r2 = 2;
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
            Circle c1 = new Circle(x1,y1,r1);
            Circle c2 = new Circle(x2,y2,r2);
            System.out.println("c1 center dist" + c1.centerDist);
            double centerSeparation = sqrt(pow((c1.centerX - c2.centerX),2) + pow((c1.centerY - c2.centerY),2));
            System.out.println("center separation" + centerSeparation);
            double minDist = min(abs(centerSeparation - (c1.radius + c2.radius)),0);
            System.out.println("minimun distance" + minDist);

            // ask user whether or not to do it again
            another = (!br.readLine().equals("quit"));
        }
    }
}

class Circle{
    double centerX;
    double centerY;
    double radius;
    double centerDist;
    Circle(double x, double y, double r){
        centerX = x;
        centerY = y;
        radius = r;
        centerDist = sqrt(pow(x,2) + pow(y,2));
    }
}
