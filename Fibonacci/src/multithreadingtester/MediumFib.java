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
public class MediumFib extends Thread{
    
        public MediumFib(String s) {
        super(s);
        System.out.println("medium fib thread started");
        this.start();
    }

    public void run() {
        int count = 0;
        while (true) {
            System.out.println("The fib number at index " + count + " is " + calcFib(count)  + "    (THREAD 3)");
            count++;
        }
    }

    public static int calcFib(int index) {
        switch (index) {
            case 1:
                return 1;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 5;
            case 6:
                return 8;
            case 7:
                return 13;
            case 8:
                return 21;
            case 9:
                return 34;
            case 0:
                return 0;
            default:
                return calcFib(index - 1) + calcFib(index - 2);
        }
    }
}
