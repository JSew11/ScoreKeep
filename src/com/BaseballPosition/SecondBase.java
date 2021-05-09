package com.BaseballPosition;

/**
 * A class for the second base position in baseball
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 8, 2021
 */
public class SecondBase implements BaseballPosition{
    private final Integer SECOND_BASE_NUM = Integer.valueOf(4);

    /**
     * Method that gives the numerical representation of
     * second base
     *
     * @return - numerical representation of second base
     */
    @Override
    public Integer posNumber() {return SECOND_BASE_NUM;}

    /**
     * Method that compares the SecondBase object to another
     * BaseballPosition object
     *
     * @param pos - BaseballPosition object to compare
     *            the SecondBase object to
     * @return - the difference between the numerical
     *           representation of the given BaseballPosition
     *           and the SecondBase object
     */
    @Override
    public int compareTo(BaseballPosition pos) {return pos.posNumber() - SECOND_BASE_NUM;}

    /**
     * Method that gives the String representation of
     * second base
     *
     * @return - String representation of second base
     */
    @Override
    public String toString() {return "2B";}
}
