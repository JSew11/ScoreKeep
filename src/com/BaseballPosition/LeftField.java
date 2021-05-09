package com.BaseballPosition;

/**
 * A class for the left field position in baseball
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 8, 2021
 */
public class LeftField implements BaseballPosition {
    private final Integer LEFT_FIELD_NUM = Integer.valueOf(7);

    /**
     * Method that gives the numerical representation of
     * left field
     *
     * @return - numerical representation of left field
     */
    public Integer posNumber(){return LEFT_FIELD_NUM;}

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
    public int compareTo(BaseballPosition pos) {return pos.posNumber() - LEFT_FIELD_NUM;}

    /**
     * Method that gives the String representation of
     * left field
     *
     * @return - String representation of left field
     */
    @Override
    public String toString() {return "LF";}
}
