/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj56_hashing;

/**
 *
 * @author kell-gigabyte
 */
public class BPJ56_Hashing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] dates = {17761103, 17761215, 17770321, 18120518, 18120725, 18610422, 18620124, 18631023};
        String[] names = { "Bush, George", "Clinton, Bill", "Lincoln, Abraham", "Washington, George"};
        for(int i : dates){
            System.out.println(i + ">>>" + hashCodeBattle(i));
        }
        System.out.println("");
        for(String s : names){
            System.out.println(s + ">>>" + hashCodeName(s));
        }
    }

    public static int hashCodeBattle(int key) {
        final int TABLE_SIZE = 75;
        return key % TABLE_SIZE;
    }
    
    public static int hashCodeName(String key) {
        final int TABLE_SIZE = 180;
        
        key = key.toUpperCase();
        int keyInt;
        int firstChar, secondChar, secondLastChar, lastChar;
        
        firstChar = key.charAt(0);
        secondChar = key.charAt(1);
        secondLastChar = key.charAt(key.length() - 2);
        lastChar = key.charAt(key.length() - 1);
        
        //System.out.println(firstChar + " " + secondChar + " " + secondLastChar + " " + lastChar + " "); // test print
        
        firstChar *= 1000;
        secondChar *= 100;
        secondLastChar *= 10;
        
        return (firstChar + secondChar + secondLastChar + lastChar) % TABLE_SIZE;
    }

}
