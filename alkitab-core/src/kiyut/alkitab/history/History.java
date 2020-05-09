/* This work has been placed into the public domain. */

package kiyut.alkitab.history;

import org.crosswire.jsword.passage.Key;
import org.crosswire.jsword.passage.RestrictionType;

/**
 * An interface representing a history and able to go back or forward one at the time.
 * It works similar to java.util.Iterator.
 * 
 * Previous and Next is not history, it is used to navigate large collections 
 * of verses/passage in single history which does not fit into single screen aka
 * number of versed per view
 * 
 * @author Tonny Kohar <tonny.kohar@gmail.com>
 */
public interface History {
    /** 
     * Return original key assigned to this History object
     * @return key
     */
    public Key getKey();

    /** 
     * Return original search string assigned to this History object, can be null 
     * @return search string
     */
    public String getSearch();
    
    /** 
     * Return the current key in this iteration 
     * @return key
     */
    public Key current();
    
    /** 
     * Return the first key in this iteration 
     * @return key
     */
    public Key first();
    
    /** 
     * Return the next key or null in this iteration 
     * @return key
     */
    public Key next();
    
    /** 
     * Return the previous key or null in this iteration 
     * @return key
     */
    public Key previous();
    
    /** 
     * Return true if this history has next key while traversing in forward direction 
     * @return true or false
     */
    public boolean hasNext();
    
    /** 
     * Return true if this history has previous key while traversing in backward direction 
     * @return true or false
     */
    public boolean hasPrevious();
    
    /** 
     * Expand / blur the key by
     * <strong>note: </strong> only applicable to verse/passage key type
     * @param by The number of verses/keys to widen by
     * @param restrict The RestrictionType
     * @return new History or null if it is not verse or passage key type
     */
    public History blur(int by, RestrictionType restrict);
}
