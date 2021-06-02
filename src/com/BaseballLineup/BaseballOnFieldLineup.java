package com.BaseballLineup;

import com.BaseballPosition.BaseballPosition;
import com.Exceptions.PlayerNotFoundException;
import java.util.ArrayList;

/**
 * A class for the on-field section of a fielding lineup
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - June 2, 2021
 */
public class BaseballOnFieldLineup {
    private ArrayList<BaseballPlayerInLineup> fielders;

    /**
     * Constructor for a BaseballOnFieldLineup object
     */
    public BaseballOnFieldLineup() {
        fielders = new ArrayList<BaseballPlayerInLineup>();
    }

    /**
     * Method that adds a given BaseballPlayerInLineup object
     * to the list of fielders
     *
     * @param player - the BaseballPlayerInLineup object
     *                 to be added to the on Field Lineup
     * @return - a boolean value representing the player
     *           has a valid fielding position
     */
    public boolean setFielder(BaseballPlayerInLineup player) {
        BaseballPosition pos = player.getPosition();
        if(pos.posNumber() == 10) return false;
        for(BaseballPlayerInLineup p : fielders) {
            if(p.getPosition().compareTo(pos) == 0) {
                fielders.remove(p);
                fielders.add(player);
            }
        }
        fielders.add(player);
        return true;
    }

    /**
     * Method that removes a BaseballPlayerInLineup object
     * from the list of fielders based on a given BaseballPosition
     *
     * @param pos - given BaseballPosition
     */
    public void removeFielder(BaseballPosition pos) {
        fielders.removeIf(player -> player.getPosition().compareTo(pos) == 0);
    }

    /**
     * Method that gets the BaseballPlayerInLineup object with
     * the given BaseballPosition
     *
     * @param pos - given BaseballPosition
     * @return - BaseballPlayerInLineup with the given BaseballPosition
     * @throws PlayerNotFoundException - thrown if there is no
     *                                   BaseballPlayerInLineup object
     *                                   with the given BaseballPosition
     */
    public BaseballPlayerInLineup getFielder(BaseballPosition pos) throws PlayerNotFoundException {
        for(BaseballPlayerInLineup player: fielders) {
            if(player.getPosition().compareTo(pos) == 0)
                return player;
        }
        throw new PlayerNotFoundException("There is no player in the field with the position " + pos.toString());
    }
}
