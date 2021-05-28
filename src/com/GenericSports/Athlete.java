package com.GenericSports;

/**
 * A class for an athlete
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 8, 2021
 */
public class Athlete {
    private String first_name;
    private String last_name;
    private Integer number;

    /**
     * Constructor for a basic com.GenericSports.Athlete object
     */
    public Athlete() {
        first_name = "";
        last_name = "";
    }

    /**
     * Overloaded constructor for a specific com.GenericSports.Athlete object
     *
     * @param first_name - athlete's first name
     * @param last_name - athlete's last name
     * @param number - athlete's jersey number
     */
    public Athlete(String first_name, String last_name, int number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.number = Integer.valueOf(number);
    }

    /**
     * Accessor for the athlete's first name
     *
     * @return - the athlete's first name
     */
    public String getFirst_name() {return first_name;}

    /**
     * Mutator to set the athlete's first name
     *
     * @param first_name - the athlete's first name
     */
    public void setFirst_name(String first_name) {this.first_name = first_name;}

    /**
     * Accessor for the athlete's last name
     *
     * @return - the athlete's last name
     */
    public String getLast_name() {return last_name;}

    /**
     * Mutator to set the athlete's last name
     *
     * @param last_name - the athlete's last name
     */
    public void setLast_name(String last_name) {this.last_name = last_name;}

    /**
     * Accessor for the athlete's jersey number
     *
     * @return - the athlete's jersey number
     */
    public Integer getNumber() {return number;}

    /**
     * Mutator to set the athlete's jersey number
     *
     * @param number - the athlete's jersey number
     */
    public void setNumber(int number) {this.number = Integer.valueOf(number);}
}
