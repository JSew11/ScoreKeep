package com.BaseballStats;

/**
 * A class with methods to calculate more complex
 * fielding stats
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 15, 2021
 */
public class FieldingCalc {
    /**
     * Method to calculate number of chances
     *
     * @param putouts - number of putouts
     * @param assists - number of assists
     * @param errors - number of errors
     * @return - number if chances
     */
    public int chances(int putouts, int assists, int errors) {
        return putouts + assists + errors;
    }

    /**
     * Method to calculate fielding percentage
     *
     * @param putouts - number of putouts
     * @param assists - number of assists
     * @param errors - number of errors
     * @return - fielding percentage
     */
    public double fieldingPercent(int putouts, int assists, int errors) {
        int chances = chances(putouts,assists,errors);
        if(chances == 0) return 0.0;
        return ((double) (putouts + assists)) / ((double) chances);
    }

    /**
     * Method to calculate range factor per 9 innings
     *
     * @param putouts - number of putouts
     * @param assists - number of assists
     * @param inningsPlayed - number of innings played
     * @return - range factor per 9 innings
     */
    public double RF9(int putouts, int assists, double inningsPlayed) {
        if(inningsPlayed == 0.0) return 0.0;
        return (9.0 * ((double) (putouts+assists)))/inningsPlayed;
    }
}
