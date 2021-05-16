package com.Athlete;

import com.BaseballPosition.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit testing for the com.Athlete.BaseballPlayer class
 *
 * @author - Joshua Seward
 */
public class BaseballPlayerTests {
    private BaseballPosition startingPos = new Pitcher();
    private BaseballPlayer player =
            new BaseballPlayer("Test", "Player", 0, startingPos);

    @Test
    void getPrimaryPositionTest() {
        // check that the constructor correctly sets the primaryPosition
        assertEquals(player.getPrimary_position(), startingPos);
    }

    @Test
    void setPrimaryPositionTest() {
        // create a new BaseballPosition object
        BaseballPosition leftField = new LeftField();
        // change the player's primaryPosition
        player.setPrimary_position(leftField);
        // check if the player's primaryPosition is correct after the change
        assertEquals(player.getPrimary_position(), leftField);
    }

    @Test
    void addSecondaryPositionTest() {
        // create new Positions to add to the player
        BaseballPosition curPos = player.getPrimary_position();
        BaseballPosition centerField = new CenterField();
        // check that the current primary primaryPosition cannot be added
        // as a secondary position
        assertEquals(false, player.addSecondary_position(curPos));
        // check that a different position can be added as a secondary position
        assertEquals(true, player.addSecondary_position(centerField));
        assertEquals(true, player.getSecondary_positions().contains(centerField));
        // check that the same position that was added as a secondary position
        // cannot be added again
        assertEquals(false, player.addSecondary_position(centerField));
    }

    @Test
    void removeSecondaryPositionTest() {
        BaseballPosition rightField = new RightField();
        // add a new position to the secondaryPositions list
        player.addSecondary_position(rightField);
        // try to remove the RightField BaseballPosition from the
        // secondaryPositions list
        player.removeSecondary_position(rightField);
        // check that the secondaryPlayers list does not contain
        // the position that was removed
        assertEquals(false, player.getSecondary_positions().contains(rightField));
    }
}
