/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadingtester;

import java.util.Scanner;

/**
 *
 * @author kell-gigabyte
 */
public class SlowFib extends Thread {

    public SlowFib(String s) {
        super(s);
        //System.out.println("slow fib thread started");
        this.start();
    }

    public void run() {
        while (true) {
            System.out.print("Generate which term number?  ");
            Scanner kbIn = new Scanner(System.in);
            String nextInt = kbIn.next();
            if(nextInt.equals("quit") || nextInt.equals("exit")){
                break;
            }
            int fibInt = Integer.parseInt(nextInt);
      
            System.out.println("\nTerm #" + fibInt + " is " + calcFib(fibInt));
        }
    }

    public static int calcFib(int index) {
        System.out.println("Calculating for: " + index);
        switch (index) {
            case 1:
                return 5;
            case 0:
                return 3;
            case 2:
                return 8;
            default:
                return calcFib(index - 1) + calcFib(index - 2);
        }
    }
}