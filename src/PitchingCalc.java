/**
 * A class with methods to calculate more complex
 * pitching stats
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 12, 2021
 */
public class PitchingCalc {
    /**
     * Method to calculate the percentage of strikes thrown
     * out of total pitches thrown
     *
     * @param strikesThrown - number of strikes thrown
     * @param pitchesThrown - number of total pitches thrown
     * @return - percentage of strikes thrown out of total
     *           pitches thrown
     */
    public double strikePercent(int strikesThrown, int pitchesThrown) {
        if(pitchesThrown == 0) return 0.0;
        return ((double) strikesThrown) / ((double) pitchesThrown);
    }

    /**
     * Method to calculate win-loss percentage
     *
     * @param wins - number of wins
     * @param losses - number of losses
     * @return - win-loss percentage
     */
    public double winLossPercent(int wins, int losses) {
        if(wins + losses == 0) return 0.0;
        return ((double) wins) / ((double) wins + losses);
    }

    /**
     * Method to calculate ERA (earned runs average)
     *
     * @param earnedRuns - number of earned runs
     * @param inningsPitched - number of innings pitched
     * @return - ERA (earned runs average)
     */
    public double ERA(int earnedRuns, double inningsPitched) {
        if(inningsPitched == 0.0) return 0.0;
        return (9.0 * earnedRuns) / inningsPitched;
    }

    /**
     * Method to calculate WHIP
     *
     * @param walks - number of walks
     * @param hits - number of hits
     * @param inningsPitched - number of innings pitched
     * @return - WHIP = (walks + hits) / innings pitched
     */
    public double WHIP(int walks, int hits, double inningsPitched) {
        if(inningsPitched == 0.0) return 0.0;
        return ((double) walks + hits) / inningsPitched;
    }

    /**
     * Method to calculate hits / 9 innings
     *
     * @param hits - number of hits
     * @param inningsPitched - number of innings pitched
     * @return - number of hits / 9 innings
     */
    public double H9(int hits, double inningsPitched) {
        if(inningsPitched == 0.0) return 0.0;
        return (9.0 * hits) / inningsPitched;
    }

    /**
     * Method to calculate home runs / 9 innings
     *
     * @param homeRuns - number of home runs
     * @param inningsPitched - number of innings pitched
     * @return - number of home runs / 9 innings
     */
    public double HR9(int homeRuns, double inningsPitched) {
        if(inningsPitched == 0.0) return 0.0;
        return (9.0 * homeRuns) / inningsPitched;
    }

    /**
     * Method to calculate walks / 9 innings
     *
     * @param walks - number of walks
     * @param inningsPitched - number of innings pitched
     * @return - number of walks / 9 innings
     */
    public double BB9(int walks, double inningsPitched) {
        if(inningsPitched == 0.0) return 0.0;
        return (9.0 * walks) / inningsPitched;
    }

    /**
     * Method to calculate strikeouts / 9 innings
     *
     * @param strikeouts - number of walks
     * @param inningsPitched - number of innings pitched
     * @return - number of strikeouts / 9 innings
     */
    public double K9(int strikeouts, double inningsPitched) {
        if(inningsPitched == 0.0) return 0.0;
        return (9.0 * strikeouts) / inningsPitched;
    }
}
