/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flasktester;

/**
 *
 * @author kell-gigabyte
 */
public class FlaskTester {

    public static void main(String[] args) {
        Flask f = new Flask();

        double chance = Math.random();
        if (chance < 0.5) {
            f = new PoisonedFlask();
        } else {
            f = new SafeFlask();
        }

        System.out.println(f.toString());  // which toString method should be executed?
    }

}
