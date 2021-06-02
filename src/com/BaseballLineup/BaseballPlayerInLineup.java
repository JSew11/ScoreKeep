package com.BaseballLineup;

import com.BaseballPosition.*;
import com.BaseballBasics.*;

/**
 * A class for a player in a baseball lineup
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - June 2, 2021
 */
public class BaseballPlayerInLineup {
    private BaseballPlayer player;
    private BaseballPosition position;

    /**
     * Constructor for a BaseballPlayerInLineup object using a given
     * player and position they are playing
     *
     * @param player - given player
     * @param position - given position
     */
    public BaseballPlayerInLineup(BaseballPlayer player, BaseballPosition position) {
        this.player = player;
        this.position = position;
    }

    // attribute accessors
    public BaseballPlayer getPlayer() {return player;}
    public BaseballPosition getPosition() {return position;}

    // attribute mutators
    public void setPlayer(BaseballPlayer player) {this.player = player;}
    public void setPosition(BaseballPosition position) {this.position = position;}
}
