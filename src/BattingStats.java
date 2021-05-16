import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * A class for commonly recorded batting stats
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 15, 2021
 */
public class BattingStats {
    // member variables for basic statistics
    private int gamesPlayed, plateAppearances, atBats;
    private int runs, hits, doubles, triples, homeRuns;
    private int runsBattedIn, stolenBases, caughtStealing;
    private int walks, strikeouts, doublePlays, hitByPitch;
    private int sacrificeHits, sacrificeFlies, intentionalWalks;
    // object to calculate more complex stats
    private BattingCalc battingCalc;
    // BattingStats input/output file name
    private String statsFileName;

    public BattingStats(String statsFileName) {
        this.statsFileName = statsFileName + "_batting.txt";

        if(!readInputFile()){
            // the file does not exist, so set the stored values to 0
            gamesPlayed = 0; plateAppearances = 0; atBats = 0;
            runs = 0; hits = 0; doubles = 0; triples = 0; homeRuns = 0;
            runsBattedIn = 0; stolenBases = 0; caughtStealing = 0;
            walks = 0; strikeouts = 0; doublePlays = 0; hitByPitch = 0;
            sacrificeHits = 0; sacrificeFlies = 0; intentionalWalks = 0;
        }

        // initialize the BattingCalc object
        battingCalc = new BattingCalc();
    }

    /**
     * Method to read the input file and update the member variables
     *
     * @return - boolean value representing whether the file was
     *           correctly read
     */
    private boolean readInputFile() {
        // get the path to the pitching stats file
        String filePathName = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        if(os.contains("Windows"))
            filePathName = filePathName + "\\baseballStats\\" + statsFileName;
        else filePathName = filePathName + "/baseballStats/" + statsFileName;
        File inputFile = new File(filePathName);
        try (Scanner iFile = new Scanner(inputFile)) {
            // read the data from the file into the PitchingStats object
            iFile.nextLine(); gamesPlayed = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); plateAppearances = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); atBats = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); runs = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); hits = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); doubles = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); triples = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); homeRuns = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); runsBattedIn = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); stolenBases = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); caughtStealing = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); walks = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); strikeouts = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); doublePlays = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); hitByPitch = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); sacrificeHits = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); sacrificeFlies = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); intentionalWalks = Integer.parseInt(iFile.nextLine());
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
        // get the path to the output file
        String filePathName = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        if(os.contains("Windows"))
            filePathName = filePathName + "\\baseballStats\\" + statsFileName;
        else filePathName = filePathName + "/baseballStats/" + statsFileName;
        try {
            FileWriter outputFile = new FileWriter(filePathName);
            PrintWriter oFile = new PrintWriter(outputFile);
            // write the current values of the PitchingStats object to the file
            oFile.println("Games Played (GP): "); oFile.println(gamesPlayed);
            oFile.println("Plate Appearances (PA): "); oFile.println(plateAppearances);
            oFile.println("At Bats (AB): "); oFile.println(atBats);
            oFile.println("Runs (R): "); oFile.println(runs);
            oFile.println("Hits (H): "); oFile.println(hits);
            oFile.println("Doubles (2B): "); oFile.println(doubles);
            oFile.println("Triples (3B): "); oFile.println(triples);
            oFile.println("Home Runs (HR):"); oFile.println(homeRuns);
            oFile.println("Runs Batted In (RBI): "); oFile.println(runsBattedIn);
            oFile.println("Stolen Bases (SB): "); oFile.println(stolenBases);
            oFile.println("Caught Stealing (CS): "); oFile.println(caughtStealing);
            oFile.println("Walks (BB): "); oFile.println(walks);
            oFile.println("Strikeouts (K): "); oFile.println(strikeouts);
            oFile.println("Double Plays (GDP): "); oFile.println(doublePlays);
            oFile.println("Hit By Pitch (HBP): "); oFile.println(hitByPitch);
            oFile.println("Sacrifice Hits (SH): "); oFile.println(sacrificeHits);
            oFile.println("Sacrifice Flies (SF): "); oFile.println(sacrificeFlies);
            oFile.println("Intentional Walks (IBB): "); oFile.println(intentionalWalks);
            // create the decimal format to write the calculated stats
            DecimalFormat df = new DecimalFormat("##.##");
            DecimalFormat ops = new DecimalFormat("##.###");
            oFile.println("Batting Average (BA):");
            oFile.println(df.format(battingCalc.BA(hits, atBats)));
            oFile.println("On base Percentage (OBP):");
            oFile.println(df.format(battingCalc.OBP(hits,walks,hitByPitch,atBats,sacrificeFlies)));
            oFile.println("Total Bases (TB):");
            oFile.println(battingCalc.TB(hits,doubles,triples,homeRuns));
            oFile.println("Slugging Percentage (SLG):");
            oFile.println(df.format(battingCalc.SLG(hits,doubles,triples,homeRuns,atBats)));
            oFile.println("On Base Plus Slugging Percentage (OPS):");
            oFile.println(ops.format(battingCalc.OPS(hits,doubles,triples,homeRuns,walks,
                                                     hitByPitch,atBats,sacrificeFlies)));
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
}

