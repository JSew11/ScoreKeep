package com.BaseballStats;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit testing for the FieldingStats class
 *
 * @author - Joshua Seward
 */
public class FieldingStatsTest {
    FieldingStats JoshuaSewardFieldingStats;

    @Test
    public void newPlayerFieldingStats() {
        FieldingStats newFielder = new FieldingStats("NewPlayer");
        // check that the stats are initialized to 0
        assertEquals(0, newFielder.getGamesPlayed());
        assertEquals(0, newFielder.getPutouts());
        assertEquals(0, newFielder.getErrors());
        assertEquals(0, newFielder.getChances());
        assertEquals(0, newFielder.getRF9());
    }

    @Test
    public void setPlayerInningsPlayed() {
        JoshuaSewardFieldingStats =
                new FieldingStats("JoshuaSeward");
        // test multiple inputs for innings_played
        JoshuaSewardFieldingStats.setInningsPlayed(54.0 + (1.0/3.0));
        assertEquals(54.1, JoshuaSewardFieldingStats.getInningsPlayed());
        assertEquals((54.0 + (1.0/3.0)), JoshuaSewardFieldingStats.actualInningsPlayed());
        JoshuaSewardFieldingStats.setInningsPlayed(54.0 + (2.0/3.0));
        assertEquals(54.2, JoshuaSewardFieldingStats.getInningsPlayed());
        assertEquals((54.0 + (2.0/3.0)), JoshuaSewardFieldingStats.actualInningsPlayed());
        JoshuaSewardFieldingStats.setInningsPlayed(54.0);
        assertEquals(54., JoshuaSewardFieldingStats.getInningsPlayed());
        assertEquals((54.0), JoshuaSewardFieldingStats.actualInningsPlayed());
    }

    @Test
    public void updateFieldingStatsFile() {
        JoshuaSewardFieldingStats =
                new FieldingStats("JoshuaSeward");
        // set stats from my high school baseball career
        JoshuaSewardFieldingStats.setGamesPlayed(32);
        JoshuaSewardFieldingStats.setPutouts(18);
        JoshuaSewardFieldingStats.setAssists(1);
        JoshuaSewardFieldingStats.setErrors(1);
        JoshuaSewardFieldingStats.setDoublePlays(1);
        // check that the file updates successfully
        assertEquals(true, JoshuaSewardFieldingStats.updateFieldingStatsFile());
    }

    @Test
    public void existingPlayerStats() {
        JoshuaSewardFieldingStats =
                new FieldingStats("JoshuaSeward");
        assertEquals(32, JoshuaSewardFieldingStats.getGamesPlayed());
        assertEquals(18, JoshuaSewardFieldingStats.getPutouts());
        assertEquals(1, JoshuaSewardFieldingStats.getAssists());
        assertEquals(1, JoshuaSewardFieldingStats.getErrors());
        assertEquals(1, JoshuaSewardFieldingStats.getDoublePlays());
    }
}
