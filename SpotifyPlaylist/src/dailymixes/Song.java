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
 *  song.
 * 
 *  @author jake
 *  @version Apr 3, 2024
 */
public class Song {
    //~ Fields ................................................................
    private String name;
    private String suggestedPlaylist;
    private GenreSet genreSet;

    //~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     * @param name
     *           the name
     * @param pop
     *           the pop
     * @param rock
     *           the rock 
     * @param country
     *           the country
     * @param suggested
     *            the suggested
     */
    public Song(String name,  int  pop,  
        int rock,  int  country,  String suggested) {
        
        this.name = name;
        genreSet = new GenreSet(pop, rock, country);
        this.suggestedPlaylist = suggested; 
    }
    //~Public  Methods ........................................................
    
    // ----------------------------------------------------------
    /**
     * getPlayListName.
     * @return String
     */
    public String getPlaylistName() {
        return this.suggestedPlaylist;
    }
    
    // ----------------------------------------------------------
    /**
     * getName.
     * @return the name
     */
    public String getName() {
        return this.name;
    }
    
    // ----------------------------------------------------------
    /**
     * getGenreSet.
     * @return genreSet
     */
    public GenreSet getGenreSet() {
        return this.genreSet;
    }
    
    // ----------------------------------------------------------
    /**
     * toString
     * @return String
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (suggestedPlaylist.length() == 0) {
            str.append("No-Playlist" + " " + name + " " + genreSet.toString());
        }
        else if (suggestedPlaylist.length() > 0) {
            str.append(name + " " + genreSet.toString()
                + " " + "Suggested: " + suggestedPlaylist);
        }
        
        return str.toString();
       
    }
    
    // ----------------------------------------------------------
    /**
     * equals
     * @param obj
     *            the other
     *       
     * @return boolean
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (this.getClass() == obj.getClass()) {
            Song other = (Song)obj;
            return this.genreSet.equals(other.genreSet) && 
                this.name.equals(other.name) &&
                this.suggestedPlaylist.equals(other.suggestedPlaylist);   
        }
        return false;
        
    }

}
