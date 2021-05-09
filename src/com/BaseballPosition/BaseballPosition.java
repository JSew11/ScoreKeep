package com.BaseballPosition;

/**
 * An interface for a position in baseball
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 8, 2021
 */
interface BaseballPosition extends Comparable<BaseballPosition> {
    /**
     * Method that gives the numerical representation of
     * the baseball position
     *
     * @return - numerical representation of the position
     */
    public Integer posNumber();
}