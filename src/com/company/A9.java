package com.company;

import java.io.IOException;

/*
Ben Lemke
Inheritance and wildlife
Implements a tree of classes and uses inheritance to emulate how evolution works
16/05/2019
 */

public class A9 {
    public static void main(String[] args) throws IOException {
        // Create instances and call methods
        Animal animal = new Animal("black", 6);
        animal.eat();
        animal.sleep();
        Mammal mammal = new Mammal("pink", 2, 12.5);
        mammal.speak();
        mammal.sleep();
        Dog doggo = new Dog("brown", 2.5, true);
        doggo.bark();
        doggo.playFetch();
        doggo.speak();
        doggo.eat();
        Cat cat = new Cat(true, "black", 2);
        cat.pounce();
        cat.meow();
        cat.purr();
        Hamster hamster = new Hamster("brown", 2);
        hamster.runInWheel();
        Snake snake = new Snake("green");
        snake.hiss();
        snake.eat();
        Bird birdy = new Bird("brown and grey");
        birdy.fly();
        birdy.sleep();
    }
}

// Class for animals
class Animal {
    String colour; // Represents the colour of the animal
    int numLegs; // Represents the number of legs the animal has
    // Constructor method
    Animal(String color, int legs){
        colour = color;
        numLegs = legs;
    }
    // Method for an animal eating
    public void eat(){
        System.out.println("The Animal eats");
    }
    // Method for an animal sleeping
    public void sleep(){
        System.out.println("In the jungle ... the Animal ZZZ's tonight ... awooooooo oo oo oo oo bubumdumbaway");
    }
}

// Class for mammals that extends the animal class
class Mammal extends Animal {
    double hairlength; // Represents the length of the mammal's hair
    // Constructor method
    Mammal(String color, int legs, double hair) {
        super(color, legs); // Calls animal's constructor method
        hairlength = hair;
    }
    // Make a mammal speak
    public void speak(){
        System.out.println("Mamals can talk");
    }
}

// Class for dogs
class Dog extends Mammal {
    boolean chasesTail; // Represents whether or not a do chases it's tail
    // Constructor method
    Dog(String color, double hair, boolean tailChasing){
        super(color,4,hair); // Calls mammal's constructor method and always set numlegs to 4
        chasesTail = tailChasing;
    }
    // Make a dog bark
    public void bark(){
        System.out.println("Ruff ruff");
    }
    // Make a dog play fetch
    public void playFetch(){
        System.out.println("Run and woof");
    }
}

// Class for cats
class Cat extends Mammal {
    boolean isPlayful; // Represents whether or not the cat is friendly
    // Constructor method
    Cat(boolean plays, String color, double hair){
        super(color,4,hair); // Calls mammal's constructor method and always set numlegs to 4
        isPlayful = plays;
    }
    // Make the cat purr
    public void purr(){
        System.out.println("Purrrrr");
    }
    // Make the cat meow
    public void meow(){
        System.out.println("mow mow");
    }
    // Make the cat pounce
    public void pounce(){
        System.out.println("Pounce");
    }
}

// Class for Hamster (or other rodents)
class Hamster extends Mammal {
    // Constructor method
    Hamster(String color, double hair) {
        super(color, 4, hair); // Calls mammal's constructor method and always set numlegs to 4
    }
    // Make the Hamster (or rodent) run in it's wheel
    public void runInWheel() {
        System.out.println("The wheel of the Hamster goes round and round, round and round ... all of the time");
    }
}

// Class for snakes that extends the animal class
class Snake extends Animal {
    // Constructor method
    Snake(String color){
        super(color, 0); // Calls animal's constructor method and sets numlegs to 0
    }
    // Make the snake hissss
    public void hiss(){
        System.out.println("SssSsssS");
    }
}

// Class for bords that extends the animal class
class Bird extends Animal {
    // Constructor method
    Bird(String colour){
        super(colour, 2); // Calls animal's constructor method and sets numlegs to 2
    }
    // Make a bird fly
    public void fly(){
        System.out.println("Fly like an eagle");
    }
}