import com.BaseballPosition.*;
import java.util.ArrayList;

/**
 * A class for a baseball player
 *
 * @author - Joshua Seward
 * @version - 1.1.
 * @since - May 8, 2021
 */
public class BaseballPlayer extends Athlete {
    private BaseballPosition primary_position;
    private ArrayList<BaseballPosition> secondary_positions;
    private BaseballPlayerStats stats;

    /**
     * Constructor for a basic BaseballPlayer object
     */
    public BaseballPlayer() {
        super();
    }

    /**
     * Overloaded constructor for a specific BaseballPlayer object
     *
     * @param first_name - player's first name
     * @param last_name  - player's last name
     * @param number     - player's jersey number
     * @param position   - player's primary position
     */
    public BaseballPlayer(String first_name, String last_name, int number, BaseballPosition position) {
        super(first_name, last_name, number);
        primary_position = position;
        secondary_positions = new ArrayList<BaseballPosition>();
        stats = new BaseballPlayerStats(first_name, last_name);
    }

    /**
     * Accessor for the baseball player's primary position
     *
     * @return - baseball player's primary position
     */
    public BaseballPosition getPrimary_position() {return primary_position;}

    /**
     * Mutator for the baseball player's primary position
     *
     * @param primary_position - baseball player's primary position
     */
    public void setPrimary_position(BaseballPosition primary_position) {this.primary_position = primary_position;}

    /**
     * Accessor for the baseball player's secondary positions
     *
     * @return - baseball player's secondary positions
     */
    public ArrayList<BaseballPosition> getSecondary_positions() {return secondary_positions;}

    /**
     * Method to add a new secondary position to the ArrayList of
     * BaseballPositions
     *
     * @param position - BaseballPosition to add to the ArrayList
     * @return - Whether the position was added correctly
     */
    public boolean addSecondary_position(BaseballPosition position) {
        if(!secondary_positions.contains(position) && position.compareTo(primary_position) != 0) {
            secondary_positions.add(position);
            return true;
        }
        return false;
    }

    /**
     * Method to remove a secondary position from the ArrayList of
     * BaseballPositions
     *
     * @param position - BaseballPosition to remove from the ArrayList
     */
    public void removeSecondary_position(BaseballPosition position) {secondary_positions.remove(position);}

    /**
     * Accessor for the baseball player's BaseballPlayerStats object
     *
     * @return - baseball player's BaseballPlayerStats object
     */
    public BaseballPlayerStats getStats() {return stats;}

    /**
     * Method to update all of the player's stats files
     *
     * @return - boolean value representing whether the files were
     *           updated successfully
     */
    public boolean updateStats(){
        return stats.updateStats();
    }
}
