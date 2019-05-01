package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Ben Lemke
Key locks
Implements a class for managing a key (pin) - based lock
27/04/2019
*/

public class M2Q7 {
    public static void main(String[] args) throws IOException {
        // setup inputs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        boolean another = true;
        // loop until the user doesn't want to do more
        while (another) {
            // Implement the lock class using a fragment copied from the question
            Lock lock1 = new Lock(111);
            Lock lock2 = new Lock(222);
            lock1.close();
            lock2.close();
            System.out.println(lock1.isOpen()); // prints false
            lock1.open(123); // fails to open lock1
            lock1.open(456); // fails to open lock1
            lock2.open(222); // opens lock2
            lock1.open(789); // fails - prints ALARM

            // ask user whether or not to do it again
            System.out.println("again?");
            another = (!br.readLine().equals("quit"));
        }
    }


}

// Class for integer-keyed locks
class Lock{
    private int key;
    private boolean open = true;
    private int failedAttempts = 0;
    // Constructor Methon
    Lock(int key){
        this.key = key;
    }
    // Close the lock
    public void close(){
        open = false;
    }
    // returns whether or not the lock is open
    public boolean isOpen(){
        return open;
    }
    // tries to open the lock with a parameter as a key
    public void open(int key){
        // if the key is correct open the lock
        if (this.key == key){
            open = true;
        }
        // if the key is wrong alarm or count incorrect ones
        else if (failedAttempts == 2){
            System.out.println("ALARM");
        }
        else{
            failedAttempts++;
        }
    }
}

