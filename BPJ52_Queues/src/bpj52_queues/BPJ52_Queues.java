/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj52_queues;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author kell-gigabyte
 */
public class BPJ52_Queues {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        NumberFormat fmt = NumberFormat.getNumberInstance();
        fmt.setMinimumFractionDigits(3); //may need to change value
        fmt.setMaximumFractionDigits(3); //may need to change value
        Scanner sf = new Scanner(new File("Data.in"));
        int maxIndx = -1; //-1 so when we increment below, the first index is 0
        LinkedListQueue q = new LinkedListQueue();
        while (sf.hasNext()) {
            maxIndx++;
            q.enqueue(sf.nextLine());
        }
        int TotalWaitTime = 0;
        Scanner sc = new Scanner((String) q.peekFront());
        int firstCustArrivalTime = sc.nextInt();
        int nextAvailTimeA = firstCustArrivalTime;
        int nextAvailTimeB = firstCustArrivalTime;

        sf.close(); //We opened a file above, so close it when finished.

        while (!q.isEmpty()) {
            String line = sc.next();
            System.out.println(line);
            Scanner lineSplit = new Scanner(line);
            int custArrivalTime = lineSplit.nextInt();
            int custHelpTime = lineSplit.nextInt();
            System.out.println(custArrivalTime + " " + custHelpTime);
        }

        for (int j = 0; j <= maxIndx; j++) {       //Typically, only one of the following two will be used.

        }
    }

}
