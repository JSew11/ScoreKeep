import com.BaseballPosition.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit testing for the BaseballPlayer class
 *
 * @author - Joshua Seward
 */
public class BaseballPlayerTests {
    private BaseballPosition startingPos = new StartingPitcher();
    private BaseballPlayer player =
            new BaseballPlayer("Joshua", "Seward", 11, startingPos);

    @Test
    public void getPrimaryPositionTest() {
        // check that the constructor correctly sets the primaryPosition
        assertEquals(player.getPrimary_position(), startingPos);
    }

    @Test
    public void setPrimaryPositionTest() {
        // create a new BaseballPosition object
        BaseballPosition starter = new LeftField();
        // change the player's primaryPosition
        player.setPrimary_position(starter);
        // check if the player's primaryPosition is correct after the change
        assertEquals(player.getPrimary_position(), starter);
    }

    @Test
    public void addSecondaryPositionTest() {
        // create new Positions to add to the player
        BaseballPosition curPos = player.getPrimary_position();
        BaseballPosition firstBase = new FirstBase();
        // check that the current primary primaryPosition cannot be added
        // as a secondary position
        assertEquals(false, player.addSecondary_position(curPos));
        // check that a different position can be added as a secondary position
        assertEquals(true, player.addSecondary_position(firstBase));
        assertEquals(true, player.getSecondary_positions().contains(firstBase));
        // check that the same position that was added as a secondary position
        // cannot be added again
        assertEquals(false, player.addSecondary_position(firstBase));
        player.updateBaseballPlayer();
    }

    @Test
    public void removeSecondaryPositionTest() {
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

    @Test
    public void updatePlayerTest() {
        assertEquals(true, player.updateBaseballPlayer());
    }
}
