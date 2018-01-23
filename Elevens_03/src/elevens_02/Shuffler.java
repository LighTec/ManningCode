package elevens_02;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

    /**
     * The number of consecutive shuffle steps to be performed in each call to
     * each sorting procedure.
     */
    private static final int SHUFFLE_COUNT = 3;

    /**
     * The number of values to shuffle.
     */
    private static final int VALUE_COUNT = 20;

    /**
     * Tests shuffling methods.
     *
     * @param args is not used.
     */
    public static void main(String[] args) {
        System.out.println("Results of " + SHUFFLE_COUNT
                + " consecutive perfect shuffles:");
        int[] values1 = new int[VALUE_COUNT];
        for (int i = 0; i < values1.length; i++) {
            values1[i] = i;
        }
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            perfectShuffle(values1);
            
        }
        System.out.println();

        System.out.println("Results of " + SHUFFLE_COUNT
                + " consecutive efficient selection shuffles:");
        int[] values2 = new int[VALUE_COUNT];
        for (int i = 0; i < values2.length; i++) {
            values2[i] = i;
        }
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            selectionShuffle(values2);
        }
        System.out.println();
    }

    /**
     * Apply a "perfect shuffle" to the argument. The perfect shuffle algorithm
     * splits the deck in half, then interleaves the cards in one half with the
     * cards in the other.
     *
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void perfectShuffle(int[] values) {
        int[] tempArr = new int[values.length];
        int halfLength = values.length / 2;
        int k = 0;
        for (int j = 0; j < halfLength; j++) {
            tempArr[k] = values[j];
            k++;
            k++;
        }
        k = 1;
        for (int j = halfLength; j < values.length; j++) {
            tempArr[k] = values[j];
            k++;
            k++;
        }
        values = tempArr;
            for (int m = 0; m < values.length; m++) {
                System.out.print(" " + values[m]);
            }
            System.out.println();
    }

    /**
     * Apply an "efficient selection shuffle" to the argument. The selection
     * shuffle algorithm conceptually maintains two sequences of cards: the
     * selected cards (initially empty) and the not-yet-selected cards
     * (initially the entire deck). It repeatedly does the following until all
     * cards have been selected: randomly remove a card from those not yet
     * selected and add it to the selected cards. An efficient version of this
     * algorithm makes use of arrays to avoid searching for an as-yet-unselected
     * card.
     *
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void selectionShuffle(int[] values) {
        int[] tempArr = new int[values.length];
        ArrayList<Integer> numbersUnselected = new ArrayList<>();
        for (int index = 0; index < values.length; index++) {
            numbersUnselected.add(values[index]);
        }
        for (int i = 0; i < values.length; i++) {
            Integer tempInt = numbersUnselected.remove(((int) (Math.random() * numbersUnselected.size())));
            tempArr[i] = tempInt;
        }
        values = tempArr;
        for (int m = 0; m < values.length; m++) {
                System.out.print(" " + values[m]);
            }
            System.out.println();
    }
}
