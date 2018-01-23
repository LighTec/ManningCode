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
public class FastFib extends Thread{
    
    public FastFib(String s) {
        super(s);
        System.out.println("fast fib thread started");
        this.start();
    }

    public void run() {
        this.fibNums = new int[999999];
        this.fibNums[0] = 3;
        this.fibNums[1] = 5;
        this.fibNums[2] = 8;
        while (true) {
            System.out.print("Generate which term number?  ");
            Scanner kbIn = new Scanner(System.in);
            String nextInt = kbIn.next();
            if(nextInt.equals("quit")){
                break;
            }
            int fibInt = Integer.parseInt(nextInt);
      
            System.out.println("\nTerm #" + fibInt + " is " + calcFib(fibInt));
        }
    }

    private int[] fibNums;
    private int maxCalculated = 2;
    
    public int calcFib(int index) {
        if(index <= maxCalculated){
            return this.fibNums[index];
        }else if(index - 1 == maxCalculated){
            fibNums[index] = calcFib(index - 1) + calcFib(index - 2) + calcFib(index - 3);
            this.maxCalculated++;
            return fibNums[index];
        }
        else{
                return calcFib(index - 1) + calcFib(index - 2) + calcFib(index - 3);
        }
}
}