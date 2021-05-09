package com.BaseballPosition;

/**
 * A class for the catcher position in baseball
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 8, 2021
 */
public class Catcher implements BaseballPosition {
    private final Integer CATCHER_NUM = Integer.valueOf(2);

    /**
     * Method that gives the numerical representation of
     * catcher
     *
     * @return - numerical representation of catcher
     */
    @Override
    public Integer posNumber() {return CATCHER_NUM;}

    /**
     * Method that compares the Catcher object to another
     * BaseballPosition object
     *
     * @param pos - BaseballPosition object to compare
     *            the Catcher object to
     * @return - the difference between the numerical
     *           representation of the given BaseballPosition
     *           and the Catcher object
     */
    @Override
    public int compareTo(BaseballPosition pos) {return pos.posNumber() - CATCHER_NUM;}

    /**
     * Method that gives the String representation of
     * catcher
     *
     * @return - String representation of catcher
     */
    @Override
    public String toString(){return "C";}
}
