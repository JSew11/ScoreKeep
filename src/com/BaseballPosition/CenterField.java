package com.BaseballPosition;

/**
 * A class for the center field position in baseball
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 8, 2021
 */
public class CenterField implements BaseballPosition {
    private final Integer CENTER_FIELD_NUM = Integer.valueOf(8);

    /**
     * Method that gives the numerical representation of
     * center field
     *
     * @return - numerical representation of a center field
     */
    public Integer posNumber(){return CENTER_FIELD_NUM;}

    /**
     * Method that compares the CenterField object to another
     * BaseballPosition object
     *
     * @param pos - BaseballPosition object to compare
     *            the CenterField object to
     * @return - the difference between the numerical
     *           representation of the given BaseballPosition
     *           and the CenterField object
     */
    @Override
    public int compareTo(BaseballPosition pos) {return pos.posNumber() - CENTER_FIELD_NUM;}

    /**
     * Method that gives the String representation of
     * center field
     *
     * @return - String representation of center field
     */
    @Override
    public String toString() {return "CF";}
}
