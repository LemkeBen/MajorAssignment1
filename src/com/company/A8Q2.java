package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A8Q2 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        boolean another = true;
        // loop until the user doesn't want to do more
        while (another) {
            String name1;
            double age1;
            double height1;
            String sex1;
            String name2;
            double age2;
            double height2;
            String sex2;
            String name3;
            double age3;
            double height3;
            String sex3;

            //ask whether to use default values
            System.out.println("use defaults?");

            if ("yes".equals(br.readLine())) {
                name1 = "Ben";
                age1 = 17;
                height1 = 156;
                sex1 = "Male";
                name2 = "Evan";
                age2 = 16;
                height2 = 100;
                sex2 = "Male";
                name3 = "Jessica";
                age3 = 18;
                height3 = 140.5;
                sex3 = "Female";
            } else {
                // get the numerators and denominators
                System.out.println("name1");
                name1 = br.readLine();
                System.out.println("age1");
                age1 = Integer.parseInt(br.readLine());
                System.out.println("height1");
                height1 = Integer.parseInt(br.readLine());
                System.out.println("sex1");
                sex1 = br.readLine();
                System.out.println("name2");
                name2 = br.readLine();
                System.out.println("age2");
                age2 = Integer.parseInt(br.readLine());
                System.out.println("height2");
                height2 = Integer.parseInt(br.readLine());
                System.out.println("sex2");
                sex2 = br.readLine();
                System.out.println("name3");
                name3 = br.readLine();
                System.out.println("age3");
                age3 = Integer.parseInt(br.readLine());
                System.out.println("height3");
                height3 = Integer.parseInt(br.readLine());
                System.out.println("sex3");
                sex3 = br.readLine();
            }

            //create the instances of the class and do the operations to them
            FancyChild[] children = new FancyChild[3];
            children[0] = new FancyChild(name1,age1,height1,sex1);
            children[1] = new FancyChild(name2,age2,height2,sex2);
            children[2] = new FancyChild(name3,age3,height3,sex3);

            for (int i = 0; i < 3; i++){
                children[i].printString();
            }

            String [] names = {name1, name2, name3};
            double [] ages = {age1,age2, age3};
            double [] heights = {height1,height2,height3};
            String [] sexes = {sex1, sex2, sex3};

            for (int i = 0; i< 3; i++){
                System.out.println("name: " + names[i]);
                System.out.println("age: " + ages[i] + " height: " + heights[i] + " sex: " + sexes[i]);
            }

            // ask user whether or not to do it again
            System.out.println("Do it again?");
            another = (!br.readLine().equals("quit"));
        }
    }
}
class FancyChild{
    String name;
    double age;
    double height;
    String sex;


    FancyChild(String childName, double childAgeYrs, double childHeightCM, String childSex){
        name = childName;
        age = childAgeYrs;
        height = childHeightCM;
        sex = childSex;
    }
    public void printString(){
        System.out.println("name: " + name);
        System.out.println("age: " + age + " height: " + height + " sex: " + sex);
    }
}
