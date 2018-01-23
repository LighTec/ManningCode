/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridworld;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author kell-gigabyte
 */
public class QuickCrab extends CrabCritter {

    public QuickCrab() {
        setColor(Color.CYAN);
    }

    public QuickCrab(Color c) {
        setColor(c);
    }

    @Override
    public ArrayList<Location> getLocationsInDirections(int[] directions) {
        ArrayList<Location> locs = new ArrayList<>();
        Grid<Actor> grid = getGrid();
        Location loc = getLocation();

        for (int d : directions) {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            Location moveLoc = neighborLoc.getAdjacentLocation(getDirection() + d);
            if (grid.isValid(neighborLoc) && grid.isValid(moveLoc) && grid.get(neighborLoc) == null && grid.get(moveLoc) == null) {
                locs.add(moveLoc);
            }
        }
        if (locs.isEmpty()) {
            return super.getLocationsInDirections(directions);
        } else {
            return locs;
        }
    }

}
