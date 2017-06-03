package cache;

public abstract class Cache<K,V> {

	public abstract void put(K key, V obj);
	public abstract V get(K key);
	public abstract void remove(K key);
	public abstract boolean contains(K key);
	public abstract boolean timeToClean();
	public abstract void cleanUp();
	
}
