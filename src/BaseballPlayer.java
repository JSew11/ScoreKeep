/**
 * Class representation of a baseball player
 *
 * @author Joshua Seward
 * @version 1.0
 */

public class BaseballPlayer extends Person{
    private int number;
    private int position;

    /**
     * Constructor for a generic baseball player
     */
    public BaseballPlayer(){
        setAge(-1);
        setLast("Last");
        setFirst("First");
        position = -1;
        number = -1;
    }

    /**
     * Constructor for a specific baseball player
     *
     * @param age
     * @param last_name
     * @param first_name
     * @param number
     * @param position
     */
    public BaseballPlayer(int age, String last_name, String first_name,
                          int number, int position){
        setAge(age);
        setLast(last_name);
        setFirst(first_name);
        this.number = number;
        this.position = position;
    }

    /** @return gives the player's number */
    public int getNumber(){ return number;}
    /**@return gives the position if it is valid,
     *         otherwise gives -1 */
    public int getPosition(){
        if(position > 0 && position < 10)
            return position;
        else return -1;
    }
    /** @param number the player's number */
    public void setNumber(int number){ this.number = number;}
    /** @param position the player's number */
    public void setPosition(int position){ this.position = position;}
}
