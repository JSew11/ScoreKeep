import java.io.*;
import java.util.*;

/**
 * A class for commonly recorded pitching stats
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 11, 2021
 */
public class PitchingStats {
    // member variables for basic statistics
    private int pitchesThrown, strikesThrown, ballsThrown;
    private int gamesPitched, gamesStarted, gamesFinished;
    private int completeGames, wins, losses, shutouts, saves;
    private double inningsPitched;
    private int hits, runs, earnedRuns, homeRuns, walks;
    private int intentionalWalks, strikeouts, hitByPitch;
    private int balks, wildPitches, battersFaced;
    // object to calculate more complex stats
    private PitchingCalc pitchingCalc;
    // PitchingStats input/output file name
    private String statsFileName;

    /**
     * Constructor to instantiate the stored values for each statistic based
     * upon the values stored in the given file
     *
     * @param statsFileName - name of the file containing pitching statistics
     */
    public PitchingStats(String statsFileName) {
        this.statsFileName = statsFileName;
        try{
            // open the stats file if it exists
            Scanner inFile = new Scanner(new File(statsFileName));
            pitchesThrown = inFile.nextInt(); strikesThrown = inFile.nextInt();
            ballsThrown = inFile.nextInt(); gamesPitched = inFile.nextInt();
            gamesStarted = inFile.nextInt(); gamesFinished = inFile.nextInt();
            completeGames = inFile.nextInt(); wins = inFile.nextInt();
            losses = inFile.nextInt(); shutouts = inFile.nextInt();
            saves = inFile.nextInt();
            // read and interpret the innings pitched stat
            double iP = inFile.nextDouble();
            int ip_int = (int) iP;
            if(iP - ip_int == 0.0) inningsPitched = iP;
            else if(iP - ip_int == 0.1) inningsPitched = ((double) ip_int) + (1.0/3.0);
            else if(iP - ip_int == 0.2) inningsPitched = ((double) ip_int) + (2.0/3.0);
            hits = inFile.nextInt(); runs = inFile.nextInt();
            earnedRuns = inFile.nextInt(); homeRuns = inFile.nextInt();
            walks = inFile.nextInt(); intentionalWalks = inFile.nextInt();
            strikeouts = inFile.nextInt(); hitByPitch = inFile.nextInt();
            balks = inFile.nextInt(); wildPitches = inFile.nextInt();
            battersFaced = inFile.nextInt();
        }
        catch (FileNotFoundException e) {
            // the file does not exist, so set the stored values to 0
            pitchesThrown = 0; strikesThrown = 0; ballsThrown = 0;
            gamesPitched = 0; gamesStarted = 0; gamesFinished = 0;
            completeGames = 0; wins = 0; losses = 0; shutouts = 0; saves = 0;
            inningsPitched = 0.0; hits = 0; runs = 0; earnedRuns = 0;
            homeRuns = 0; walks = 0; intentionalWalks = 0; strikeouts = 0;
            hitByPitch = 0; balks = 0; wildPitches = 0; battersFaced = 0;
        }
        // instantiate the pitchingCalc object
        pitchingCalc = new PitchingCalc();
    }

    /**
     * Method to update the pitching stats file using the current values
     * of the member variables
     *
     * @return - a boolean value that represents whether the file was
     *           successfully updated
     */
    public boolean updatePitchingStatsFile() {
        try {
            // write the current values in the object to the stats file
            PrintStream oFile = new PrintStream(statsFileName);
            oFile.println("Pitches Thrown: " + pitchesThrown);
            oFile.println("Strikes Thrown: " + strikesThrown);
            oFile.println("Balls Thrown: " + ballsThrown);
            oFile.println("Games Pitched (G): " + gamesPitched);
            oFile.println("Games Started (GS): " + gamesStarted);
            oFile.println("Games Finished (GF): " + gamesFinished);
            oFile.println("Complete Games (CG): " + completeGames);
            oFile.println("Wins (W): " + wins);
            oFile.println("Losses (L): " + losses);
            oFile.println("Shutouts (SO): " + shutouts);
            oFile.println("Saves (SV): " + saves);
            // write the innings pitched in the modified format
            oFile.print("Innings Pitched (IP): ");
            int iP = (int) inningsPitched;
            if(inningsPitched - iP == 0.0) oFile.println("" + inningsPitched);
            else if(inningsPitched - iP == (1.0/3.0)) oFile.println("" + iP + ".1");
            else if(inningsPitched - iP == (2.0/3.0)) oFile.println("" + iP + ".2");
            oFile.println("Hits (H): " + hits);
            oFile.println("Runs (R): " + runs);
            oFile.println("Earned Runs (ER): " + earnedRuns);
            oFile.println("Home Runs (HR): " + homeRuns);
            oFile.println("Walks (BB): " + walks);
            oFile.println("Intentional Walks (IBB): " + intentionalWalks);
            oFile.println("Strikeouts (K): " + strikeouts);
            oFile.println("Hit by Pitch (HBP): " + hitByPitch);
            oFile.println("Balks (BK): " + balks);
            oFile.println("Wild Pitches (WP): " + wildPitches);
            oFile.println("Batters Faced (BF): " + battersFaced);
            oFile.println("Strike Percentage (K%): " + getStrikePercent());
            oFile.println("Win-Loss Percentage (W-L%): " + getWinLossPercent());
            oFile.println("Earned Runs Average (ERA): " + getERA());
            oFile.println("WHIP: " + getWHIP());
            oFile.println("Hits/9 (H9): " + getH9());
            oFile.println("Home Runs/9 (HR/9): " + getHR9());
            oFile.println("Walks/9 (BB9): " + getBB9());
            oFile.println("Strikeouts/9 (K9): " + getK9());
            return true;
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR - Problem with output PitchingStats file");
            return false;
        }
    }

