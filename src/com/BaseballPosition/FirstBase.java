package com.BaseballPosition;

/**
 * A class for the first base position in baseball
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 8, 2021
 */
public class FirstBase implements BaseballPosition {
    private final Integer FIRST_BASE_NUM = Integer.valueOf(3);

    /**
     * Method that gives the numerical representation
     * first base
     *
     * @return - numerical representation of first base
     */
    @Override
    public Integer posNumber() {return FIRST_BASE_NUM;}

    /**
     * Method that compares the FirstBase object to another
     * BaseballPosition object
     *
     * @param pos - BaseballPosition object to compare
     *            the FirstBase object to
     * @return - the difference between the numerical
     *           representation of the given BaseballPosition
     *           and the FirstBase object
     */
    @Override
    public int compareTo(BaseballPosition pos) {return pos.posNumber() - FIRST_BASE_NUM;}

    /**
     * Method that gives the String representation of
     * first base
     *
     * @return - String representation of first base
     */
    @Override
    public String toString() {return "1B";}
}
