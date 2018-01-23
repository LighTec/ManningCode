package GridWorld2Stuff;

/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br The
 * implementation of this class is testable on the AP CS A and AB exams.
 */
public class DancingBug extends Bug {

    private int[] turns;
    private int cycleCount;

    /**
     * Constructs a box bug that traces a square of a given side length
     *
     * @param length the side length
     */
    public DancingBug(int[] turn) {
        this.turns = turn;
        this.cycleCount = 0;
    }

    /**
     * Moves to the next location of the square.
     */
    @Override
    public void act() {
        if(this.cycleCount > turns.length - 1){
            this.cycleCount = 0;
        }
        if (canMove()) {
            for(int i = 0; i < turns[cycleCount]; i++){
            turn();
        }
            move();
           this.cycleCount++;
        }else{
            turn();
            turn();
        }
    }
}
