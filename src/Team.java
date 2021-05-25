import java.util.Locale;

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
     * Constructor for a Team object based on a
     * given location and name
     *
     * @param location - given location
     * @param name - given name
     */
    public Team(String location, String name) {
        this.location = location;
        this.name = name;
        if(location.length() > 4) this.abbreviation = location.substring(0, 3).toUpperCase();
        else this.abbreviation = location.toUpperCase();
        wins = 0;
        losses = 0;
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
    public void setAbbreviation(String abbreviation) {
        if(abbreviation.length() > 4)
            System.out.println("Abbreviations must be 4 characters or less");
        else this.abbreviation = abbreviation.toUpperCase();
    }
    public void setWins(int wins) {this.wins = wins;}
    public void setLosses (int losses) {this.losses = losses;}
}
