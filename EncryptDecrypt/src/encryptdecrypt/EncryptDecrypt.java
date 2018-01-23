/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptdecrypt;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kell-gigabyte
 */
public class EncryptDecrypt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AsciiLookup al = new AsciiLookup();

        // The current encryption/ decryption scheme
        int scheme = 1;
        System.out.println("Encrypt or decrypt?     1: encrypt   2: decrypt");
        Scanner kbin = new Scanner(System.in);
        int select = Integer.parseInt(kbin.nextLine());

        System.out.println("Enter in the message.");
        String msg = kbin.nextLine();

        String finalMsg = "";
                switch (scheme) {
            case 1:
                HexEnigmaMk2 he = new HexEnigmaMk2();
                switch (select) {
                    case 1:
                        finalMsg = he.encrypt(msg);
                        break;
                    case 2:
                        finalMsg = he.decrypt(msg);
                        break;
                    default:
                        System.err.println("Input Fuckup detected");
                        break;
                }
                break;
            default:
                System.err.println("Scheme Fuckup detected");
                break;
        }

        System.out.println(finalMsg);
        
/*
        switch (scheme) {
            case 1:
                HexEnigma he = new HexEnigma();
                switch (select) {
                    case 1:
                        finalMsg = he.encrypt(msg);
                        break;
                    case 2:
                        finalMsg = he.decrypt(msg);
                        break;
                    default:
                        System.err.println("Input Fuckup detected");
                        break;
                }
                break;
            default:
                System.err.println("Scheme Fuckup detected");
                break;
        }

        System.out.println(finalMsg);
*/
    }

}
