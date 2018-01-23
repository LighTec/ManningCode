/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GridWorld3Stuff;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author kell-gigabyte
 */
public class BlueBug extends Bug {
    
    public BlueBug(Color c){
        setColor(c);
    }
    
    public BlueBug(){
        
    }

    @Override
    public void act() {
        randomTurn();
        if (!canMove()) {
            return;
        }
        move();

        Location loc = getLocation();
        Grid grid = getGrid();
        ArrayList<Actor> neighbors = grid.getNeighbors(loc);

        neighbors.stream().filter((actor) -> (actor instanceof Rock)).forEachOrdered((Actor actor) -> {
            actor.setColor(Color.blue);
        });
    }

    public void randomTurn() {
        if (Math.random() < 0.5) {
            turn(-45);
        } else {
            turn(45);
        }
    }

    public void turn(int degrees) {
        setDirection(getDirection() + degrees);
    }
}
