import java.util.ArrayList;

/**
 * Class representation of a pitcher
 *
 * @author Joshua Seward
 * @version 1.1
 */

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
     * @param age - age for pitcher
     * @param last_name - last name for pitcher
     * @param first_name - first name for pitcher
     * @param number - number for pitcher
     * @param pos - primary position for pitcher
     */
    public Pitcher(int age, String last_name, String first_name,
                   int number, String pos){
        super(age, last_name, first_name, number);
        positions = new ArrayList<Integer>();
        addPosition(pos);
    }

    /**
     * Method that checks if a position is valid for a pitcher
     * and adds it to the pitcher's list of positions if it is
     *
     * @param pos - pitcher's position where 1 is a unspecified
     *            pitcher and 11-13 are SP, RP, and CP respectively
     */
    public void addPosition(String pos){
        if(pos.equals("P"))
            positions.add(new Integer(1));
        else if(pos.equals("SP"))
            positions.add(new Integer(11));
        else if(pos.equals("RP"))
            positions.add(new Integer(12));
        else if(pos.equals("CP"))
            positions.add(new Integer(13));
        else{
            System.out.println(pos + " is an invalid pitcher position.");
            System.out.println("Please use the following as positions: P / SP / RP / CP ");
        }
    }
}
