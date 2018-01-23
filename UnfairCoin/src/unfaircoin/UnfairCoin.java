/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unfaircoin;

/**
 *
 * @author kell-gigabyte
 */
public class UnfairCoin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(flip());
    }
    
    public static String flip(){
        String flipped;
            int chance = (int) (Math.random() * 3);
            if (chance == 0) {
                flipped = "tails";
            } else {
                flipped = "heads";
            }
        return flipped;
    }
}
