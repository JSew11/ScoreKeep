package com.BaseballPosition;

/**
 * A class for the shortstop position in baseball
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 8, 2021
 */
public class Shortstop implements BaseballPosition {
    private final Integer SHORTSTOP_NUM = Integer.valueOf(6);

    /**
     * Method that gives the numerical representation of
     * shortstop
     *
     * @return - numerical representation of shortstop
     */
    @Override
    public Integer posNumber() {return SHORTSTOP_NUM;}

    /**
     * Method that compares the Shortstop object to another
     * BaseballPosition object
     *
     * @param pos - BaseballPosition object to compare
     *            the Shortstop object to
     * @return - the difference between the numerical
     *           representation of the given BaseballPosition
     *           and the Shortstop object
     */
    @Override
    public int compareTo(BaseballPosition pos) {return pos.posNumber() - SHORTSTOP_NUM;}

    /**
     * Method that gives the String representation of
     * shortstop
     *
     * @return - String representation of shortstop
     */
    @Override
    public String toString() {return "SS";}
}
