package com.BaseballPosition;

/**
 * A class for an extra position in baseball (PR/PH/DH/EH)
 *
 * @author - Joshua Seward
 * @version - 2.0.0
 * @since - May 8, 2021
 */
public class Extra implements BaseballPosition {
    private final Integer EXTRA_NUM = 10;

    /**
     * Method that gives the numerical representation of
     * extra
     *
     * @return - numerical representation of an extra
     */
    @Override
    public Integer posNumber() {return EXTRA_NUM;}

    /**
     * Method that compares the Extra object to another
     * BaseballPosition object
     *
     * @param pos - BaseballPosition object to compare
     *            the Extra object to
     * @return - the difference between the numerical
     *           representation of the given BaseballPosition
     *           and the Extra object
     */
    @Override
    public int compareTo(BaseballPosition pos) {return pos.posNumber() - EXTRA_NUM;}
}
