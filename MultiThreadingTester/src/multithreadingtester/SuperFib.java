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
public class SuperFib extends Thread {

    public SuperFib(String s) {
        super(s);
        //System.out.println("some fib thread started");
         SuperFib fib = new SuperFib("Some thread");
        this.start();
    }

    public void run() {
        int count = 0;
        while (true) {
            System.out.println("The fib number at index " + count + " is " + calcFib(count)  + "    (THREAD 1)");
            count++;
        }
    }

    public static int calcFib(int index) {
        switch (index) {
            case 1:
                return 1;
            case 0:
                return 0;
            default:
                return calcFib(index - 1) + calcFib(index - 2);
        }
    }
}
