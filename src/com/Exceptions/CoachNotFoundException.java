package com.Exceptions;

/**
 * An exception for when the desired BaseballCoach object
 * does not exist
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 21, 2021
 */
public class CoachNotFoundException extends Exception {
    /**
     * Constructor for a CoachNotFoundException
     *
     * @param errorMessage - error message for the new
     *                       CoachNotFoundException
     */
    public CoachNotFoundException(String errorMessage) {super(errorMessage);}
}
