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
 *  GenreSet
 * 
 *  @author jake
 *  @version Apr 3, 2024
 */
public class GenreSet implements Comparable<GenreSet> {
    //~ Fields ................................................................
    private int rock;
    private int pop;
    private int country;

    //~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new GenreSet object.
     * @param pop
     *            int for pop
     * @param rock
     *            int for rock
     * @param country
     *            int for country
     */
    public GenreSet(int pop, int rock, int country) {
        this.pop = pop;
        this.rock = rock;
        this.country = country;
    }
    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * getRock
     * @return int
     */
    public int getRock() {
        return this.rock;
    }
    
    // ----------------------------------------------------------
    /**
     * getPop.
     * @return int
     */
    public int getPop() {
        return this.pop;
    }
    
    // ----------------------------------------------------------
    /**
     * getCountry
     * @return int
     */
    public int getCountry() {
        return this.country;
    }
    
    // ----------------------------------------------------------
    /**
     * isLessThanOrEqual
     * @return boolean
     */
    private boolean isLessThanOrEqualTo(GenreSet other) {
        return (this.pop <= other.pop) && 
            (this.country <= other.country) && (this.rock <= other.rock);     
        

    }
    
    // ----------------------------------------------------------
    /**
     * isWithinRange
     * @param minGenreSet
     *                    minGenre
     * @param maxGenreSet
     *                    maxGenre
     * @return boolean
     */
    public boolean isWithinRange(GenreSet minGenreSet, GenreSet maxGenreSet) {
        return (minGenreSet.isLessThanOrEqualTo(this) && 
            (this.isLessThanOrEqualTo(maxGenreSet)));
                    
        
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
            GenreSet other = (GenreSet)obj;
            return pop == other.pop && rock 
                == other.rock && country == other.country;   
        }
        return false;

    }
    
    // ----------------------------------------------------------
    /**
     * compareTo
     * @param other
     *            other
     *       
     * @return int
     */
    public int compareTo(GenreSet other) { 
        int cur = (this.pop + this.rock + this.country);
        int oth = (other.pop + other.rock + other.country);
        return cur - oth;
    }
    
    // ----------------------------------------------------------
    /**
     * toString
     * @return String
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Pop:" + this.pop);
        str.append(" Rock:" + this.rock);
        str.append(" Country:" + this.country);
        return str.toString();

    }



}
