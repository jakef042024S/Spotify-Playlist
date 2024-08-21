// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor 
// and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept 
// the actions of those who do.
// -- Jake Fortuna

package dailymixes;

// -------------------------------------------------------------------------
/**
 *  Playlist.
 * 
 *  @author jake
 *  @version Apr 9, 2024
 */
public class Playlist implements Comparable<Playlist> {

    //~ Fields ................................................................
    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name; 


    //~ Constructors ..........................................................
    
    // ----------------------------------------------------------
    /**
     * Create a new Playlist object.
     * @param playlistName  
     * name  
     * @param minPop
     * min pop
     * @param minRock
     * min rock
     * @param minCountry
     * min country
     * @param maxPop
     * max pop
     * @param maxRock
     * max rock
     * @param maxCountry
     * max coutnry
     * @param playlistCap
     * the cap
     */
    public Playlist(String playlistName,  int  minPop,  int  minRock,  
        int  minCountry, int maxPop, int maxRock, int maxCountry,  
        int  playlistCap) {
        this.name = playlistName;
        minGenreSet = new GenreSet(minPop, minRock, minCountry);
        maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        this.capacity = playlistCap;
        this.songs = new Song[playlistCap];
        this.numberOfSongs = 0;   
    }

    //~Public  Methods ........................................................
    
    // ----------------------------------------------------------
    /**
     * PgetMinGenreSet.
     * @return
     * GenreSet
     */
    public GenreSet getMinGenreSet() {
        return minGenreSet;
    }
    
    // ----------------------------------------------------------
    /**
     * setName.
     * @param s
     * a string
     */
    public void setName(String s) {
        this.name = s;
    }
    
    // ----------------------------------------------------------
    /**
     * getMaxgenreSet.
     * @return
     * GenreSet
     */
    public GenreSet getMaxGenreSet() {
        return maxGenreSet;
    }
    
    // ----------------------------------------------------------
    /**
     * getNumberofSongs.
     * @return
     * int
     */
    public int getNumberOfSongs() {
        return numberOfSongs;
    }
    
    // ----------------------------------------------------------
    /**
     * getSongs.
     * @return
     * songs
     */
    public Song[] getSongs() {
        return songs;
    }
    
    // ----------------------------------------------------------
    /**
     * getCapacity.
     * @return
     * capacity
     */
    public int getCapacity() {
        return capacity;
    }
    
    // ----------------------------------------------------------
    /**
     * getName.
     * @return
     * string
     */
    public String getName() {
        return name;
    }
    
    // ----------------------------------------------------------
    /**
     * getSpacesLeft.
     * @return
     * int
     */
    public int getSpacesLeft() {
        return capacity - numberOfSongs;
    }
    
    // ----------------------------------------------------------
    /**
     * isFull.
     * @return
     * boolean
     */
    public boolean isFull() {
        return capacity == numberOfSongs;
    }
    
    // ----------------------------------------------------------
    /**
     * isQualified.
     * @param song
     * a song
     * @return
     * boolean
     */
    public boolean isQualified(Song song) {
        GenreSet genreSet = song.getGenreSet();
        return genreSet.isWithinRange(minGenreSet, maxGenreSet);
    }
    
    // ----------------------------------------------------------
    /**
     * addSong.
     * @param newSong
     * new song
     * @return
     * boolean
     */
    public boolean addSong(Song newSong) {
        if (!isFull()) {
            if (isQualified(newSong)) {
                songs[numberOfSongs] = newSong;
                numberOfSongs++;
                return true;
            }
            return false;
        }
        return false;
    }
    
    // ----------------------------------------------------------
    /**
     * toString.
     * @return
     * string
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Playlist: " + name + ", ");
        str.append("# of songs: " + numberOfSongs + " ");
        str.append("(cap: " + capacity + "), ");
        str.append("Requires: Pop:" + minGenreSet.getPop() 
            + "%-" + maxGenreSet.getPop() + "%, Rock:" + 
            minGenreSet.getRock() + "%-" + maxGenreSet.getRock() + 
            "%, Country:" + minGenreSet.getCountry() + "%-" + 
            maxGenreSet.getCountry() + "%");
        return str.toString();
    }
    
    // ----------------------------------------------------------
    /**
     * equals.
     * @param obj
     * the obj
     * @return
     * boolean
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (this.getClass() == obj.getClass()) {
            Playlist other = (Playlist)obj;
            if (this.name.equals(other.getName()) && 
                this.minGenreSet.equals(other.minGenreSet) && 
                this.maxGenreSet.equals(other.maxGenreSet) &&
                this.capacity == other.getCapacity() &&
                this.numberOfSongs == other.getNumberOfSongs()) {
                
                for (int i = 0; i < numberOfSongs; i++) {
                    if (!this.songs[i].equals(other.getSongs()[i])) {
                        return false;
                    }
                }
                return true;   
            }
        }
        return false;
    }
    
    // ----------------------------------------------------------
    /**
     * compareTo.
     * @param other
     * the other
     * @return
     * int
     */
    @SuppressWarnings("unused")
    @Override
    public int compareTo(Playlist other) {
        int capacityCompare = this.capacity - other.capacity;
        int spacesLeftCompare = this.getSpacesLeft() - other.getSpacesLeft();
        int minGenreSetCompare = 
            this.minGenreSet.compareTo(other.minGenreSet);
        int maxGenreSetCompare = 
            this.maxGenreSet.compareTo(other.maxGenreSet);
        int nameCompare = this.name.compareTo(other.name);
        
        if (other == null) {
            throw new IllegalArgumentException();
        }

        if (capacityCompare != 0) {
            return capacityCompare;
        } 
        else if (spacesLeftCompare != 0) {
            return spacesLeftCompare;
        } 
        else if (minGenreSetCompare != 0) {
            return minGenreSetCompare;
        } 
        else if (maxGenreSetCompare != 0) {
            return maxGenreSetCompare; 
        } 
        else {
            return nameCompare;
        }  
    }

}
