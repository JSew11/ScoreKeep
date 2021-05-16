import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit testing for the PitchingStats class
 *
 * @author - Joshua Seward
 */
public class BattingStatsTest {
    BattingStats JoshuaSeward_battingStats =
            new BattingStats("JoshuaSeward");

    @Test
    public void newPlayerBattingStats() {
        BattingStats newPitcher = new BattingStats("NewPlayer");
        // check that the stats are initialized to 0
        assertEquals(0, newPitcher.getGamesPlayed());
        assertEquals(0, newPitcher.getRuns());
        assertEquals(0, newPitcher.getRunsBattedIn());
        assertEquals(0.0, newPitcher.getStolenBases());
        assertEquals(0, newPitcher.getHomeRuns());
        assertEquals(0, newPitcher.getHitByPitch());
    }

    @Test
    public void updateBattingStatsFile() {
        // set stats from my high school baseball career
        JoshuaSeward_battingStats.setGamesPlayed(18);
        JoshuaSeward_battingStats.setPlateAppearances(19);
        JoshuaSeward_battingStats.setAtBats(15);
        JoshuaSeward_battingStats.setRuns(4);
        JoshuaSeward_battingStats.setHits(4);
        JoshuaSeward_battingStats.setRunsBattedIn(4);
        JoshuaSeward_battingStats.setWalks(4);
        JoshuaSeward_battingStats.setStrikeouts(1);
        assertEquals(true, JoshuaSeward_battingStats.updateBattingStatsFile());
    }

    @Test
    public void existingPlayerStats() {
        // check that the stats are initialized to the correct values
        assertEquals(18, JoshuaSeward_battingStats.getGamesPlayed());
        assertEquals(4, JoshuaSeward_battingStats.getRunsBattedIn());
        assertEquals(0, JoshuaSeward_battingStats.getDoubles());
        assertEquals(1, JoshuaSeward_battingStats.getStrikeouts());
    }
}
