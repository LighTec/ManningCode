/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GridWorld3Stuff;

import java.awt.Color;

/**
 *
 * @author kell-gigabyte
 */
public class Bug extends info.gridworld.actor.Bug {

    /**
     * Constructs a box bug that traces a square of a given side length
     */
    public Bug() {
        setColor(Color.ORANGE);
    }

    /**
     * Moves to the next location of the square.
     */
    @Override
    public void act() {
        if (canMove()) {
            move();
        } else {
            turn();
        }
    }
}
