/**
 * Class representation of a batter
 *
 * @author Joshua Seward
 * @version 1.0
 */

import java.util.ArrayList;

public class Batter extends Player{
    private int number;
    private ArrayList<Integer> positions;

    /**
     * Constructor for a generic batter object
     */
    public Batter(){
        setAge(-1);
        setLast("Last");
        setFirst("First");
        number = -1;
        positions = new ArrayList<Integer>();
    }

    /**
     * Constructor for a specific batter object
     *
     * @param age - batter's age
     * @param last_name - batter's last name
     * @param first_name - batter's first name
     * @param number - batter's jersey number
     */
    public Batter(int age, String last_name, String first_name,
                  int number, int pos){
        setAge(age);
        setLast(last_name);
        setFirst(first_name);
        this.number = number;
        addPosition(pos);
    }

    /**
     * Method that checks if a position is valid for a batter
     * and adds it to the batter's list of positions if it is
     *
     * @param pos - batter's position
     */
    public void addPosition(int pos){
        if(pos > 1 && pos < 11)
            positions.add(new Integer(pos));
    }

    /**
     * Getter for the batter's number
     *
     * @return - gives batter's number
     */
    public int getNumber(){ return number;}
}
