/* This work has been placed into the public domain. */

package kiyut.alkitab.history;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.crosswire.jsword.passage.RestrictionType;

/**
 * Implementation of HistoryManager
 * 
 * @author Tonny Kohar <tonny.kohar@gmail.com>
 */
public class BookViewerHistoryManager implements HistoryManager {
    /** Default 100 */
    protected int limit = 100;
    
    protected List<History> backList;
    protected List<History> forwardList;
    
    public BookViewerHistoryManager() {
        this(100);
    }
    
    /**
     * 
     * @param limit the maximum limit
     */
    public BookViewerHistoryManager(int limit) {
        setLimit(limit);
        
        backList = Collections.synchronizedList(new ArrayList<>());
        forwardList = Collections.synchronizedList(new ArrayList<>());
    }
    
    @Override
    public int getLimit() {
        return limit;
    }
    
    @Override
    public void setLimit(int limit) {
        if (limit < 1) {
            throw new IllegalArgumentException("limit should not < 1");
        }
        this.limit = limit;
    }
    
    @Override
    public void add(History history) {
        if (history == null) {
            throw new IllegalArgumentException("history should not be null");
        }
        
        History curr = current();
        if (curr != null) {
            if (history.getKey().equals(current().getKey())) {
                return;
            }
        }
        
        backList.add(0, history);
        forwardList.clear();
        
        while(backList.size() > limit) {
            backList.remove(backList.size() - 1);
        }
    }

    @Override
    public History blur(int by, RestrictionType restrict) {
        History curr = current();
        if (curr != null) {
            History hist = curr.blur(by, restrict);
            if (hist != null) {
                add(hist);
                return current();
            }
        }
        return null;
    }
    
    @Override
    public History current() {
        if (backList.size() < 1) {
            return null;
        }
        return backList.get(0);
    }
    
    @Override
    public synchronized History back() {
        if (!hasBack()) {
            return null;
        }        
        
        History hist = backList.remove(0);
        forwardList.add(0, hist);
        
        return current();
    }
    
    @Override
    public synchronized History forward() {
        if (forwardList.isEmpty()) {
            return null;
        }
        
        History hist = forwardList.remove(0);
        backList.add(0, hist);
        
        return current();
    }
    
    @Override
    public boolean hasBack() {
        // need > 1, because index 0 is current
        return backList.size() > 1;
    }
    
    @Override
    public boolean hasForward() {
        return forwardList.size() > 0;
    }
}
