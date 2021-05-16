import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * A class for commonly recorded pitching stats
 *
 * @author - Joshua Seward
 * @version - 1.2.0
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
    private int balks, pickOffs, wildPitches, battersFaced;
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

        // TRY TO READ AN INPUT FILE
        if(!readInputFile()) {
            // the file does not exist, so set the stored values to 0
            pitchesThrown = 0; strikesThrown = 0; ballsThrown = 0;
            gamesPitched = 0; gamesStarted = 0; gamesFinished = 0;
            completeGames = 0; wins = 0; losses = 0; shutouts = 0; saves = 0;
            inningsPitched = 0.0; hits = 0; runs = 0; earnedRuns = 0;
            homeRuns = 0; walks = 0; intentionalWalks = 0; strikeouts = 0;
            hitByPitch = 0; balks = 0; pickOffs = 0; wildPitches = 0; battersFaced = 0;
        }

        // instantiate the pitchingCalc object
        pitchingCalc = new PitchingCalc();
    }

    /**
     * Method to read the input file and update the member variables
     */
    private boolean readInputFile () {
        // get the path to the pitching stats file
        String filePathName = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        if(os.contains("Windows"))
            filePathName = filePathName + "\\baseballStats\\" + statsFileName;
        else filePathName = filePathName + "/baseballStats/" + statsFileName;
        File inputFile = new File(filePathName);
        try (Scanner iFile = new Scanner(inputFile)) {
            // read the data from the file into the PitchingStats object
            iFile.nextLine(); pitchesThrown = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); strikesThrown = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); ballsThrown = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); gamesPitched = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); gamesStarted = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); gamesFinished = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); completeGames = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); wins = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); losses = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); shutouts = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); saves = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); inningsPitched = Double.parseDouble(iFile.nextLine());
            iFile.nextLine(); hits = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); runs = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); earnedRuns = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); homeRuns = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); walks = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); intentionalWalks = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); strikeouts = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); hitByPitch = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); balks = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); pickOffs = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); wildPitches = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); battersFaced = Integer.parseInt(iFile.nextLine());
            return true;
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found");
            return false;
        }
        catch (NoSuchElementException e) {
            System.out.println("ERROR - Input File is Empty");
            return false;
        }
        catch (NumberFormatException e) {
            System.out.println("ERROR - Stat in Incorrect Location");
            return false;
        }
    }

    /**
     * Method to update the pitching stats file using the current values
     * of the member variables
     *
     * @return - a boolean value that represents whether the file was
     *           successfully updated
     */
    public boolean updatePitchingStatsFile() {
        // TRY TO CREATE AND UPDATE AND OUTPUT FILE
        String filePathName = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        if(os.contains("Windows"))
            filePathName = filePathName + "\\baseballStats\\" + statsFileName;
        else filePathName = filePathName + "/baseballStats/" + statsFileName;
        try {
            FileWriter outputFile = new FileWriter(filePathName);
            PrintWriter oFile = new PrintWriter(outputFile);
            // write the current values of the PitchingStats object to the file
            oFile.println("Pitches Thrown: "); oFile.println(pitchesThrown);
            oFile.println("Strikes Thrown: "); oFile.println(strikesThrown);
            oFile.println("Balls Thrown: "); oFile.println(ballsThrown);
            oFile.println("Games Pitched (GP): "); oFile.println(gamesPitched);
            oFile.println("Games Started (GS): "); oFile.println(gamesStarted);
            oFile.println("Games Finished (GF): "); oFile.println(gamesFinished);
            oFile.println("Complete Games (CG): "); oFile.println(completeGames);
            oFile.println("Wins (W):"); oFile.println(wins);
            oFile.println("Losses (L): "); oFile.println(losses);
            oFile.println("Shutouts (SO): "); oFile.println(shutouts);
            oFile.println("Saves (SV): "); oFile.println(saves);
            oFile.println("Innings Pitched (IP): "); oFile.println(getInningsPitched());
            oFile.println("Hits (H): "); oFile.println(hits);
            oFile.println("Runs (R): "); oFile.println(runs);
            oFile.println("Earned Runs (ER): "); oFile.println(earnedRuns);
            oFile.println("Home Runs (HR): "); oFile.println(homeRuns);
            oFile.println("Walks (BB): "); oFile.println(walks);
            oFile.println("Intentional Walks (IBB): "); oFile.println(intentionalWalks);
            oFile.println("Strikeouts (K): "); oFile.println(strikeouts);
            oFile.println("Hit By Pitch (HBP): "); oFile.println(hitByPitch);
            oFile.println("Balks (BK): "); oFile.println(balks);
            oFile.println("Pick Offs (PO): ");  oFile.println(pickOffs);
            oFile.println("Wild Pitches (WP): "); oFile.println(wildPitches);
            oFile.println("Batters Faced (BF): "); oFile.println(battersFaced);
            // create the decimal format to write the calculated stats
            DecimalFormat df = new DecimalFormat("##.##");
            DecimalFormat whip = new DecimalFormat("##.###");
            oFile.println("Strike Percent: "); oFile.println(df.format(getStrikePercent()));
            oFile.println("Win-Loss Percent: "); oFile.println(df.format(getWinLossPercent()));
            oFile.println("Earned-Runs Average (ERA): "); oFile.println(df.format(getERA()));
            oFile.println("WHIP: "); oFile.println(whip.format(getWHIP()));
            oFile.println("Hits Per 9 Innings (H9): "); oFile.println(df.format(getH9()));
            oFile.println("Home Runs Per 9 Innings (HR9): "); oFile.println(df.format(getHR9()));
            oFile.println("Walks Per 9 Innings (BB9): "); oFile.println(df.format(getBB9()));
            oFile.println("Strikeouts Per 9 Innings (K9): "); oFile.println(df.format(getK9()));
            oFile.close();
            return true;
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR - Output File Not Found");
            return false;
        } catch (IOException e) {
            System.out.println("ERROR - Problem creating FileWriter");
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
    public int getPickOffs() {return pickOffs;}
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
    public void setPickOffs(int pickOffs) {this.pickOffs = pickOffs;}
    public void setWildPitches(int wildPitches) {this.wildPitches = wildPitches;}
    public void setBattersFaced(int battersFaced) {this.battersFaced = battersFaced;}

    // methods to help with testing
    public double actualInningsPitched() {return inningsPitched;}
}
