// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor 
// and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept 
// the actions of those who do.
// -- Jake Fortuna

package dailymixes;
import student.TestCase;
// -------------------------------------------------------------------------
/**
 * playlist test.
 * 
 *  @author jake
 *  @version Apr 10, 2024
 */
public class PlaylistTest extends TestCase {
    //~ Fields ................................................................

    private Playlist pl;
    private Playlist pl2;
    private Playlist plnull;
    private Playlist pl3;
    private Playlist pl4;
    private Playlist pl5;
    private Playlist pl6;
    private Song song;
    private Song song2;
    private Song song3;
    private Song song4;
    //~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * setUp method.
     */
    public void setUp() {
        pl = new Playlist("mix 1", 30, 20, 40, 60, 50, 90, 2); 
        pl2 = new Playlist("mix 1", 30, 20, 40, 60, 50, 90, 2);
        plnull = null;
        pl3 = new Playlist("mix 2", 40, 30, 50, 70, 50, 95, 3);
        pl4 = new Playlist("mix b", 30, 20, 40, 60, 50, 90, 2);
        pl5 = new Playlist("mix 2", 40, 30, 50, 70, 50, 95, 2);
        pl6 = new Playlist("mix 2", 40, 30, 50, 80, 60, 98, 2);
        song = new Song("test", 40, 40, 50, "mix 1");
        song2 = new Song("test2", 40, 40, 50, "");
        song3 = new Song("test3", 40, 40, 50, "");
        song4 = new Song("test4", 99, 99, 50, "");
    }
    
    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * tests addSong.
     */
    public void testAddSong() {
        assertFalse(pl.addSong(song4));
        assertTrue(pl.addSong(song));
        assertTrue(pl.addSong(song2));
        assertFalse(pl.addSong(song3));
    }
    
    // ----------------------------------------------------------
    /**
     * tests toString method
     */
    public void testToString() {
        assertEquals("Playlist: mix 1, # of songs: 0 (cap: 2), "
            + "Requires: Pop:30%-60%, Rock:20%-50%, "
            + "Country:40%-90%", pl.toString());
    }
    
    // ----------------------------------------------------------
    /**
     * tests equals method.
     */
    public void testEquals() {
        assertFalse(pl.equals(plnull));
        assertTrue(pl.equals(pl));
        assertTrue(pl.equals(pl2));
        pl.addSong(song);
        assertFalse(pl.equals(pl2));
        pl2.addSong(song);
        assertTrue(pl.equals(pl2));
        pl.addSong(song2);
        pl2.addSong(song3);
        assertFalse(pl.equals(pl2));
    }
    
    // ----------------------------------------------------------
    /**
     * tests comparTo method
     */
    public void testCompareTo() {
        Exception exception = null;
        try {
            pl.compareTo(plnull);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        
        assertEquals(-1, pl.compareTo(pl3));
        pl.addSong(song);
        assertEquals(-1, pl.compareTo(pl2));
        assertEquals(-49, pl2.compareTo(pl4));
        assertEquals(-30, pl2.compareTo(pl5));
        assertEquals(-23, pl5.compareTo(pl6));
    }

}
