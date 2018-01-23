package myPixLab;

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 *
 * @author Barbara Ericson
 */
public class PictureTester {

    /**
     * Method to test zeroBlue
     */
    public static void testZeroBlue() {
        Picture beach = new Picture("images/beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

    /**
     * Method to test zeroRed
     */
    public static void testZeroRed() {
        Picture beach = new Picture("images/beach.jpg");
        beach.explore();
        beach.zeroRed();
        beach.explore();
    }

    /**
     * Method to test zeroGreen
     */
    public static void testZeroGreen() {
        Picture beach = new Picture("images/beach.jpg");
        beach.explore();
        beach.zeroGreen();
        beach.explore();
    }

    /**
     * Method to equalize the RBG values
     */
    public static void convertToBlackAndWhite() {
        Picture lion = new Picture("images/femaleLionAndHall.jpg");
        lion.getAverage();
        lion.explore();
    }

    /**
     * Method to change brightness
     */
    public static void adjustBrightness(double d) {
        Picture lion = new Picture("images/koala.jpg");
        lion.adjBrightness(d);
        lion.explore();
    }

    /**
     * Method to mirror on a vertical axis
     */
    public static void verticalMirror() {
        Picture motorCycle = new Picture("images/redMotorcycle.jpg");
        motorCycle.vertMirror();
        motorCycle.explore();
    }

    /**
     * Method to mirror on a horizontal axis
     */
    public static void horizontalMirror() {
        Picture motorCycle = new Picture("images/redMotorcycle.jpg");
        motorCycle.horizMirror();
        motorCycle.explore();
    }

    /**
     * Method that flips the image vertically
     */
    public static void flipVertical() {
        Picture butterfly = new Picture("images/butterfly1.jpg");
        Picture butterfly2 = new Picture("images/butterfly1.jpg");
        butterfly.explore();
        butterfly.flipVert(butterfly2);
        butterfly2.explore();
    }

    /**
     * Method that flips the image horizontally
     */
    public static void flipHorizontal() {
        Picture butterfly = new Picture("images/butterfly1.jpg");
        Picture butterfly2 = new Picture("images/butterfly1.jpg");
        butterfly.explore();
        butterfly.flipHoriz(butterfly2);
        butterfly2.explore();
    }
    
    /**
     *  Method that "repairs" the temple by mirroring part of the image
     */
    public static void repairTemple() {
        Picture temple = new Picture("images/temple.jpg");
        temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }

    /**
     * Method to test the collage method
     */
    public static void testCollage() {
        Picture canvas = new Picture("images/640x480.jpg");
        canvas.createCollage();
        canvas.explore();
    }

    /**
     * Method to test edgeDetection
     */
    public static void testEdgeDetection() {
        Picture swan = new Picture("images/swan.jpg");
        swan.explore();
        swan.edgeDetection(10);
        swan.explore();
    }

    /**
     * Main method for testing. Every class can have a main method in Java
     */
    public static void main(String[] args) {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run
        
        //repairTemple();
        //testZeroBlue();
        //testZeroRed();
        //convertToBlackAndWhite();
        //adjustBrightness(0.5);
        //verticalMirror();
        //horizontalMirror();
        //flipHorizontal();
        //flipVertical();
        //testKeepOnlyBlue();
        //testKeepOnlyRed();
        //testKeepOnlyGreen();
        //testNegate();
        //testGrayscale();
        //testFixUnderwater();
        //testMirrorVertical();
        //testMirrorTemple();
        //testMirrorArms();
        //testMirrorGull();
        //testMirrorDiagonal();
        //testCollage();
        //testCopy();
        testEdgeDetection();
        //testEdgeDetection2();
        //testChromakey();
        //testEncodeAndDecode();
        //testGetCountRedOverValue(250);
        //testSetRedToHalfValueInTopHalf();
        //testClearBlueOverValue(200);
        //testGetAverageForColumn(0);
    }
}
