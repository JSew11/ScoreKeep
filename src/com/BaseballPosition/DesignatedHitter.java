package com.BaseballPosition;

/**
 * A class for the designated hitter position in baseball
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 8, 2021
 */
public class DesignatedHitter implements BaseballPosition{
    private final Integer DH_NUM = Integer.valueOf(10);

    /**
     * Method that gives the numerical representation of
     * designated hitter
     *
     * @return - numerical representation of a designated
     *           hitter
     */
    public Integer posNumber(){return DH_NUM;}

    /**
     * Method that compares the DesignatedHitter object to
     * another BaseballPosition object
     *
     * @param pos - BaseballPosition object to compare
     *            the DesignatedHitter object to
     * @return - the difference between the numerical
     *           representation of the given BaseballPosition
     *           and the DesignatedHitter object
     */
    @Override
    public int compareTo(BaseballPosition pos) {return pos.posNumber() - DH_NUM;}

    /**
     * Method that gives the String representation of
     * designated hitter
     *
     * @return - String representation of designated
     *           hitter
     */
    @Override
    public String toString() {return "DH";}
}
