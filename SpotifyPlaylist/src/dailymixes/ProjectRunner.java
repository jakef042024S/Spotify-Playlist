// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor 
// and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept 
// the actions of those who do.
// -- Jake Fortuna

package dailymixes;

import java.io.FileNotFoundException;
import java.text.ParseException;

// -------------------------------------------------------------------------
/**
 *  project runner.
 * 
 *  @author jake
 *  @version Apr 10, 2024
 */
public class ProjectRunner {

    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * the main method.
     * @param args
     * the args
     * @throws FileNotFoundException
     * exception
     * @throws ParseException
     * exception
     * @throws DailyMixDataException
     * exception
     */
    public static void main(String[] args) throws FileNotFoundException, 
    ParseException, DailyMixDataException {
        if (args.length == 2) {
            PlaylistReader pl = new PlaylistReader(args[0], args[1]);
        } else {
            PlaylistReader pl = new PlaylistReader("input.txt", 
                "playlists.txt");
        }
    }

}
