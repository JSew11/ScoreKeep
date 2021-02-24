/**
 * Class representation of a pitcher
 *
 * @author Joshua Seward
 * @version 1.0
 */

import java.util.ArrayList;

public class Pitcher extends Player{
    private ArrayList<Integer> positions;

    /**
     * Constructor for a generic pitcher
     */
    public Pitcher(){
        super();
        positions = new ArrayList<Integer>();
    }
    /**
     * Constructor for a specific pitcher
     *
     * @param age
     * @param last_name
     * @param first_name
     * @param number
     * @param pos
     */
    public Pitcher(int age, String last_name, String first_name,
                   int number, int pos){
        super(age, last_name, first_name, number);
        positions = new ArrayList<Integer>();
        addPosition(pos);
    }

    /**
     * Method that checks if a position is valid for a pitcher
     * and adds it to the pitcher's list of positions if it is
     *
     * @param pos - pitcher's position
     */
    public void addPosition(int pos){
        if(pos == 1 || (pos > 9 && pos < 13))
            positions.add(new Integer(pos));
    }
}
