/**
 * A class for a team
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 19, 2021
 */
public class Team {
    private String location;
    private String name;
    private String abbreviation;
    private Integer wins;
    private Integer losses;

    /**
     * Constructor for a basic Team object
     */
    public Team() {
        location = "Team Location";
        name = "Team Name";
        abbreviation = "ABRV";
        wins = 0;
        losses = 0;
    }

    /**
     * Constructor for a specific Team object based
     * on a given location and name
     *
     * @param location - given location
     * @param name - given name
     */
    public Team(String location, String name) {
        this.location = location;
        this.name = name;
        this.abbreviation = location.substring(0, 2).toUpperCase();
    }

    // attribute accessors
    public String getLocation() {return location;}
    public String getName() {return name;}
    public String getAbbreviation() {return abbreviation;}
    public Integer getWins() {return wins;}
    public Integer getLosses() {return losses;}

    // attribute mutators
    public void setLocation(String location) {this.location = location;}
    public void setName(String name) {this.name = name;}
    public void setAbbreviation(String abbreviation) {this.abbreviation = abbreviation;}
    public void setWins(int wins) {this.wins = wins;}
    public void setLosses (int losses) {this.losses = losses;}
}
