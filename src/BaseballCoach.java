/**
 * A class for a baseball coach
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 21, 2021
 */
public class BaseballCoach implements Comparable<BaseballCoach>{
    private String first_name;
    private String last_name;
    private Integer number;
    private Integer wins;
    private Integer losses;

    /**
     * Constructor for a BaseballCoach object based on a
     * given first and last name
     *
     * @param first_name - given first name
     * @param last_name - given last name
     */
    public BaseballCoach(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        wins = 0; losses = 0;
    }

    // attribute accessors
    public String getFirst_name() {return first_name;}
    public String getLast_name() {return last_name;}
    public Integer getNumber() {return number;}
    public Integer getWins() {return wins;}
    public Integer getLosses() {return losses;}

    // attribute mutators
    public void setFirst_name(String first_name) {this.first_name = first_name;}
    public void setLast_name(String last_name) {this.last_name = last_name;}
    public void setNumber(int number) {this.number = number;}
    public void setWins(int wins) {this.wins = wins;}
    public void setLosses(int losses) {this.losses = losses;}

    @Override
    public int compareTo(BaseballCoach coach) {
        if(coach.getFirst_name().equals(first_name) &&
           coach.getLast_name().equals(last_name))
            return 1;
        return 0;
    }
}
