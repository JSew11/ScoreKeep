package com.BaseballLineup;

/**
 * A class for a baseball lineup
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - June 3, 2021
 */
public class BaseballLineup {
    private BaseballOnFieldLineup fieldLineup;
    private BaseballBattingOrder battingOrder;

    /**
     * Constructor for a BaseballLineup object
     */
    public BaseballLineup() {
        fieldLineup = new BaseballOnFieldLineup();
        battingOrder = new BaseballBattingOrder();
    }

    // attribute accessors
    public BaseballOnFieldLineup getFieldLineup() {return fieldLineup;}
    public BaseballBattingOrder getBattingOrder() {return battingOrder;}
}
