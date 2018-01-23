/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dumbshit;

/**
 *
 * @author kell-gigabyte
 */
public class DumbShit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 1; i <= 12; i++) {
            System.out.println(daysInMonth(i));
        }
    }

    public static int daysInMonth(int month) {
        // takes ASCII value, divides by 2.
        String blah = ">8><><>><><>";
        return ((int) blah.charAt(month - 1)) / 2;
    }

    public boolean isTrue(String condition) {
        try {
            char isFalse = condition.charAt(4);
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}
