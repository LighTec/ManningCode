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
public class FastFib extends Thread{
    
    public FastFib(String s) {
        super(s);
        System.out.println("fast fib thread started");
        this.start();
    }

    public void run() {
        this.fibNums = new int[999999]; // WARNING: This class is broken, do not use (returns wrong values)
        this.fibNums[0] = 0;
        this.fibNums[1] = 1;
        int count = 0;
        while (true) {
            System.out.println("The fib number at index " + count + " is " + calcFib(count)  + "    (THREAD 2)");
            count++;
        }
    }

    private int[] fibNums;
    private int maxCalculated = 1;
    
    public int calcFib(int index) {
        if(index <= maxCalculated){
            return this.fibNums[index];
        }else if(index - 1 == maxCalculated){
            fibNums[index] = calcFib(index - 1) + calcFib(index - 2);
            this.maxCalculated++;
            return fibNums[index];
        }
        else{
                return calcFib(index - 1) + calcFib(index - 2);
        }
}
}