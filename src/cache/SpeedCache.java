package cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


import cachableobject.CachableObject;

public class SpeedCache<K,V> extends Cache<K,V>{
	
	private Map<K,V> map = null;
	private final double LIMIT;
	protected boolean isCacheFull = true;
	private long cleanTime;	

	public SpeedCache(double size){
		
		this.map = new HashMap<K,V>();
		this.LIMIT = size; 
		this.cleanTime = (long) (this.LIMIT * 0.8);
				
	}
	public boolean timeToClean(){
		
		if(map.size() >= (double)(LIMIT * 0.8)){
			return true;			
		}else{	
			return false;
		}
		
	}
	public void put(K key,V obj){
		
		if(map.size() < this.LIMIT){	
			map.put(key, obj);					
		}else if(this.timeToClean()){			
			this.cleanUp();			
		}
		
	}	
	public V get(K key){
		
		V value = null;		
	    if(map.get(key)!= null){			
			value = map.get(key);			
		}
		return value;	
		
	}	
	public void remove(K key){
				
		if(map.get(key)!= null){			
			map.remove(key);			
		}
		
	}
	public boolean contains(K key){
		
		boolean contain = false;		
		if(map.get(key)!= null){			
			contain = map.containsKey(key);			
		}
		return contain;	
		
	}	
	public void cleanUp(){				
		
		Iterator<Entry<K, V>> itr = map.entrySet().iterator();		
		long currentTime = System.currentTimeMillis();
		K key = null;
		CachableObject value = null;
		ArrayList<K> deleteObj = new ArrayList<K>((int) (LIMIT - this.cleanTime));
			
		while(itr.hasNext()){			
			key = itr.next().getKey();
			value = (CachableObject) map.get(key);				
			if(value != null  && (currentTime - value.getLastAccesed()) > 200 ){					
				deleteObj.add(key);										
			}					
		}	
		for (Iterator<K> iterator = deleteObj.iterator(); iterator.hasNext();) {				
			map.remove(iterator.next());				
		}			
			
			
	}

}
