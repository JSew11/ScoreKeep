package com.BaseballBasics;

import java.io.*;
import java.util.*;

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
    private String filename;

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
        filename = first_name + last_name + ".txt";
        if(!readCoachFile()) {
            number = 0;
            wins = 0; losses = 0;
        }
    }

    /**
     * Method to read the coach file and store the data in the member
     * variables
     *
     * @return - a boolean value that represents whether the file was
     *           read successfully
     */
    private boolean readCoachFile() {
        // get the path to the input file
        String filePathName = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        if(os.contains("Windows"))
            filePathName = filePathName + "\\baseballData\\coaches\\" + filename;
        else filePathName = filePathName + "/baseballData/coaches/" + filename;
        File inputFile = new File(filePathName);
        try {
            Scanner iFile = new Scanner(inputFile);
            iFile.nextLine(); first_name = iFile.nextLine();
            iFile.nextLine(); last_name = iFile.nextLine();
            iFile.nextLine(); number = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); wins = Integer.parseInt(iFile.nextLine());
            iFile.nextLine(); losses = Integer.parseInt(iFile.nextLine());
            return true;
        }
        catch (FileNotFoundException e) {
            System.out.println("Input file not found");
            return false;
        }
    }

    /**
     * Method to update the coach file using the current values of the
     * member variables
     *
     * @return - a boolean value that represents whether the team file
     *           was updated successfully
     */
    public boolean updateCoach() {
        // get the path to the output file
        String filePathName = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        if(os.contains("Windows"))
            filePathName = filePathName + "\\baseballData\\coaches\\" + filename;
        else filePathName = filePathName + "/baseballData/coaches/" + filename;
        try{
            FileWriter outputFile = new FileWriter(filePathName);
            PrintWriter oFile = new PrintWriter(outputFile);
            oFile.println("First Name:"); oFile.println(first_name);
            oFile.println("Last Name:"); oFile.println(last_name);
            oFile.println("Number:"); oFile.println(number);
            oFile.println("Wins:"); oFile.println(wins);
            oFile.println("Losses:"); oFile.println(losses);
            oFile.close();
            return true;
        }
        catch (FileNotFoundException e) {
            System.out.println("Output file does not exist");
            return false;
        }
        catch (IOException e) {
            System.out.println("ERROR - Problem creating output file");
            return false;
        }
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
