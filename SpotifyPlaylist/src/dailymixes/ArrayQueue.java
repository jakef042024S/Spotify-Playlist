// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor 
// and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept 
// the actions of those who do.
// -- Jake Fortuna

package dailymixes;

import queue.EmptyQueueException;
import queue.QueueInterface;

// -------------------------------------------------------------------------
/**
 *  ArrayQueue class
 *  @param <T>
 * 
 *  @author jake
 *  @version Apr 3, 2024
 */
public class ArrayQueue<T> implements QueueInterface<T> {
    //~ Fields ................................................................
    
    /**
     * Default_Capacity
     */
    public static final int DEFAULT_CAPACITY = 20;
    private T[] queue;
    private int dequeueIndex;
    private int size;
    private int enqueueIndex;
    
    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     */
    //~ Constructors ..........................................................
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }
    
    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     * @param capacity
     *                the capacity
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        queue = (T[]) new Object[capacity];
        dequeueIndex = 0;
        size = 0;
        enqueueIndex = queue.length - 1;
    }
    
    // ----------------------------------------------------------
    /**
     * getLengthOfUnderlyingArray
     * @return int
     */
    public int getLengthOfUnderlyingArray() {
        int unSize = queue.length + 1;
        return unSize++;
    }
    
    // ----------------------------------------------------------
    /**
     * ensureCapacity
     */
    @SuppressWarnings("unchecked") 
    private void ensureCapacity() {  
        if (size == queue.length) {
            
            int newQueueSize = 2 * queue.length;
            T[] oldQueue = queue;
            queue = (T[]) new Object[newQueueSize];
            int dequeue = dequeueIndex;
            
            for (int i = 0; i < size; i++) {
                queue[i] = oldQueue[dequeue];
                incrementIndex(dequeue);
                dequeue++;
            }
            
            dequeueIndex = 0;
            enqueueIndex = size - 1;
        }
    }
    
    // ----------------------------------------------------------
    /**
     * ensureCapacity
     */
    @SuppressWarnings("unchecked")
    public void clear()
    {
        queue = (T[]) new Object[DEFAULT_CAPACITY];
        dequeueIndex = 0;
        size = 0;
        enqueueIndex = queue.length - 1;
        
    }
    // ----------------------------------------------------------
    /**
     * getFront
     * @return T
     */
    @Override
    public T getFront()
    {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }
    
    // ----------------------------------------------------------
    /**
     * dequeue
     * @return T
     */
    @Override
    public T dequeue()
    {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T front = getFront();
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return front;
    }
    
    // ----------------------------------------------------------
    /**
     * enqueue
     */
    @Override
    public void enqueue(T arg)
    {
        ensureCapacity();
        enqueueIndex = incrementIndex(enqueueIndex);
        queue[enqueueIndex] = arg;
        size++;
        
    }
    
    // ----------------------------------------------------------
    /**
     * isEmpty
     * @return boolean
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    // ----------------------------------------------------------
    /**
     * getSize
     * @return int
     */
    public int getSize() {
        return size;
    }
    
    // ----------------------------------------------------------
    /**
     * incrementIndex
     * @return int
     */
    private int incrementIndex(int index) {
        return (index + 1) % queue.length;
        
    }
    
    // ----------------------------------------------------------
    /**
     * toArray
     * @return Object[]
     */
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int begin  = dequeueIndex;
        for (int i = 0; i < size; i++ ) {
            
            arr[i] = queue[begin];
            begin++;
            if (begin == queue.length) {
                begin = 0;
            }
        }
        return arr;
    }
    
    // ----------------------------------------------------------
    /**
     * toString
     * @return String
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (isEmpty()) {
            return "[]";
        }
        str.append("[");
        Object[] arr = toArray();
        for (int i = 0; i < size - 1; i++) {
            str.append(arr[i].toString());
            str.append(", ");
        }
        str.append(arr[size - 1]);
        str.append("]");
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
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            
            ArrayQueue<T> otherAQ = (ArrayQueue<T>) obj;
            if (size == otherAQ.getSize()) {
                int correct = 0;
                Object[] thisArr = toArray();
                Object[] otherArr = otherAQ.toArray();
                for (int i = 0; i < size; i++) {
                    
                    if (thisArr[i].equals(otherArr[i])) {
                        correct++;
                    }
                }
                if (correct == size) {
                    return true;
                }
                
            }
        }
        return false;
    }

    //~Public  Methods ........................................................

}
