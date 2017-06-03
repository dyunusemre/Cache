package cachableobject;

public abstract class CachableObject{
	
	protected long lastAccesed;
	
	public long getLastAccesed() {
		
		return lastAccesed;
	
	} 
	public void setLastAccesed(long lastAccesed) {	
		
		this.lastAccesed = lastAccesed;		
		
	}

}
