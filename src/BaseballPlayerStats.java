/**
 * A class for the stats of a baseball player
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 11, 2021
 */
public class BaseballPlayerStats {
    private PitchingStats pitchingStats;
    private String pitchingStatsFileName;

    /**
     * Constructor to create a BaseballPlayerStats object using
     *
     * @param playerName - name of the baseball player whose stats
     *                     are being kept
     */
    public BaseballPlayerStats(String playerName) {
        pitchingStatsFileName = playerName + "_pitching.txt";
        pitchingStats = new PitchingStats(pitchingStatsFileName);
    }

    /**
     * Method to update all stat files
     *
     * @return - boolean value representing whether the files were
     *           updated successfully
     */
    public boolean updateStats() {
        if(!pitchingStats.updatePitchingStatsFile()) return false;
        return true;
    }
}
