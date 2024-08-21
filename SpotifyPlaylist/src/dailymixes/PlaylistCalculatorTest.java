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
 *  tests for playlistCalculator
 * 
 *  @author jake
 *  @version Apr 10, 2024
 */
public class PlaylistCalculatorTest extends TestCase {
    //~ Fields ................................................................
    private PlaylistCalculator calc;
    private ArrayQueue<Song> songQueue;
    private Playlist[] playlists;

    
    //~ Constructors ..........................................................
    
    // ----------------------------------------------------------
    /**
     * setUp method.
     */
    public void setUp() {
        songQueue = new ArrayQueue<>(5);
        playlists = new Playlist[3]; 
        playlists[0] = new Playlist("mix 1", 25, 10, 5, 70, 30, 15, 10);
        playlists[1] = new Playlist("mix 2", 10, 50, 5, 15, 90, 10, 8);
        playlists[2] = new Playlist("mix 3", 10, 5, 50, 30, 15, 90, 12);
        calc = new PlaylistCalculator(songQueue, playlists);
    }


    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * tests GetPlaylistForSong.
     */
    public void testGetPlaylistForSong() {
        Song song = new Song("song", 35, 12, 8, "mix 1");
        assertEquals(playlists[0], calc.getPlaylistForSong(song));
        
        Song song1 = new Song("song1", 35, 12, 8, null);
        assertEquals(playlists[0], calc.getPlaylistForSong(song1));
        
    }
    
    // ----------------------------------------------------------
    /**
     * tests AddSongToPlaylist.
     */
    public void testAddSongToPlaylist() {
        Song song = new Song("song", 35, 12, 8, "mix 1");
        songQueue.enqueue(song);
        assertTrue(calc.addSongToPlaylist());
        assertEquals(0, songQueue.getSize());
        
        assertFalse(calc.addSongToPlaylist());
    }
    
    // ----------------------------------------------------------
    /**
     * tests Reject.
     */
    public void testReject() {
        Song song = new Song("song reject", 100, 99, 98, "");
        songQueue.enqueue(song);
        calc.reject();
        assertTrue(calc.getRejectedTracks().contains(song));
    }
    
    // ----------------------------------------------------------
    /**
     * tests GetPlayListIndex.
     */
    public void testGetPlaylistIndex() {
        assertEquals(0, calc.getPlaylistIndex("mix 1"));
    }

}
