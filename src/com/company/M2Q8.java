package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.min;
import static java.lang.StrictMath.max;

/*
Ben Lemke
Rectangles 'n' such
Implements a class for  rectangles and analyzes their intersections
29/04/2019
*/

public class M2Q8 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        boolean another = true;
        // loop until the user doesn't want to do more
        while (another) {
            Rectangle r1;
            Rectangle r2;

            //ask whether to use specs from question
            System.out.println("use defaults?");
            if ("yes".equals(br.readLine())) {
                r1 = new Rectangle(1, 1, 3, 4);
                r2 = new Rectangle(2, 2, 3, 4);
            } else {
                int l1;
                int b1;
                int w1;
                int h1;

                int l2;
                int b2;
                int w2;
                int h2;

                // get the specs
                System.out.println("l1");
                l1 = Integer.parseInt(br.readLine());
                System.out.println("b1");
                b1 = Integer.parseInt(br.readLine());
                System.out.println("w1");
                w1 = Integer.parseInt(br.readLine());
                System.out.println("h1");
                h1 = Integer.parseInt(br.readLine());
                System.out.println("l2");

                l2 = Integer.parseInt(br.readLine());
                System.out.println("b2");
                b2 = Integer.parseInt(br.readLine());
                System.out.println("w2");
                w2 = Integer.parseInt(br.readLine());
                System.out.println("h2");
                h2 = Integer.parseInt(br.readLine());

                r1 = new Rectangle(l1,b1,w1,h1);
                r2 = new Rectangle(l2,b2,w2,h2);
            }

            // implement the methods and output the results
            System.out.println("Containing: " + Rectangle.containsOrIsContained(r1,r2));
            System.out.println("Intersecting Rectangle: " + Rectangle.intersectingRectangle(r1,r2));
            System.out.println("Total Perimeter: " + Rectangle.totalPerimeter(r1,r2));


            // ask user whether or not to do it again
            System.out.println("again?");
            another = (!br.readLine().equals("quit"));
        }
    }
}

// A class for rectangles
class Rectangle{
    private int left; // x-coordinate of left edge
    private int bottom; // y-coordinate of bottom edge
    private int width; // width of rectangle
    private int height; // height of rectangle

    // Constructor method
    Rectangle(int leftX, int bottomY, int width, int height){
        left = max(0,leftX);
        bottom = max(0,bottomY);
        this.width = max(0,width);
        this.height = max(0,height);
    }

    private int right(){
        return left + width;
    }

    private int top(){
        return bottom + height;
    }

    // returns a string representing the rectangle
    public String toString() {
        return ("Base (" + left + "," + bottom + ") w:" + width + " h:" + height);
    }

    // returns the area of the rectangle
    public int area(){
        return width * height;
    }

    // returns whether r1 contains r2
    public static boolean contains(Rectangle r1, Rectangle r2){
        System.out.println("l" + (r1.left - r2.left));
        System.out.println("b" + (r1.bottom - r2.bottom));
        System.out.println("r" + (r1.right() - r2.right()));
        System.out.println("t" + (r1.top() - r2.top()));
        return (r1.left <= r2.left && r1.bottom <= r2.bottom && r1.right() >= r2.right() && r1.top() >= r2.top());
    }

    // returns whether r1 contains r2
    public static boolean containsOrIsContained(Rectangle r1, Rectangle r2){
        return contains(r1, r2) || contains(r2,r1);
    }

    // returns the rectangle of the intersection
    public static Rectangle intersectingRectangle(Rectangle r1, Rectangle r2){
        int left;
        int bottom;
        int width;
        int height;

        // checks if one rectangle contains another
        if (Rectangle.containsOrIsContained(r1,r2)){
            return new Rectangle(0,0,0,0);
        }

        // find the intersecting rectangle values
        left = max(r1.left,r2.left);
        width = min(r1.right(), r2.right()) - left;
        bottom = max(r1.bottom, r2.bottom);
        height = min(r1.top(), r2.top()) - bottom;

        // if width or height is negative return a zero rectangle
        if (width < 0 || height < 0){
            return new Rectangle(0,0,0,0);
        }
        // otherwise return the rectangle
        else{
            return new Rectangle(left,bottom,width,height);
        }
    }

    // return the length of the perimeter
    private int perimeter(){
        return width * 2 + height * 2;
    }

    // return the perimeter of the outside of two rectangles
    public static int totalPerimeter(Rectangle r1, Rectangle r2){{
        if (contains(r1,r2)){
            return r1.perimeter();
        }
        else if(contains(r2,r1)){
            return r2.perimeter();
        }
        else{
            return r1.perimeter() + r2.perimeter() - intersectingRectangle(r1,r2).perimeter();
        }
    }

    }
}