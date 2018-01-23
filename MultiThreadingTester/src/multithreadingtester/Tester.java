/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadingtester;

/**
 *
 * @author kell-gigabyte
 */
public class Tester extends Thread {

    public static void main(String args[]) {
        while(true){
        SlowFib fib1 = new SlowFib("Thread slowFib");
        }
       // FastFib fib2 = new FastFib("Thread fastFib");
       //MediumFib fib3 = new MediumFib("Thread mediumFib");
    }
}



/*
    public static void main(String args[]) {
        Count cnt = new Count();
        try {
            while (cnt.isAlive()) {
                System.out.println("Main thread will be alive till the child thread is live");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread's run is over");
    }



 */
 /*
class Count extends Thread {

    Count() {
        super("my extending thread");
        System.out.println("my thread created" + this);
        this.start();
    }

    public void run() {
        int i = 0;
            while(true){
                System.out.println("Printing the count " + i);
                i++;
            }
    }
    
    /*
       public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Printing the count " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("my thread interrupted");
        }
        System.out.println("My thread run is over");
    }
}
 */
