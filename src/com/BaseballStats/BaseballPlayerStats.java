package com.BaseballStats;

/**
 * A class for the stats of a baseball player
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 11, 2021
 */
public class BaseballPlayerStats {
    private String statFileName;
    // stats objects
    private PitchingStats pitchingStats;
    private BattingStats battingStats;
    private FieldingStats fieldingStats;

    /**
     * Constructor to create a com.BaseballStats.BaseballPlayerStats object using
     *
     * @param first_name - first name of the baseball player whose
     *                     stats are being kept
     * @param last_name - last name of the baseball player whose
     *                    stats are being kept
     */
    public BaseballPlayerStats(String first_name, String last_name) {
        statFileName = first_name + last_name;
        pitchingStats = new PitchingStats(statFileName);
        battingStats = new BattingStats(statFileName);
        fieldingStats = new FieldingStats(statFileName);
    }

    /**
     * Method to update all stat files
     *
     * @return - boolean value representing whether the files were
     *           updated successfully
     */
    public boolean updateStats() {
        if(!pitchingStats.updatePitchingStatsFile()) return false;
        if(!battingStats.updateBattingStatsFile()) return false;
        if(!fieldingStats.updateFieldingStatsFile()) return false;
        return true;
    }
}
