package com.BaseballBasics;

import com.BaseballPosition.*;
import com.Exceptions.*;
import com.GenericSports.Team;

import java.io.*;
import java.util.*;

/**
 * A class for a baseball team
 *
 * @author - Joshua Seward
 * @version - 1.0.0
 * @since - May 19, 2021
 */
public class BaseballTeam extends Team {
    private BaseballCoach headCoach;
    private ArrayList<BaseballCoach> assistantCoaches;
    private ArrayList<BaseballPlayer> roster;
    private String filename;

    /**
     * Constructor for a BaseballTeam object based on a
     * given location and name
     *
     * @param location - given location
     * @param name - given name
     */
    public BaseballTeam(String location, String name) {
        super(location, name);
        roster = new ArrayList<BaseballPlayer>();
        assistantCoaches = new ArrayList<BaseballCoach>();
        filename = location + name + ".txt";
    }

    /**
     * Method to read the team file and store the data in the member
     * variables
     *
     * @return - boolean value that represents whether the file was
     *           read successfully
     */
    private boolean readTeamFile() {
        // get the path to the input file
        String filePathName = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        if(os.contains("Windows"))
            filePathName = filePathName + "\\baseballData\\teams\\" + filename;
        else filePathName = filePathName + "/baseballData/teams/" + filename;
        File inputFile = new File(filePathName);
        try {
            Scanner iFile = new Scanner(inputFile);
            iFile.nextLine(); setLocation(iFile.nextLine());
            iFile.nextLine(); setName(iFile.nextLine());
            iFile.nextLine(); setAbbreviation(iFile.nextLine());
            iFile.nextLine(); setWins(Integer.parseInt(iFile.nextLine()));
            iFile.nextLine(); setLosses(Integer.parseInt(iFile.nextLine()));
            iFile.nextLine(); headCoach = new BaseballCoach(iFile.next(), iFile.next());
            iFile.nextLine(); String astCoachFirst = iFile.next();
            while(!astCoachFirst.equals("Roster:")) {
                String astCoachLast = iFile.next();
                assistantCoaches.add(new BaseballCoach(astCoachFirst,astCoachLast));
                astCoachFirst = iFile.next();
            }
            return true;
        }
        catch(FileNotFoundException e) {
            System.out.println("Error - Input File not found");
            return false;
        }
    }

