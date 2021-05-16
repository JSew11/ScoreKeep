package com.BaseballStats;

import java.io.*;
import java.text.DecimalFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FieldingStats {
    // member variables for basic statistics
    private int gamesPlayed, gamesStarted, completeGames;
    private double inningsPlayed;
    private int chances, putouts, assists, errors, doublePlays;
    // object to calculate more complex pitching stats
    private FieldingCalc fieldingCalc;
    // input/output file name
    private String statsFileName;

    /**
     * Constructor to instantiate the stored values for each statistic based
     * upon the values stored in the given file
     *
     * @param statsFileName - name of the file containing fielding statistics
     */
    public FieldingStats(String statsFileName) {
        this.statsFileName = statsFileName + "_fielding.txt";

        if(!readInputFile()) {
            // the file does not exist, so set the stored values to 0
            gamesPlayed = 0; gamesStarted = 0; completeGames = 0;
            inningsPlayed = 0.0;
            chances = 0; putouts = 0; assists = 0; errors = 0; doublePlays = 0;
        }
        // instantiate the fieldingCalc object
        fieldingCalc = new FieldingCalc();
    }

    /**
     * Method to read the input file and update the member variables
     *
     * @return - boolean value representing whether the file was
     *           correctly read
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
            iFile.nextLine(); gamesPlayed = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); gamesStarted = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); completeGames = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); double iP = Double.parseDouble(iFile.nextLine());
            setInningsPlayed(iP);
            iFile.nextLine(); chances = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); putouts = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); assists = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); errors = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); doublePlays = Integer.parseInt(iFile.nextLine());
            return true;
        }
        catch (FileNotFoundException e) {
            System.out.println("Input File Not Found - " + statsFileName);
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
     * Method to update the fielding stats file using the current values
     * of the member variables
     *
     * @return - a boolean value that represents whether the file was
     *           successfully updated
     */
    public boolean updateFieldingStatsFile() {
        // get the path to the output file
        String filePathName = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        if(os.contains("Windows"))
            filePathName = filePathName + "\\baseballStats\\" + statsFileName;
        else filePathName = filePathName + "/baseballStats/" + statsFileName;
        try {
            FileWriter outputFile = new FileWriter(filePathName);
            PrintWriter oFile = new PrintWriter(outputFile);
            // write the current values of the fieldingStats object to the file
            oFile.println("Games Played (GP):"); oFile.println(gamesPlayed);
            oFile.println("Games Started (GS):"); oFile.println(gamesStarted);
            oFile.println("Complete Games (CG):"); oFile.println(completeGames);
            oFile.println("Innings Played (IP):"); oFile.println(getInningsPlayed());
            oFile.println("Chances (CH):"); oFile.println(chances);
            oFile.println("Putouts (PO):"); oFile.println(putouts);
            oFile.println("Assists (A):"); oFile.println(assists);
            oFile.println("Errors (E):"); oFile.println(errors);
            oFile.println("Double Plays (DP):"); oFile.println(doublePlays);
            // create the decimal format to write the calculated stats
            DecimalFormat df = new DecimalFormat("##.##");
            DecimalFormat whip = new DecimalFormat("##.###");
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
    public int getGamesPlayed() {return gamesPlayed;}
    public int getGamesStarted() {return gamesStarted;}
    public int completeGames() {return completeGames;}
    public double getInningsPlayed() {
        int iP = (int) inningsPlayed;
        if(inningsPlayed - iP == 0.0) return inningsPlayed;
        else if(inningsPlayed == iP + (1.0/3.0)) return ((double) iP) + 0.1;
        else if(inningsPlayed == iP + (2.0/3.0)) return ((double) iP) + 0.2;
        else return inningsPlayed;
    }
    public int getChances() {return chances;}
    public int getPutouts() {return putouts;}
    public int getAssists() {return assists;}
    public int getErrors() {return errors;}
    public int getDoublePlays() {return doublePlays;}

    // calculated stats from fieldingCalc

    // attribute mutators
    public void setGamesPlayed(int gamesPlayed) {this.gamesPlayed = gamesPlayed;}
    public void setGamesStarted(int gamesStarted) {this.gamesStarted = gamesStarted;}
    public void setCompleteGames(int completeGames) {this.completeGames = completeGames;}
    public void setInningsPlayed(double inningsPlayed) {
        int iP = (int) inningsPlayed;
        if(inningsPlayed - iP == 0.0 ||
                inningsPlayed == iP + (1.0/3.0) ||
                inningsPlayed == iP + (2.0/3.0))
            this.inningsPlayed = inningsPlayed;
        else if(inningsPlayed == iP + 0.1) this.inningsPlayed = ((double) iP) + (1.0/3.0);
        else if(inningsPlayed == iP + 0.2) this.inningsPlayed = ((double) iP) + (2.0/3.0);
    }
    public void setChances(int chances) {this.chances = chances;}
    public void setPutouts(int putouts) {this.putouts = putouts;}
    public void setAssists(int assists) {this.assists = assists;}
    public void setErrors(int errors) {this.errors = errors;}
    public void setDoublePlays(int doublePlays) {this.doublePlays = doublePlays;}

    // method to help with testing
    double actualInningsPlayed() {return inningsPlayed;}
}
