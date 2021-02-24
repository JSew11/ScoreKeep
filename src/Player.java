/**
 * Class representation of a person
 *
 * @author Joshua Seward
 * @version 1.1
 */

public class Player {
    private int age;
    private String first_name;
    private String last_name;
    public int number;

    /**
     * Getter for the player's age
     *
     * @return - gives player's age
     */
    public int getAge(){ return age;}
    /**
     * Getter for the player's last name
     *
     * @return - gives player's last name
     */
    public String getLast(){ return last_name;}
    /**
     * Getter for the player's first name
     *
     * return - gives player's first name
     */
    public String getFirst(){ return first_name;}
    /**
     * Getter for the player's number
     *
     * @return - gives the player's number
     */
    public int getNumber(){ return number;}
    /**
     * Setter for the player's age
     *
     * @param age - age for the player
     */
    public void setAge(int age){ this.age = age;}
    /**
     * Setter for the player's last name
     *
     * @param last_name - last name for the player
     */
    public void setLast(String last_name){ this.last_name = last_name;}
    /**
     * Setter for the player's first name
     *
     * @param first_name - first name for the player
     */
    public void setFirst(String first_name){ this.first_name = first_name;}
    /**
     * Setter for the player's number
     *
     * @param number - number for the player
     */
    public void setNumber(int number){ this.number = number;}
}
