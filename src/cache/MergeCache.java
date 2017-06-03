package cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import cachableobject.CachableObject;


public class MergeCache<K,V> extends Cache<K,V>{
	
	private Map<K,V> map = null;
	private final double LIMIT;
	protected boolean isCacheFull = true;
	private Map<K,ReentrantReadWriteLock> lockMap;
	private boolean concurency;
	private long cleanTime;	
	/**
	 * 
	 * concurency degiskeni true oldugunda MAXIMUM HIT RATIO icin bellek implement edilir
	 * concurency degiskeni false oldugunda MAXIMUM SPEED icin bellek implement edilir
	 * 
	 * 
	 * bellek %80 kadar doldugunda temizlenir
	 * 
	 * 
	 * */
	public MergeCache(double size,boolean implement){
		
		this.map = new HashMap<K,V>();
		this.LIMIT = size; 
		this.lockMap = new ConcurrentHashMap<K,ReentrantReadWriteLock>();
		this.concurency = implement;
		this.cleanTime = (long) (this.LIMIT * 0.8);
				
	}
	public boolean timeToClean(){
		
		if(map.size()  >= (double)(LIMIT * 0.8)){
			return true;			
		}else{	
			return false;
		}
		
	}
	public void writeLocked(K key){	
		
		if(lockMap.get(key) == null){
			lockMap.put(key, new ReentrantReadWriteLock());
			lockMap.get(key).writeLock().lock();
		}else{
			lockMap.get(key).writeLock().lock();
		}		
		
	}
	public void writeUnlocked(K key){	
		lockMap.get(key).writeLock().unlock();	
	}	
	public void readLocked(K key){
		
		if(lockMap.get(key) == null){
			lockMap.put(key, new ReentrantReadWriteLock());
			lockMap.get(key).readLock().lock();
		}else{
			lockMap.get(key).readLock().lock();
		}
		
	}
	public void readUnlocked(K key){		
		lockMap.get(key).readLock().unlock();		
	}	
	public void put(K key,V obj){
		
		if(map.size() < this.LIMIT && this.concurency == true){
			writeLocked(key);	
			map.put(key, obj);				
			writeUnlocked(key);			
		}else if(map.size() < this.LIMIT  && this.concurency == false){			
			map.put(key, obj);			
		}else if(this.timeToClean()){			
			this.cleanUp();			
		}
		
	}	
	public V get(K key){
		
		V value = null;		
		if(map.get(key)!= null  && this.concurency == true){			
			this.readLocked(key);				
			value = map.get(key);				
			this.readUnlocked(key);				
		}else if(map.get(key)!= null  && this.concurency == false){			
			value = map.get(key);			
		}
		return value;	
		
	}	
	public void remove(K key){
				
		if(map.get(key)!= null && this.concurency == true){		
			this.readLocked(key);
			map.remove(key);
			this.readUnlocked(key);		
		}else if(map.get(key)!= null && this.concurency == false){			
			map.remove(key);			
		}
		
	}
	public boolean contains(K key){
		
		boolean contain = false;		
		if(map.get(key)!= null && this.concurency == true){			
			this.readLocked(key);
			contain = map.containsKey(key);
			this.readUnlocked(key);			
		}else if(map.get(key)!= null && this.concurency == false){			
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
		if(concurency){
			synchronized(map){		
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
			
		}else{
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

}
