package GridWorld2Stuff;

import GridWorld2Stuff.Termite;
import GridWorld2Stuff.EternalFlower;
import java.awt.Color;

public class LangtonTermite extends Termite {

    @Override
    public void act() {
        if (getGrid() == null) {
            return;
        }
        if (hasFlower()) {
            this.flower = null;
        }
        if (seeFlower()) {
            //System.out.println("flower");

            pickUpFlower();
            turn(45);
            move();

        } else {
            //System.out.println("no flower");

            createFlower();
            throwFlower();
            turn(315);
            move();
        }

    }

    @Override
    public void createFlower() {
        if (hasFlower()) {
            System.out.println("createFlower? You already have one!");
            return;
        }
        flower = new EternalFlower();
        flower.setColor(Color.BLACK);
    }
}
