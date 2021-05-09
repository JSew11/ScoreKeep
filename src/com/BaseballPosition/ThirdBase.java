package com.BaseballPosition;

/**
 * A class for the third base position in baseball
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 8, 2021
 */
public class ThirdBase implements BaseballPosition {
    private final Integer THIRD_BASE_NUM = Integer.valueOf(5);

    /**
     * Method that gives the numerical representation of
     * third base
     *
     * @return - numerical representation of third base
     */
    @Override
    public Integer posNumber() {return THIRD_BASE_NUM;}

    /**
     * Method that compares the ThirdBase object to another
     * BaseballPosition object
     *
     * @param pos - BaseballPosition object to compare
     *            the ThirdBase object to
     * @return - the difference between the numerical
     *           representation of the given BaseballPosition
     *           and the ThirdBase object
     */
    @Override
    public int compareTo(BaseballPosition pos) {return pos.posNumber() - THIRD_BASE_NUM;}

    /**
     * Method that gives the String representation of
     * third base
     *
     * @return - String representation of third base
     */
    @Override
    public String toString() {return "3B";}
}
