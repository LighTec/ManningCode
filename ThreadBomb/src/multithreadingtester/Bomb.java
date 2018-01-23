
package multithreadingtester;

import java.awt.Dimension;

public class Bomb extends Thread {

    public Bomb(String s) {
        super(s);
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            AlertBox alert = new AlertBox(new Dimension(200, 50), "rekt scrub", "KABOOM");
            alert.display();
        }
    }
}
