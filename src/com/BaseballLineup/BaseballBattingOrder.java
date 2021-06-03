package com.BaseballLineup;

import com.Exceptions.PlayerNotFoundException;
import java.util.ArrayList;

/**
 * A class for the batting order of a baseball lineup
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - June 3, 2021
 */
public class BaseballBattingOrder {
    private ArrayList<BaseballPlayerInLineup> battingOrder;

    /**
     * Constructor for a BaseballBattingOrder object
     */
    public BaseballBattingOrder() {
        battingOrder = new ArrayList<BaseballPlayerInLineup>();
    }

    /**
     * Method to set a batter to a specific spot in the batting order
     * using a given player and position
     *
     * @param player - given BaseballPlayerInLineup
     * @param battingPos - given spot in the batting order
     */
    public void setBatter(BaseballPlayerInLineup player, int battingPos) {
        battingOrder.add(battingPos, player);
    }

    /**
     * Method to remove a batter from the batting order based on a given
     * BaseballPlayerInLineup
     *
     * @param player - given BaseballPlayerInLineup
     */
    public void removeBatter(BaseballPlayerInLineup player) {
        battingOrder.removeIf(p -> player.getPlayer().compareTo(p.getPlayer()) == 1);
    }

    /**
     * Method to give the BaseballPlayerInLineup at a given spot in the
     * batting order
     *
     * @param pos - given spot in the batting order
     * @return - the BaseballPlayerInLineup at the given spot in the batting
     *           order
     * @throws PlayerNotFoundException - thrown if there is no batter at the
     *                                   given spot in the batting order
     */
    public BaseballPlayerInLineup getBatterAt(int pos) throws PlayerNotFoundException {
        if(pos < battingOrder.size())
            return battingOrder.get(pos);
        throw new PlayerNotFoundException("There is no batter hitting in the " + pos + " spot");
    }

    /**
     * Method to give an integer representation of the spot at which the
     * given BaseballPlayerInLineup is in the batting order
     *
     * @param player - given BaseballPlayerInLineup
     * @return - integer representation of the spot at which the given
     *           BaseballPlayerInLineup is in the batting order
     * @throws PlayerNotFoundException - thrown if the player is not in
     *                                   batting order
     */
    public Integer getBatterSpot(BaseballPlayerInLineup player) throws PlayerNotFoundException {
        for(int i = 0; i < battingOrder.size(); ++i) {
            if(player.getPlayer().compareTo(battingOrder.get(i).getPlayer()) == 1)
                return i;
        }
        throw new PlayerNotFoundException(player.getPlayer().getFirst_name() + " " + player.getPlayer().getLast_name()
                                          + " is not in the batting order");
    }
}
