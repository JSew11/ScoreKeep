/**
 * Class representation of a batter
 *
 * @author Joshua Seward
 * @version 1.0
 */

import java.util.ArrayList;

public class Batter extends Player{
    private ArrayList<Integer> positions;

    /**
     * Constructor for a generic batter
     */
    public Batter(){
        super();
        positions = new ArrayList<Integer>();
    }
    /**
     * Constructor for a specific batter
     *
     * @param age - batter's age
     * @param last_name - batter's last name
     * @param first_name - batter's first name
     * @param number - batter's jersey number
     */
    public Batter(int age, String last_name, String first_name,
                  int number, int pos){
        super(age, last_name, first_name, number);
        positions = new ArrayList<Integer>();
        positions.add(new Integer(pos));
    }

    /**
     * Method that checks if a position is valid for a batter
     * and adds it to the batter's list of positions if it is
     *
     * @param pos - batter's position
     */
    public void addPosition(int pos){
        if(pos == 0 || (pos > 1 && pos < 10))
            positions.add(new Integer(pos));
    }
}
