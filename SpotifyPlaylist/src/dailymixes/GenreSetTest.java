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
 *  GenreSetTest.
 * 
 *  @author jake
 *  @version Apr 3, 2024
 */
public class GenreSetTest extends TestCase
{
    //~ Fields ................................................................
    private GenreSet set;

    //~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * setUp
     */
    public void setUp() {
        set = new GenreSet(10, 20, 30);
    }

    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * testPop.
     */
    public void testPop() {
        assertEquals(10, set.getPop());
    }
    
    // ----------------------------------------------------------
    /**
     * testRock.
     */
    public void testRock() {
        assertEquals(20, set.getRock());
    }
    
    // ----------------------------------------------------------
    /**
     * testCountry.
     */
    public void testCountry() {
        assertEquals(30, set.getCountry());
    }
    
    // ----------------------------------------------------------
    /**
     * testIsWithinRange.
     */
    public void testIsWithinRange() {
        GenreSet highPop = new GenreSet(20, 20, 30);
        GenreSet highRock = new GenreSet(10, 30, 30);
        GenreSet highCountry = new GenreSet(10, 20, 40);
        GenreSet lowPop = new GenreSet(0, 20, 30);
        GenreSet lowRock = new GenreSet(10, 0, 30);
        GenreSet lowCountry = new GenreSet(10, 20, 0);
        
        assertTrue(set.isWithinRange(lowPop, highPop));     
        assertTrue(set.isWithinRange(lowRock, highRock));  
        assertTrue(set.isWithinRange(lowCountry, highCountry));  
        assertFalse(set.isWithinRange(highPop, lowPop));
        assertFalse(set.isWithinRange(highRock, lowRock));
        assertFalse(set.isWithinRange(highCountry, lowCountry));
        assertFalse(set.isWithinRange(lowPop, lowPop));
    }
    
    // ----------------------------------------------------------
    /**
     * testEquals.
     */
    public void testEquals() {
        Object o = new Object();
        assertTrue(set.equals(set));
        assertFalse(set.equals(null));
        assertFalse(set.equals(o));
        GenreSet diffPop = new GenreSet(2, 20, 30);
        GenreSet diffRock = new GenreSet(10, 2, 30);
        GenreSet diffCountry = new GenreSet(10, 20, 2);
        GenreSet same = new GenreSet(10, 20, 30);
        assertFalse(set.equals(diffPop));
        assertFalse(set.equals(diffRock));
        assertFalse(set.equals(diffCountry));
        assertTrue(set.equals(same));
    }
    
    // ----------------------------------------------------------
    /**
     * testCompareTo.
     */
    public void testCompareTo() {
        assertEquals(0, set.compareTo(set));
    }
    
    // ----------------------------------------------------------
    /**
     * testToString.
     */
    public void testToString() {
        assertEquals("Pop:10 Rock:20 Country:30", set.toString());
    }

}
