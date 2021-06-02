package com.BaseballBasics;

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

    @Test
    public void updateTeamTest() {
        testTeam = new BaseballTeam("Mitty", "Monarchs");
        testTeam.setAbbreviation("amhs");
        assertEquals("AMHS", testTeam.getAbbreviation());
        BaseballCoach testCoach = new BaseballCoach("Brian", "Yocke");
        testCoach.setNumber(39);
        testTeam.setHeadCoach(testCoach);
        assertEquals(testCoach, testTeam.getHeadCoach());
        testTeam.addAssistantCoach(new BaseballCoach("Jeff", "Harper"));
        testTeam.addAssistantCoach(new BaseballCoach("Jeremy", "Advincula"));
        testTeam.addAssistantCoach(new BaseballCoach("Danny", "Steinstra"));
        assertEquals(true, testTeam.updateTeamFile());
    }

    @Test
    public void existingTeamTest() {
        testTeam = new BaseballTeam("Mitty", "Monarchs");
        assertEquals("Mitty", testTeam.getLocation());
        assertEquals("Monarchs", testTeam.getName());
        assertEquals("AMHS", testTeam.getAbbreviation());
    }
}
