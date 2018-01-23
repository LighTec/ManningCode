/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridworld;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 *
 * @author kell-gigabyte
 */
public class Jumper extends info.gridworld.actor.Bug {

    /**
     * Constructs a box bug that traces a square of a given side length
     */
    public Jumper() {
        setColor(Color.ORANGE);
    }

    public Jumper(Color c) {
        setColor(c);
    }

    /**
     * Moves to the 2 locations away of the square.
     */
    @Override
    public void act() {
        if (canMove()) {
            move();
        } else {
            turn();
        }
    }

    @Override
    public void move() {
        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return;
        }
        if (gr.isValid(getLocation().getAdjacentLocation(getDirection()))) {
            moveTo(getLocation().getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection()));
        } else {
            removeSelfFromGrid();
        }
    }

    @Override
    public boolean canMove() {
        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return false;
        }
        Location next = getLocation().getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
        
        if (!gr.isValid(next)) {
            return false;
        }
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
    }
}
