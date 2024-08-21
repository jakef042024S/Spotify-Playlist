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
 *  ArrayQueueTest.
 * 
 *  @author jake
 *  @version Apr 3, 2024
 */
public class ArrayQueueTest extends TestCase
{
    //~ Fields ................................................................
    private ArrayQueue<String> queue;
    private ArrayQueue<String> emptyQueue;
    private ArrayQueue<Integer> intQueue;
    private Exception exception;

    //~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * setUp
     */
    public void setUp() {
        queue = new ArrayQueue<String>();
        queue.enqueue("A");
        queue.enqueue("B");
        emptyQueue = new ArrayQueue<String>();
        exception = null;
        
        intQueue = new ArrayQueue<Integer>();
        for (int i = 0; i < 20; i++) {
            intQueue.enqueue(i);
        }
    }

    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * testgetlengthofunderlyingarray.
     */
    public void testGetLengthOfUnderlyingArray() {
        assertEquals(21, queue.getLengthOfUnderlyingArray());
    }
    // ----------------------------------------------------------
    /**
     * testClear.
     */
    public void testClear() {
        queue.clear();
        assertTrue(queue.isEmpty());
    }
    
    // ----------------------------------------------------------
    /**
     * testDequeue
     */
    public void testDequeue() {
        try {
            emptyQueue.dequeue();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals("A", queue.dequeue());
    }
    
    // ----------------------------------------------------------
    /**
     * testEnqueue
     */
    public void testEnqueue() {
        emptyQueue.enqueue("C");
        assertEquals(1, emptyQueue.getSize());
    }
    
    // ----------------------------------------------------------
    /**
     * testFront
     */
    public void testFront() {
        try {
            emptyQueue.getFront();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals("A", queue.getFront());
    }
    
    // ----------------------------------------------------------
    /**
     * testIsEmpty
     */
    public void testIsEmpty() {
        assertTrue(emptyQueue.isEmpty());
        assertFalse(queue.isEmpty());
    }
    
    // ----------------------------------------------------------
    /**
     * testToArray
     */
    public void testToArray() {
        intQueue.dequeue();
        intQueue.enqueue(0);
        Object [] arr = intQueue.toArray();
        assertEquals(1, arr[0]);
    }
    
    // ----------------------------------------------------------
    /**
     * testToString
     */
    public void testToString() {
        String str = queue.toString();
        String eS = emptyQueue.toString();
        assertEquals("[A, B]", str);
        assertEquals("[]", eS);
    }
    
    // ----------------------------------------------------------
    /**
     * testEquals
     */
    public void testEquals() {
        try {
            emptyQueue.equals(queue);
        }
        catch (Exception e) {
            exception = e;
        }
        Object o = new Object();
        assertFalse(queue.equals(null));
        assertTrue(queue.equals(queue));
        assertFalse(queue.equals(o));
        emptyQueue.enqueue("A");
        assertFalse(queue.equals(emptyQueue));
        emptyQueue.enqueue("B");
        assertTrue(queue.equals(emptyQueue));
        emptyQueue.dequeue();
        emptyQueue.enqueue("D");
        assertFalse(queue.equals(emptyQueue));
    }
    
    // ----------------------------------------------------------
    /**
     * testEnsureCapacity
     */
    public void testEnsureCapacity() {
        intQueue.enqueue(21);
        assertEquals("0", intQueue.getFront().toString());
    }

}
