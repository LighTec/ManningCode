
package multithreadingtester;

/**
 *  *uses multiple threads
 * 
 *  Note: This program is just a jury-rigged version of the multithread test from beforehand, when
 *  I was messing around with multithreading, and decided to use the fibonacci sequence
 *  as a way of testing it.
 * 
 * @author kell-gigabyte
 */
public class Fibonacci extends Thread {

    public static void main(String args[]) {
       // FastFib fib1 = new FastFib("Thread FastFib");
       SlowFib fib2 = new SlowFib("Thread slothFib");
    }
}