    // calculated stats from PitchingCalc object

    // attribute accessors
    public int getPitchesThrown() {return pitchesThrown;}
    public int getStrikesThrown() {return strikesThrown;}
    public int getBallsThrown() {return ballsThrown;}
    public int getGamesPitched() {return gamesPitched;}
    public int getGamesStarted() {return gamesStarted;}
    public int getGamesFinished() {return gamesFinished;}
    public int getCompleteGames() {return completeGames;}
    public int getWins() {return wins;}
    public int getLosses() {return losses;}
    public int getShutouts() {return shutouts;}
    public int getSaves() {return saves;}
    public double getInningsPitched() {
        int iP = (int) inningsPitched;
        if(inningsPitched - iP == 0.0) return inningsPitched;
        else if(inningsPitched - iP == (1.0/3.0)) return ((double) iP) + 0.1;
        else if(inningsPitched - iP == (2.0/3.0)) return ((double) iP) + 0.2;
        return inningsPitched;
    }
    public int getHits() {return hits;}
    public int getRuns() {return runs;}
    public int getEarnedRuns() {return earnedRuns;}
    public int getHomeRuns() {return homeRuns;}
    public int getWalks() {return walks;}
    public int getIntentionalWalks() {return intentionalWalks;}
    public int getStrikeouts() {return strikeouts;}
    public int getHitByPitch() {return hitByPitch;}
    public int getBalks() {return balks;}
    public int getWildPitches() {return wildPitches;}
    public int getBattersFaced() {return battersFaced;}

    // attribute mutators
    public void setPitchesThrown(int pitchesThrown) {this.pitchesThrown = pitchesThrown;}
    public void setStrikesThrown(int strikesThrown) {this.strikesThrown = strikesThrown;}
    public void setBallsThrown(int ballsThrown) {this.ballsThrown = ballsThrown;}
    public void setGamesPitched(int gamesPitched) {this.gamesPitched = gamesPitched;}
    public void setGamesStarted(int gamesStarted) {this.gamesStarted = gamesStarted;}
    public void setGamesFinished(int gamesFinished) {this.gamesFinished = gamesFinished;}
    public void setCompleteGames(int completeGames) {this.completeGames = completeGames;}
    public void setWins(int wins) {this.wins = wins;}
    public void setLosses(int losses) {this.losses = losses;}
    public void setShutouts(int shutouts) {this.shutouts = shutouts;}
    public void setSaves(int saves) {this.saves = saves;}
    public void setInningsPitched(double inningsPitched) {
        int iP = (int) inningsPitched;
        if(inningsPitched - iP == 0.0 ||
           inningsPitched - iP == (1.0/3.0) ||
           inningsPitched - iP == (2.0/3.0))
            this.inningsPitched = inningsPitched;
        else if(inningsPitched - iP == 0.1) this.inningsPitched = ((double) iP) + (1.0/3.0);
        else if(inningsPitched - iP == 0.2) this.inningsPitched = ((double) iP) + (2.0/3.0);
    }
    public void setHits(int hits) {this.hits = hits;}
    public void setRuns(int runs) {this.runs = runs;}
    public void setEarnedRuns(int earnedRuns) {this.earnedRuns = earnedRuns;}
    public void setHomeRuns(int homeRuns) {this.homeRuns = homeRuns;}
    public void setWalks(int walks) {this.walks = walks;}
    public void setIntentionalWalks(int intentionalWalks) {this.intentionalWalks = intentionalWalks;}
    public void setStrikeouts(int strikeouts) {this.strikeouts = strikeouts;}
    public void setHitByPitch(int hitByPitch) {this.hitByPitch = hitByPitch;}
    public void setBalks(int balks) {this.balks = balks;}
    public void setWildPitches(int wildPitches) {this.wildPitches = wildPitches;}
    public void setBattersFaced(int battersFaced) {this.battersFaced = battersFaced;}

    // pitchingCalc method accessors
    public double getStrikePercent() {return pitchingCalc.strikePercent(strikesThrown,pitchesThrown);}
    public double getWinLossPercent() {return pitchingCalc.winLossPercent(wins, losses);}
    public double getERA() {return pitchingCalc.ERA(earnedRuns, inningsPitched);}
    public double getWHIP() {return pitchingCalc.WHIP(walks,hits, inningsPitched);}
    public double getH9() {return pitchingCalc.H9(hits, inningsPitched);}
    public double getHR9() {return pitchingCalc.HR9(homeRuns, inningsPitched);}
    public double getBB9() {return pitchingCalc.BB9(walks, inningsPitched);}
    public double getK9() {return pitchingCalc.K9(strikeouts, inningsPitched);}
}
