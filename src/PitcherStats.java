import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class to keep track of a pitcher's stats over multiple
 * games
 *
 * @author Joshua Seward
 * @version 1.0
 */

public class PitcherStats {
    private Pitcher pitcher;

    /**
     * Constructor for a new PitcherStats object
     *
     * @param filename - String for the name of the input/output file
     */
    public PitcherStats(String filename){
        pitcher = new Pitcher();
        readStatsFile(filename);
    }

    /**
     * Helper method to read file of pitcher stats and store
     * data in PitcherStats object
     *
     * @param filename - name of stats file
     */
    private void readStatsFile(String filename){
        try{
            Scanner inFile = new Scanner(new File(filename));
            String first_name = "";
            String last_name = "";

            String full_name = inFile.nextLine();
            getName(full_name, first_name, last_name);
            int number = inFile.nextInt();
            pitcher.setNumber(number);
            int age = inFile.nextInt();
            pitcher.setAge(age);
            String pos = inFile.nextLine();
            addPositions(pos);
        } catch(FileNotFoundException e){
            System.out.println("File " + filename + " not found.");
        }
    }

    /**
     * Helper method to get the name of the pitcher from the stats file
     *
     * @param full - full name taken from stats file
     * @param first - first name after full is split
     * @param last - last name after full is split
     */
    private void getName(String full, String first, String last){
        int space = 0;
        first = "";
        last = "";

        while(full.charAt(space) != ' ' && space < full.length())
            space++;
        for(int i = 0; i < space; ++i)
            first = first + full.charAt(i);
        if(space == full.length()) return;
        for(int i = space+1; i < full.length(); ++i)
            last = last + full.charAt(i);
    }

    /**
     * Helper method to read and add multiple positions from a
     * PitcherStats object to a pitcher
     *
     * @param positions - String containing multiple positions
     */
    private void addPositions(String positions){
        String pos = "";
        for(int i = 0; i < positions.length(); ++i){
            if(positions.charAt(i) != ' ')
                pos = pos + positions.charAt(i);
            else{
                pitcher.addPosition(pos);
                pos = "";
            }
        }
    }
}
