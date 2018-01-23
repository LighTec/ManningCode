/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridworld;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author kell-gigabyte
 */
public class KingCrab extends CrabCritter {

    public KingCrab() {
        setColor(Color.BLUE);
    }

    @Override
    public void processActors(ArrayList<Actor> act) {
        for (Actor a : act) {
            Location loc = a.getLocation();
            Location loc1 = loc.getAdjacentLocation(getLocation().getDirectionToward(loc));
            if (getGrid().isValid(loc1)) {
                a.moveTo(loc1);
            } else {
                a.removeSelfFromGrid();
            }
        }
    }

}
