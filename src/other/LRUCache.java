package other;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {
	HashMap<Integer,Integer> cache; 
	Deque<Integer> recents; 
	int size;
	
    public LRUCache(int capacity) {
    	this.size = capacity;	
    	cache = new HashMap<Integer, Integer>();
    	recents = new LinkedList<Integer>();
    }
    
    public int get(int key) {
        Integer returnVal = cache.get(key);
        recents.remove(key);
        recents.addFirst(key);
        return returnVal!=null?returnVal:-1;
    }
    
    
    public void put(int key, int value) {
        Integer existingValue = cache.get(key);
        if(existingValue==null && cache.size()==size ) {
        	Integer removeKey = recents.pollLast();
        	cache.remove(removeKey);
        }
        cache.put(key,value);
        recents.remove(key);
        recents.addFirst(key);
    }
    
    public static void main(String args[]) {
    	LRUCache cache = new LRUCache( 2 /* capacity */ );

    	System.out.println(cache.recents.peekLast());
    }
}

