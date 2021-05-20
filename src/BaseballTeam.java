import com.BaseballPosition.*;
import com.Exceptions.*;
import java.util.ArrayList;

/**
 * A class for a baseball team
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 19, 2021
 */
public class BaseballTeam extends Team {
    private ArrayList<BaseballPlayer> roster;

    /**
     * Constructor for a basic BaseballTeam object
     */
    public BaseballTeam() {
        super();
        roster = new ArrayList<BaseballPlayer>();
    }

    /**
     * Constructor for a specific BaseballTeam object based
     * on a given location and name
     *
     * @param location - given location
     * @param name - given name
     */
    public BaseballTeam(String location, String name) {
        super(location, name);
        roster = new ArrayList<BaseballPlayer>();
    }

    /**
     * Method to add an existing BaseballPlayer object to the
     * roster
     *
     * @param player - BaseballPlayer object to add to the roster
     */
    public void addPlayer(BaseballPlayer player) {roster.add(player);}

    /**
     * Method to generate and add a new BaseballPlayer object
     * to the roster given the new player's information
     *
     * @param first_name - given first name for the new player
     * @param last_name - given last name for the new player
     * @param number - given jersey number for the new player
     * @param position - given primary position for the new player
     */
    public void addPlayer(String first_name, String last_name, int number, BaseballPosition position) {
        BaseballPlayer newPlayer = new BaseballPlayer(first_name, last_name, number, position);
        roster.add(newPlayer);
    }

    /**
     * Method to get a specific BaseballPLayer object in the BaseballTeam
     * roster based on a given first and last name
     *
     * @param first_name - given first name
     * @param last_name - given last name
     * @return - the BaseballPlayer object with the given name
     * @throws PlayerNotFoundException - if there is no player with the given
     *                                   first and last name
     */
    public BaseballPlayer getPlayer(String first_name, String last_name) throws PlayerNotFoundException {
        for(int i = 0; i < roster.size(); ++i)
            if(roster.get(i).getFirst_name().equals(first_name) &&
               roster.get(i).getLast_name().equals(last_name))
                return roster.get(i);
        throw new PlayerNotFoundException("Player " + first_name + " " + last_name + " does not play for the " +
                                          getLocation() + " " + getName());
    }

    /**
     * Method to get a specific BaseballPLayer object in the BaseballTeam
     * roster based on a given jersey number
     *
     * @param number - given jersey number
     * @return - the BaseballPlayer object with the given jersey number
     * @throws PlayerNotFoundException - if there is no player with the given
     *                                   jersey number
     */
    public BaseballPlayer getPlayer(int number) throws  PlayerNotFoundException {
        for(int i = 0; i < roster.size(); ++i)
            if(roster.get(i).getNumber().equals(number))
                return roster.get(i);
        throw new PlayerNotFoundException("There is not a player with the number " + number + " on the " +
                                          getLocation() + " " + getName());
    }
}