    /**
     * Method to update the team file using the current values of the
     * member variables
     *
     * @return - a boolean value that represents whether the team file
     *           was updated successfully
     */
    public boolean updateTeamFile() {
        // get the path to the output file
        String filePathName = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        if(os.contains("Windows"))
            filePathName = filePathName + "\\baseballData\\teams\\" + filename;
        else filePathName = filePathName + "/baseballData/teams/" + filename;
        try {
            FileWriter outputFile = new FileWriter(filePathName);
            PrintWriter oFile = new PrintWriter(outputFile);
            // write the current team info to the output file
            oFile.println("com.GenericSports.Team Location:"); oFile.println(getLocation());
            oFile.println("com.GenericSports.Team Name:"); oFile.println(getName());
            oFile.println("Abbreviation:"); oFile.println(getAbbreviation());
            oFile.println("Wins:"); oFile.println(getWins());
            oFile.println("Losses:"); oFile.println(getLosses());
            // update the head coach object
            oFile.println("Head Coach:");
            oFile.println(headCoach.getFirst_name() + " " + headCoach.getLast_name());
            headCoach.updateCoach();
            // update the assistant coach objects
            oFile.println("Assistant Coaches:");
            for(BaseballCoach assistantCoach : assistantCoaches) {
                oFile.println(assistantCoach.getFirst_name() + " " + assistantCoach.getLast_name());
                assistantCoach.updateCoach();
            }
            // update the player objects
            oFile.println("Roster:");
            for(BaseballPlayer player : roster)
                oFile.println(player.getFirst_name() + " " + player.getLast_name() + " " + player.getNumber());
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

    /**
     * Method to add an existing com.BaseballBasics.BaseballPlayer object to the
     * roster
     *
     * @param player - com.BaseballBasics.BaseballPlayer object to add to the roster
     */
    public void addPlayer(BaseballPlayer player) {roster.add(player);}

    /**
     * Method to generate and add a new com.BaseballBasics.BaseballPlayer object
     * to the roster given the new player's information
     *
     * @param first_name - given first name for the new player
     * @param last_name - given last name for the new player
     * @param number - given jersey number for the new player
     * @param position - given primary position for the new player
     */
    public void addPlayer(String first_name, String last_name, int number, BaseballPosition position) {
        BaseballPlayer newPlayer = new BaseballPlayer(first_name, last_name, number, position);
        roster.add(newPlayer);
    }

    /**
     * Method to get a specific BaseballPLayer object in the com.BaseballBasics.BaseballTeam
     * roster based on a given first and last name
     *
     * @param first_name - given first name
     * @param last_name - given last name
     * @return - the com.BaseballBasics.BaseballPlayer object with the given name
     * @throws PlayerNotFoundException - if there is no player with the given
     *                                   first and last name
     */
    public BaseballPlayer getPlayer(String first_name, String last_name) throws PlayerNotFoundException {
        for(int i = 0; i < roster.size(); ++i)
            if(roster.get(i).getFirst_name().equals(first_name) &&
               roster.get(i).getLast_name().equals(last_name))
                return roster.get(i);
        throw new PlayerNotFoundException("Player " + first_name + " " + last_name + " does not play for the " +
                                          getLocation() + " " + getName());
    }

    /**
     * Method to get a specific BaseballPLayer object in the com.BaseballBasics.BaseballTeam
     * roster based on a given jersey number
     *
     * @param number - given jersey number
     * @return - the com.BaseballBasics.BaseballPlayer object with the given jersey number
     * @throws PlayerNotFoundException - if there is no player with the given
     *                                   jersey number
     */
    public BaseballPlayer getPlayer(int number) throws  PlayerNotFoundException {
        for(int i = 0; i < roster.size(); ++i)
            if(roster.get(i).getNumber().equals(number))
                return roster.get(i);
        throw new PlayerNotFoundException("There is not a player with the number " + number + " on the " +
                                          getLocation() + " " + getName());
    }

    /**
     * Method to remove a specific com.BaseballBasics.BaseballPlayer object from the roster
     * based on a given first and last name
     *
     * @param first_name - given first name
     * @param last_name - given last name
     */
    public void removePlayer(String first_name, String last_name){
        for(int i = 0; i < roster.size(); ++i)
            if(roster.get(i).getFirst_name().equals(first_name) &&
                    roster.get(i).getLast_name().equals(last_name))
                roster.remove(i);
    }

    /**
     * Method to remove a specific com.BaseballBasics.BaseballPlayer object from the roster
     * based on a given jersey number
     *
     * @param number - given jersey number
     */
    public void removePlayer(int number) {
        for(int i = 0; i < roster.size(); ++i)
            if(roster.get(i).getNumber().equals(number))
                roster.remove(i);
    }

    /**
     * Method to add an existing com.BaseballBasics.BaseballCoach object to the
     * assistantCoaches list
     *
     * @param assistantCoach - existing com.BaseballBasics.BaseballCoach object
     */
    public void addAssistantCoach(BaseballCoach assistantCoach) {assistantCoaches.add(assistantCoach);}

    /**
     * Method to generate and add a new com.BaseballBasics.BaseballCoach object
     * to the assistantCoaches list given the coach's information
     *
     * @param first_name - given coach's first name
     * @param last_name - given coach's last name
     */
    public void addAssistantCoach(String first_name, String last_name) {
        BaseballCoach assistantCoach = new BaseballCoach(first_name, last_name);
        assistantCoaches.add(assistantCoach);
    }

    /**
     * Method to get a specific com.BaseballBasics.BaseballCoach object from the assistantCoaches
     * list from a given first and last name
     *
     * @param first_name - given first name
     * @param last_name - given last name
     * @return - desired com.BaseballBasics.BaseballCoach object
     * @throws CoachNotFoundException - if there is no coach on the team
     */
    public BaseballCoach getCoach(String first_name, String last_name) throws CoachNotFoundException{
        if(headCoach.getFirst_name().equals(first_name) &&
           headCoach.getLast_name().equals(last_name))
            return headCoach;
        for (BaseballCoach assistantCoach : assistantCoaches) {
            if (assistantCoach.getFirst_name().equals(first_name) &&
                    assistantCoach.getLast_name().equals(last_name))
                return assistantCoach;
        }
        throw new CoachNotFoundException("Coach " + first_name + " " + last_name + " does not coach for the " +
                                         getLocation() + " " + getName());
    }

    /**
     * Method to remove a specific com.BaseballBasics.BaseballCoach object from the assistantCoaches
     * list based on a given first and last name
     *
     * @param first_name - given first name
     * @param last_name - given last name
     */
    public void removeAssistantCoach(String first_name, String last_name) {
        for(int i = 0; i < assistantCoaches.size(); ++i){
            if(assistantCoaches.get(i).getFirst_name().equals(first_name) &&
                    assistantCoaches.get(i).getLast_name().equals(last_name))
                assistantCoaches.remove(i);
        }
    }

    // attribute accessors
    public BaseballCoach getHeadCoach() {return headCoach;}

    // attribute mutators
    public void setHeadCoach(BaseballCoach headCoach) {this.headCoach = headCoach;}
}
