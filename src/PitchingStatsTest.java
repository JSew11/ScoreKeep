import jdk.nashorn.internal.scripts.JO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit testing for the PitchingStats class
 *
 * @author - Joshua Seward
 */
public class PitchingStatsTest {
    PitchingStats JoshuaSeward_pitchingStats =
                new PitchingStats("JoshuaSeward_pitching.txt");

    @Test
    public void newPlayerPitchingStats() {
        PitchingStats newPitcher = new PitchingStats("NewPlayer_pitching.txt");
        // check that the stats are initialized to 0
        assertEquals(0, newPitcher.getPitchesThrown());
        assertEquals(0, newPitcher.getGamesPitched());
        assertEquals(0, newPitcher.getCompleteGames());
        assertEquals(0.0, newPitcher.getInningsPitched());
        assertEquals(0, newPitcher.getHomeRuns());
        assertEquals(0, newPitcher.getHitByPitch());
    }

    @Test
    public void setPlayerInningsPitched() {
        // test multiple inputs for innings pitched
        JoshuaSeward_pitchingStats.setInningsPitched(92.0 + 2.0/3.0);
        assertEquals(92.2, JoshuaSeward_pitchingStats.getInningsPitched());
        assertEquals(92.0 + (2.0/3.0), JoshuaSeward_pitchingStats.actualInningsPitched());
        JoshuaSeward_pitchingStats.setInningsPitched(92.1);
        assertEquals(92.1, JoshuaSeward_pitchingStats.getInningsPitched());
        assertEquals(92.0 + (1.0/3.0), JoshuaSeward_pitchingStats.actualInningsPitched());
        JoshuaSeward_pitchingStats.setInningsPitched(92.0);
        assertEquals(92.0, JoshuaSeward_pitchingStats.getInningsPitched());
    }

    @Test
    public void updatePitchingStatsFile() {
        // set stats from my high school baseball career
        JoshuaSeward_pitchingStats.setGamesPitched(23);
        JoshuaSeward_pitchingStats.setGamesStarted(17);
        JoshuaSeward_pitchingStats.setWins(12);
        JoshuaSeward_pitchingStats.setLosses(2);
        JoshuaSeward_pitchingStats.setShutouts(1);
        JoshuaSeward_pitchingStats.setSaves(1);
        JoshuaSeward_pitchingStats.setInningsPitched(92.0);
        JoshuaSeward_pitchingStats.setHits(71);
        JoshuaSeward_pitchingStats.setRuns(23);
        JoshuaSeward_pitchingStats.setEarnedRuns(19);
        JoshuaSeward_pitchingStats.setHomeRuns(2);
        JoshuaSeward_pitchingStats.setWalks(27);
        JoshuaSeward_pitchingStats.setStrikeouts(78);
        JoshuaSeward_pitchingStats.setHitByPitch(8);
        JoshuaSeward_pitchingStats.setPickOffs(1);
        JoshuaSeward_pitchingStats.setBattersFaced(376);
        assertEquals(true, JoshuaSeward_pitchingStats.updatePitchingStatsFile());
    }
    
    @Test
    public void existingPlayerStats() {
        // check that the stats are initialized to the correct values
        assertEquals(23, JoshuaSeward_pitchingStats.getGamesPitched());
        assertEquals(17, JoshuaSeward_pitchingStats.getGamesStarted());
        assertEquals(12, JoshuaSeward_pitchingStats.getWins());
        assertEquals(2, JoshuaSeward_pitchingStats.getLosses());
        assertEquals(1, JoshuaSeward_pitchingStats.getShutouts());
        assertEquals(1, JoshuaSeward_pitchingStats.getSaves());
        assertEquals(92.0, JoshuaSeward_pitchingStats.getInningsPitched());
        assertEquals(71, JoshuaSeward_pitchingStats.getHits());
        assertEquals(23, JoshuaSeward_pitchingStats.getRuns());
        assertEquals(19, JoshuaSeward_pitchingStats.getEarnedRuns());
        assertEquals(2, JoshuaSeward_pitchingStats.getHomeRuns());
        assertEquals(27, JoshuaSeward_pitchingStats.getWalks());
        assertEquals(78, JoshuaSeward_pitchingStats.getStrikeouts());
        assertEquals(8, JoshuaSeward_pitchingStats.getHitByPitch());
        assertEquals(1, JoshuaSeward_pitchingStats.getPickOffs());
        assertEquals(376, JoshuaSeward_pitchingStats.getBattersFaced());
    }

}
