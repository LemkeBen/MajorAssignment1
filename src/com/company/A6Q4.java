package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A6Q4 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        boolean another = true;
        // loop until the user doesn't want to do more
        while (another) {
            //ask whether to use specs from question
            System.out.println("use defaults?");
            double h1;
            double h2;
            double m1;
            double m2;

            if ("yes".equals(br.readLine())) {
                h1 = 150;
                m1 = 40;
                h2 = 151;
                m2 = 40.2;
            } else {
                // get the heights and masses
                System.out.println("h1");
                h1 = Integer.parseInt(br.readLine());
                System.out.println("m1");
                m1 = Integer.parseInt(br.readLine());
                System.out.println("h2");
                h2 = Integer.parseInt(br.readLine());
                System.out.println("m2");
                m2 = Integer.parseInt(br.readLine());
            }

            //create the kids and do the operations
            Child k1 = new Child(h1,m1);
            Child k2 = new Child(h2, m2);
            System.out.println(k1.equals(k2));



            // ask user whether or not to do it again
            another = (!br.readLine().equals("quit"));
        }
    }
}

class Child{
    double height; //cm
    double mass; //kg
    Child(double childHeightCM, double childMassKG){
        height = childHeightCM;
        mass = childMassKG;
    }

    public boolean equals(Child other) {
        if((other.height <= this.height + 2) && (other.height >= this.height - 2) && (other.mass >= this.mass - 0.5) && (other.mass <= this.mass + 0.5)){
            return true;
        }
        else{
            return false;
        }
    }
}