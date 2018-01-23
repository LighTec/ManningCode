package GridWorld2Stuff;

public class MyTermite extends Termite {

    @Override
    public void act() {
        if (getGrid() == null) {
            return;
        }
        if (seeFlower()) {
            pickUpFlower();
        }
        if (hasFlower()) {
            dropFlower();
        }
        if (canMove()) {
            move();
        }
        //randomTurn();
    }
}
