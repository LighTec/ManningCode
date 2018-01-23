package basically.speaking;

/**
 *
 * @author Kell
 */
public class BasicallySpeaking {
    public static void main(String[] args) {
        System.out.println("Decimal        Binary          Octal        Hex        Character");
        for(int loopNum = 65; loopNum <= 90; loopNum++){
            String binaryNum = Integer.toBinaryString(loopNum);
            String octalNum = Integer.toOctalString(loopNum);
            String hexNum = Integer.toHexString(loopNum);
            char charNum = (char)loopNum;
            System.out.println(loopNum + "             " + binaryNum + "        " + octalNum + "           " + hexNum + "         " + charNum);
            
        }
    }
    
}
