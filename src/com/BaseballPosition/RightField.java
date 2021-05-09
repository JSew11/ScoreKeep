package com.BaseballPosition;

/**
 * A class for the right field position in baseball
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 8, 2021
 */
public class RightField implements BaseballPosition{
    private final Integer RIGHT_FIELD_NUM = Integer.valueOf(9);

    /**
     * Method that gives the numerical representation of
     * right field
     *
     * @return - numerical representation of a right field
     */
    public Integer posNumber(){return RIGHT_FIELD_NUM;}

    /**
     * Method that compares the RightField object to another
     * BaseballPosition object
     *
     * @param pos - BaseballPosition object to compare
     *            the RightField object to
     * @return - the difference between the numerical
     *           representation of the given BaseballPosition
     *           and the RightField object
     */
    @Override
    public int compareTo(BaseballPosition pos) {return pos.posNumber() - RIGHT_FIELD_NUM;}

    /**
     * Method that gives the String representation of
     * right field
     *
     * @return - String representation of right field
     */
    @Override
    public String toString() {return "RF";}
}
