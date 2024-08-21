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
 *  songTest.
 * 
 *  @author jake
 *  @version Apr 3, 2024
 */
public class SongTest extends TestCase
{
    //~ Fields ................................................................
    private Song song;
    //~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * setUp.
     */
    public void setUp() {
        
        song = new Song("A", 10, 20, 30, "A1");
    }

    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * testGetPlaylistName.
     */
    public void testGetPlaylistName() {
        assertEquals("A1", song.getPlaylistName());
    }
    
    // ----------------------------------------------------------
    /**
     * testGetName.
     */
    public void testGetName() {
        assertEquals("A", song.getName());
    }
    
    // ----------------------------------------------------------
    /**
     * testGetGenreSet.
     */
    public void testGetGenreSet() {
        GenreSet set = new GenreSet(10, 20, 30);
        assertEquals(set, song.getGenreSet());
    }
    
    // ----------------------------------------------------------
    /**
     * testToString.
     */
    public void testToString() {
        assertEquals("A Pop:10 Rock:20 Country:30 Suggested: A1", 
            song.toString());
        Song song2 = new Song("", 5, 10, 15, "");
        assertEquals("No-Playlist  Pop:5 Rock:10 Country:15", 
            song2.toString());
    }
    
    // ----------------------------------------------------------
    /**
     * testEquals.
     */
    public void testEquals() {
        Object o = new Object();
        assertFalse(song.equals(o));
        Song sameSong = new Song("A", 10, 20, 30, "A1");
        assertTrue(song.equals(song));
        assertFalse(song.equals(null));
        assertTrue(song.equals(sameSong));
        Song song2 = new Song("", 5, 10, 15, "");
        Song song3 = new Song("", 10, 20, 30, "");
        Song song4 = new Song("A", 10, 20, 30, "");
        assertFalse(song.equals(song2));
    }

}
