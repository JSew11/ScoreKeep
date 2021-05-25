import com.BaseballPosition.*;
import com.BaseballStats.*;
import com.Exceptions.PlayerNotFoundException;

import java.io.*;
import java.util.*;

/**
 * A class for a baseball player
 *
 * @author - Joshua Seward
 * @version - 1.2.0
 * @since - May 8, 2021
 */
public class BaseballPlayer extends Athlete implements Comparable<BaseballPlayer> {
    private BaseballPosition primary_position;
    private ArrayList<BaseballPosition> secondary_positions;
    private BaseballPlayerStats stats;
    private String filename;

    /**
     * Constructor for a BaseballPlayer object
     *
     * @param first_name - player's first name
     * @param last_name  - player's last name
     * @param number     - player's jersey number
     * @param position   - player's primary position
     */
    public BaseballPlayer(String first_name, String last_name, int number, BaseballPosition position) {
        super(first_name, last_name, number);
        primary_position = position;
        secondary_positions = new ArrayList<BaseballPosition>();
        stats = new BaseballPlayerStats(first_name, last_name);
        filename = first_name + last_name + ".txt";
    }

    /**
     * Overloaded constructor for a BaseballPlayer object that reads from
     * a player file based on a given name and number
     *
     * @param first_name - given first name
     * @param last_name - given last name
     * @param number - given number
     * @throws PlayerNotFoundException - if the player file does not exist
     */
    public BaseballPlayer(String first_name, String last_name, int number) throws PlayerNotFoundException {
        super(first_name, last_name, number);
        secondary_positions = new ArrayList<BaseballPosition>();
        if(!readPlayerFile())
            throw new PlayerNotFoundException(first_name + " " + last_name + " does not have any previous data");
    }

    /**
     * Method to read the player file and store the data in the member
     * variables
     *
     * @return - a boolean value representing whether the file was read
     *           successfully
     */
    private boolean readPlayerFile() { // get the path to the input file
        String filePathName = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        filename = getFirst_name() + getLast_name() + ".txt";
        if(os.contains("Windows"))
            filePathName = filePathName + "\\baseballData\\players\\" + getFirst_name() + getLast_name()+"\\"+filename;
        else filePathName = filePathName + "/baseballData/players/" + getFirst_name() + getLast_name() +"/"+filename;
        File inputFile = new File(filePathName);
        try {
            Scanner iFile = new Scanner(inputFile);
            iFile.nextLine(); setFirst_name(iFile.nextLine());
            iFile.nextLine(); setLast_name(iFile.nextLine());
            iFile.nextLine(); setNumber(Integer.parseInt(iFile.nextLine()));
            iFile.nextLine(); primary_position = readBaseballPos(iFile.nextLine());
            iFile.nextLine();
            while(iFile.hasNextLine()){
                String secondary = iFile.nextLine();
                BaseballPosition newPos = readBaseballPos(secondary);
                addSecondary_position(newPos);
            }
            return true;
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR - Player file not found");
            return false;
        }
    }

    private BaseballPosition readBaseballPos(String pos) {
        BaseballPosition position;
        switch(pos) {
            case "LRP": position = new LongReliever(); break;
            case "MRP": position = new MiddleReliever(); break;
            case "SU": position = new SetupMan(); break;
            case "CP": position = new ClosingPitcher(); break;
            case "RP": position = new ReliefPitcher(); break;
            case "SP": position = new StartingPitcher(); break;
            case "P": position = new Pitcher(); break;
            case "C": position = new Catcher(); break;
            case "1B": position = new FirstBase(); break;
            case "2B": position = new SecondBase(); break;
            case "3B": position = new ThirdBase(); break;
            case "SS": position = new Shortstop(); break;
            case "LF": position = new LeftField(); break;
            case "CF": position = new CenterField(); break;
            case "RF": position = new RightField(); break;
            case "PR": position = new PinchRunner(); break;
            case "PH": position = new PinchHitter(); break;
            case "DH": position = new DesignatedHitter(); break;
            case "EH": position = new ExtraHitter(); break;
            default: position = new Extra();
        }
        return position;
    }

