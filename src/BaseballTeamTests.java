import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit testing for the BaseballTeam class
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 24, 2021
 */
public class BaseballTeamTests {
    private BaseballTeam testTeam;

    @Test
    public void newTeamTest() {
        testTeam = new BaseballTeam("Saturn", "Aliens");
        assertEquals("SAT", testTeam.getAbbreviation());
        testTeam = new BaseballTeam("Mars", "Aliens");
        assertEquals("MARS", testTeam.getAbbreviation());
        assertEquals("Mars", testTeam.getLocation());
        assertEquals("Aliens", testTeam.getName());
    }
}
