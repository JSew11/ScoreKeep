import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * A class for commonly recorded pitching stats
 *
 * @author - Joshua Seward
 * @version - 1.1.0
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
    private int balks, pickoffs, wildPitches, battersFaced;
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
        // create the path to the pitching stats file
        this.statsFileName = statsFileName;
        String statsFilePath = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        if(os.contains("Windows")) statsFilePath = "\\\\baseballStats\\\\" + statsFileName;
        else statsFilePath = statsFilePath + "//baseballStats//" + statsFileName;
        try{
            // open the stats file if it exists
            Scanner inFile = new Scanner(new File(statsFilePath));
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
            balks = inFile.nextInt(); pickoffs = inFile.nextInt();
            wildPitches = inFile.nextInt(); battersFaced = inFile.nextInt();
        }
        catch (FileNotFoundException e) {
            // the file does not exist, so set the stored values to 0
            pitchesThrown = 0; strikesThrown = 0; ballsThrown = 0;
            gamesPitched = 0; gamesStarted = 0; gamesFinished = 0;
            completeGames = 0; wins = 0; losses = 0; shutouts = 0; saves = 0;
            inningsPitched = 0.0; hits = 0; runs = 0; earnedRuns = 0;
            homeRuns = 0; walks = 0; intentionalWalks = 0; strikeouts = 0;
            hitByPitch = 0; balks = 0; pickoffs = 0; wildPitches = 0; battersFaced = 0;
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
        // create the output file using the current directory and the known stats output file
        File outputFile;
        String cur_dir = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        if(os.contains("Windows")) outputFile = new File(cur_dir + "\\baseballStats\\", statsFileName);
        else outputFile = new File(cur_dir + "/baseballStats/", statsFileName);
        try (BufferedWriter oFile = new BufferedWriter(new FileWriter(outputFile))){
            // write the current values in the object to the stats file
            oFile.write("Pitches Thrown: " + pitchesThrown + "\n");
            oFile.write("Strikes Thrown: " + strikesThrown + "\n");
            oFile.write("Balls Thrown: " + ballsThrown + "\n");
            oFile.write("Games Pitched (G): " + gamesPitched + "\n");
            oFile.write("Games Started (GS): " + gamesStarted + "\n");
            oFile.write("Games Finished (GF): " + gamesFinished + "\n");
            oFile.write("Complete Games (CG): " + completeGames + "\n");
            oFile.write("Wins (W): " + wins + "\n");
            oFile.write("Losses (L): " + losses + "\n");
            oFile.write("Shutouts (SO): " + shutouts + "\n");
            oFile.write("Saves (SV): " + saves + "\n");
            oFile.write("Innings Pitched (IP): " + getInningsPitched() + "\n");
            oFile.write("Hits (H): " + hits + "\n");
            oFile.write("Runs (R): " + runs + "\n");
            oFile.write("Earned Runs (ER): " + earnedRuns + "\n");
            oFile.write("Home Runs (HR): " + homeRuns + "\n");
            oFile.write("Walks (BB): " + walks + "\n");
            oFile.write("Intentional Walks (IBB): " + intentionalWalks + "\n");
            oFile.write("Strikeouts (K): " + strikeouts + "\n");
            oFile.write("Hit by Pitch (HBP): " + hitByPitch + "\n");
            oFile.write("Balks (BK): " + balks + "\n");
            oFile.write("Pickoffs (PO): " + pickoffs + "\n");
            oFile.write("Wild Pitches (WP): " + wildPitches + "\n");
            oFile.write("Batters Faced (BF): " + battersFaced + "\n");
            // create the decimal format for the calculated stats
            DecimalFormat df = new DecimalFormat("##.##");
            DecimalFormat dfWHIP = new DecimalFormat("#.###");
            oFile.write("Strike Percentage (K%): " + df.format(getStrikePercent()) + "\n");
            oFile.write("Win-Loss Percentage (W-L%): " + df.format(getWinLossPercent()) + "\n");
            oFile.write("Earned Runs Average (ERA): " + df.format(getERA()) + "\n");
            oFile.write("WHIP: " + dfWHIP.format(getWHIP()) + "\n");
            oFile.write("Hits/9 (H9): " + df.format(getH9()) + "\n");
            oFile.write("Home Runs/9 (HR/9): " + df.format(getHR9()) + "\n");
            oFile.write("Walks/9 (BB9): " + df.format(getBB9()) + "\n");
            oFile.write("Strikeouts/9 (K9): " + df.format(getK9()) + "\n");
            return true;
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR - Problem with output PitchingStats file");
            return false;
        }
        catch (IOException e) {
            System.out.println("ERROR - Problem with output PitchingStats file");
            return false;
        }
    }

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
        else if(inningsPitched == iP + (1.0/3.0)) return (iP + 0.1);
        else if(inningsPitched == iP + (2.0/3.0)) return (iP + 0.2);
        else return 0.0;
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
    public int getPickoffs() {return pickoffs;}
    public int getWildPitches() {return wildPitches;}
    public int getBattersFaced() {return battersFaced;}

    // calculated stats form pitchingCalc
    public double getStrikePercent() {return pitchingCalc.strikePercent(strikesThrown,pitchesThrown);}
    public double getWinLossPercent() {return pitchingCalc.winLossPercent(wins, losses);}
    public double getERA() {return pitchingCalc.ERA(earnedRuns, inningsPitched);}
    public double getWHIP() {return pitchingCalc.WHIP(walks,hits, inningsPitched);}
    public double getH9() {return pitchingCalc.H9(hits, inningsPitched);}
    public double getHR9() {return pitchingCalc.HR9(homeRuns, inningsPitched);}
    public double getBB9() {return pitchingCalc.BB9(walks, inningsPitched);}
    public double getK9() {return pitchingCalc.K9(strikeouts, inningsPitched);}

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
           inningsPitched == iP + (1.0/3.0) ||
           inningsPitched == iP + (2.0/3.0))
            this.inningsPitched = inningsPitched;
        else if(inningsPitched == iP + 0.1) this.inningsPitched = ((double) iP) + (1.0/3.0);
        else if(inningsPitched == iP + 0.2) this.inningsPitched = ((double) iP) + (2.0/3.0);
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
    public void setPickoffs(int pickoffs) {this.pickoffs = pickoffs;}
    public void setWildPitches(int wildPitches) {this.wildPitches = wildPitches;}
    public void setBattersFaced(int battersFaced) {this.battersFaced = battersFaced;}

    // method to help with testing
    public double actualInningsPitched() {return inningsPitched;}
}
