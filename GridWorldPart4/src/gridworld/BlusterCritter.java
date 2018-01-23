/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridworld;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author kell-gigabyte
 */
public class BlusterCritter extends Critter {

    public BlusterCritter(int courage) {
        this.setColor(Color.yellow);
        this.courage = courage;
    }

    int courage;

    Color c;

    @Override
    public void processActors(ArrayList<Actor> actors) {
        if (actors.size() < this.courage) {
            this.setColor(this.getColor().brighter());
        } else {
            this.setColor(this.getColor().darker());
        }
    }

    @Override
    public void makeMove(Location loc) {
        Location l = this.getLocation();
        int i = l.getDirectionToward(loc);
        this.setDirection(i);
        this.moveTo(loc);
    }
}