    /**
     * Method to update all of the player's stats files
     *
     * @return - boolean value representing whether the files were
     *           updated successfully
     */
    public boolean updateBaseballPlayer() {
        // create the path to the player's folder
        String filePathName = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        String folderName = getFirst_name() + getLast_name();
        if(os.contains("Windows")) {
            filePathName = filePathName + "\\baseballData\\players\\";
            File playerDir = new File(filePathName + folderName + "\\");
            if(!playerDir.exists()){
                playerDir.mkdirs();
                File statFolder = new File(filePathName + folderName + "\\stats\\");
                statFolder.mkdirs();
            }
            filePathName = filePathName + "\\" + folderName + "\\" + filename;
        }
        else{
            filePathName = filePathName + "/baseballData/players/";
            File playerDir = new File(filePathName + folderName + "/");
            if(!playerDir.exists()){
                playerDir.mkdirs();
                File statFolder = new File(filePathName + folderName + "/stats/");
                statFolder.mkdirs();
            }
            filePathName = filePathName + "/" + folderName + "/" + filename;
        }
        // try to write the output file
        try {
            FileWriter outputFile = new FileWriter(filePathName);
            PrintWriter oFile = new PrintWriter(outputFile);
            oFile.println("First Name:"); oFile.println(getFirst_name());
            oFile.println("Last_Name:"); oFile.println(getLast_name());
            oFile.println("Number:"); oFile.println(getNumber());
            oFile.println("Primary Position:"); oFile.println(primary_position.toString());
            oFile.println("SecondaryPositions:");
            for (BaseballPosition pos : secondary_positions)
                    oFile.println(pos.toString());
            oFile.close();
        }
        catch (IOException e) {
            System.out.println("ERROR - Problem creating file");
            return false;
        }
        return stats.updateStats();
    }

    /**
     * Accessor for the baseball player's primary position
     *
     * @return - baseball player's primary position
     */
    public BaseballPosition getPrimary_position() {return primary_position;}

    /**
     * Mutator for the baseball player's primary position
     *
     * @param primary_position - baseball player's primary position
     */
    public void setPrimary_position(BaseballPosition primary_position) {this.primary_position = primary_position;}

    /**
     * Accessor for the baseball player's secondary positions
     *
     * @return - baseball player's secondary positions
     */
    public ArrayList<BaseballPosition> getSecondary_positions() {return secondary_positions;}

    /**
     * Method to add a new secondary position to the ArrayList of
     * BaseballPositions
     *
     * @param position - BaseballPosition to add to the ArrayList
     * @return - Whether the position was added correctly
     */
    public boolean addSecondary_position(BaseballPosition position) {
        if(!secondary_positions.contains(position) && position.compareTo(primary_position) != 0) {
            secondary_positions.add(position);
            return true;
        }
        return false;
    }

    /**
     * Method to remove a secondary position from the ArrayList of
     * BaseballPositions
     *
     * @param position - BaseballPosition to remove from the ArrayList
     */
    public void removeSecondary_position(BaseballPosition position) {secondary_positions.remove(position);}

    /**
     * Method to compare the given BaseballPlayer object to the
     * current BaseballPlayer object
     *
     * @param player - the given BaseballPlayer object to be
     *                 compared
     * @return - an int representation of whether the BaseballPlayer
     *           objects are the same
     */
    @Override
    public int compareTo(BaseballPlayer player) {
        if(player.getFirst_name().equals(getFirst_name()) &&
                player.getLast_name().equals(getLast_name()))
            return 1;
        else return 0;
    }

    /**
     * Accessor for the baseball player's BattingStats object
     *
     * @return - baseball player's BattingStats object
     */
    public BattingStats getBattingStats() {return stats.getBattingStats();}

    /**
     * Accessor for the baseball player's FieldingStats object
     *
     * @return - baseball player's FieldingStats object
     */
    public FieldingStats getFieldingStats() {return stats.getFieldingStats();}

    /**
     * Accessor for the baseball player's PitchingStats object
     *
     * @return - baseball player's PitchingStats object
     */
    public PitchingStats getPitchingStats() {return stats.getPitchingStats();}
}
