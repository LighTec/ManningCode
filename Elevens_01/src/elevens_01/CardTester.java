package elevens_01;

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

    /**
     * The main method in this class checks the Card operations for consistency.
     *
     * @param args is not used.
     */
    public static void main(String[] args) {
        Card thiscard = new Card("Ace", "Spades", 14);
        Card anothercard = new Card("Ace", "Spades", 14);
        Card doff = new Card("Queen", "Hearts", 12);
        System.out.println(thiscard.matches(anothercard));
        System.out.println(doff.toString());
    }
}
