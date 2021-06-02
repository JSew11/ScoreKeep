package com.Exceptions;

/**
 * An exception for when a desired com.BaseballBasics.BaseballPlayer object
 * does not exist
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 19, 2021
 */
public class PlayerNotFoundException extends Exception {
    /**
     * Constructor for a PlayerNotFoundException
     *
     * @param errorMessage - error message for the new
     *                       PlayerNotFoundException
     */
    public PlayerNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
