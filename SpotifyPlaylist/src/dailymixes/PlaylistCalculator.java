// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor 
// and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept 
// the actions of those who do.
// -- Jake Fortuna

package dailymixes;
import java.util.Arrays;
import list.AList;

// -------------------------------------------------------------------------
/**
 *  PlaylistCalculator
 * 
 *  @author jake
 *  @version Apr 9, 2024
 */
public class PlaylistCalculator {
    //~ Fields ................................................................
    private Playlist[] playlists;
    /**
     * Num playlists constant
     */
    public static final int NUM_PLAYLISTS = 3; 
    /**
     * min percent constant
     */
    public static final int MIN_PERCENT = 0;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> songQueue;
    /**
     * max percent constant
     */
    public static final int MAX_PERCENT = 100;

    //~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     * @param songQueue
     * the song queue
     * @param playlists
     * the playlists
     */
    public PlaylistCalculator(ArrayQueue<Song> songQueue, 
        Playlist[] playlists) {
        
        if (songQueue == null) {
            throw new IllegalArgumentException();
        }
        
        this.songQueue = songQueue;
        this.playlists = playlists;
        this.rejectedTracks = new AList<Song>();    
    }

    //~Public  Methods ........................................................
    
    // ----------------------------------------------------------
    /**
     * see if it canAccept.
     * @param playlist
     * the playlist
     * @param song
     * the song
     * @return
     * boolean
     */
    private boolean canAccept(Playlist playlist, Song song) {
        if (playlist == null) {
            return false;
        }
        
        if (song == null) {
            return false;
        }
        
        if (playlist.isFull()) {
            return false;
        }
        
        
        GenreSet songGenre = song.getGenreSet();
        GenreSet min = playlist.getMinGenreSet();
        GenreSet max = playlist.getMaxGenreSet();
        return songGenre.isWithinRange(min, max);
    }
    
    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     * @param aSong
     * the song
     * @return
     * Playlist
     */
    private Playlist getPlaylistWithMaximumCapacity(Song aSong) {
        if (aSong == null) {
            return null;
        }
        
        Playlist[] playListCopy = Arrays.copyOf(playlists, playlists.length);
        
        Arrays.sort(playListCopy);
        
        for (int i = 0; i < playlists.length; i++) {
            Playlist playlist = playlists[i];
            
            if (canAccept(playlist, aSong)) {
                return playlist;
            }
        }
        
        return null;
        
    }
    
    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     * @param nextSong
     * the song
     * @return
     * Playlist
     */
    public Playlist getPlaylistForSong(Song nextSong) {
        if (nextSong == null) {
            return null;
        }
        
        String nextSongSuggestedPlayList = nextSong.getPlaylistName();
        
        if (nextSongSuggestedPlayList != null && 
            nextSongSuggestedPlayList.length() > 0) {
            
            for (int i = 0; i < playlists.length; i++) {
                Playlist playlist = playlists[i];
                
                if (playlist.getName().equals(nextSongSuggestedPlayList) && 
                    canAccept(playlist, nextSong)) {
                    return playlist; 
                }
            }
        }
        
        return getPlaylistWithMaximumCapacity(nextSong);
        
    }
    
    //Helps with testing
    // ----------------------------------------------------------
    /**
     * rejected tracks gets.
     * @return
     * AList<Song>
     */
    public AList<Song> getRejectedTracks() {
        return rejectedTracks;
    }
    
    // ----------------------------------------------------------
    /**
     * addSongToPlaylist.
     * @return
     * boolean
     */
    public boolean addSongToPlaylist() {
        if (songQueue.isEmpty()) {
            return false;
        }
        
        Song song = songQueue.getFront();
        Playlist playlist = getPlaylistForSong(song);
        
        if (playlist != null) {
            playlist.addSong(song);
            songQueue.dequeue();
            return true;
        }
        
        return false;
    }
    
    // ----------------------------------------------------------
    /**
     * rejected songs.
     */
    public void reject() {
        if (!songQueue.isEmpty()) {
            Song reject = songQueue.getFront();
            songQueue.dequeue();
            rejectedTracks.add(reject);
            
        }

    }
    
    // ----------------------------------------------------------
    /**
     * getPlaylistIndex.
     * @param playlist
     * the playlist
     * @return
     * int
     */
    public int getPlaylistIndex(String playlist) {
        for (int i = 0; i < NUM_PLAYLISTS; i++) {
            if (playlist.equals(playlists[i].getName())) {
                return i;
            }
        }
        return -1;  
    }
    
    // ----------------------------------------------------------
    /**
     * gets the queue.
     * @return
     * ArrayQueue<Song>
     */
    public ArrayQueue<Song> getQueue() {
        return songQueue;
    }
    
    // ----------------------------------------------------------
    /**
     * getPlaylists.
     * @return
     * Playlist[]
     */
    public Playlist[] getPlaylists()  {
        return playlists;
    }
    
}
