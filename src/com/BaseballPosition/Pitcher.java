package com.BaseballPosition;

/**
 * A class for the pitcher position in baseball
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 8, 2021
 */
public class Pitcher implements BaseballPosition {
    private final Integer PITCHER_NUM = 1;

    /**
     * Method that gives the numerical representation of
     * a pitcher
     *
     * @return - numerical representation of a pitcher
     */
    public Integer posNumber(){return PITCHER_NUM;}

    /**
     * Method that gives the String representation of a
     * pitcher
     *
     * @return - String representation of a pitcher
     */
    @Override
    public String toString() {return "P";}

    /**
     * Method that compares the Pitcher object to another
     * BaseballPosition object
     *
     * @param pos - BaseballPosition object to compare
     *            the Pitcher object to
     * @return - the difference between the numerical
     *           representation of the given BaseballPosition
     *           and the Pitcher object
     */
    @Override
    public int compareTo(BaseballPosition pos) {return pos.posNumber() - PITCHER_NUM;}
}
