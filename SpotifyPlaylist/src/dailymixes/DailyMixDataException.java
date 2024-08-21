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
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author jake
 *  @version Apr 8, 2024
 */
public class DailyMixDataException extends Exception {
    //~ Constructors ..........................................................
    
    // ----------------------------------------------------------
    /**
     * Create a new DailyMixDataException object.
     * @param string
     */
    public DailyMixDataException(String string) {
        super(string);
    }
}
