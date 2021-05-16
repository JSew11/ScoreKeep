package com.BaseballStats;

/**
 * A class with methods to calculate more complex
 * batting stats
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 15, 2021
 */
public class BattingCalc {
    /**
     * Method to calculate batting average
     *
     * @param hits - number of hits
     * @param atBats - number of at bats
     * @return - batting average
     */
    public double BA(int hits, int atBats) {
        if(atBats == 0) return 0.0;
        return ((double) hits)/((double) atBats);
    }

    /**
     * Method to calculate on base percentage
     *
     * @param hits - number of hits
     * @param walks - number of walks
     * @param hitByPitch - number of times being hit by a pitch
     * @param atBats - number of at bats
     * @param sacFlies - number of sacrifice flies
     * @return - on base percentage
     */
    public double OBP(int hits, int walks, int hitByPitch, int atBats, int sacFlies) {
        int denom = atBats + walks + hitByPitch + sacFlies;
        if(denom == 0) return 0.0;
        return ((double) (hits + walks + hitByPitch))/((double) denom);
    }

    /**
     * Method to calculate the number of total bases
     *
     * @param hits - number of hits
     * @param doubles - number of doubles
     * @param triples - number of triples
     * @param homeRuns - number of home runs
     * @return - number of total bases
     */
    public int TB(int hits, int doubles, int triples, int homeRuns) {
        int singles = hits - doubles - triples - homeRuns;
        return singles + (2*doubles) + (3*triples) + (4*homeRuns);
    }

    /**
     * Method to calculate slugging percentage
     *
     * @param hits - number of hits
     * @param doubles - number of doubles
     * @param triples - number of triples
     * @param homeRuns - number of home runs
     * @param atBats - number of at bats
     * @return - slugging percentage
     */
    public double SLG(int hits, int doubles, int triples, int homeRuns, int atBats) {
        return ((double) TB(hits,doubles,triples,homeRuns))/((double) atBats);
    }

    /**
     * Method to calculate on base plus slugging percentages
     *
     * @param hits - number of hits
     * @param doubles - number of doubles
     * @param triples - number of triples
     * @param homeRuns - number of home runs
     * @param walks - number of walks
     * @param hitByPitch - number of times being hit by a pitch
     * @param atBats - number of at bats
     * @param sacFlies - number of sacrifice flies
     * @return - on base plus slugging percentages
     */
    public double OPS(int hits, int doubles, int triples, int homeRuns,
                      int walks, int hitByPitch, int atBats, int sacFlies) {
        return OBP(hits,walks,hitByPitch,atBats,sacFlies) + SLG(hits,doubles,triples,homeRuns,atBats);
    }
}
