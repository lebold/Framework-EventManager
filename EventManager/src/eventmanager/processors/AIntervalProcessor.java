package eventmanager.processors;

import java.util.HashMap;

import eventmanager.events.IEvent;

public abstract class AIntervalProcessor extends AProcessor {

	protected HashMap<Object,Integer> intervalMap;
	
	public AIntervalProcessor(){
		super();
		this.intervalMap = new HashMap<Object,Integer>();
	}
	
	public void registerEvent(IEvent event){
		this.registerEvent(event,1);
	}
	
	public void registerEvent(IEvent event, int interval) throws IllegalArgumentException{
		if(interval<=0){
			throw new IllegalArgumentException("The interval cannot be less than 1.");
		}
		super.registerEvent(event);
		this.intervalMap.put(event.pullID(), interval);
	}
	
	public void unregisterEvent(Object id){
		this.intervalMap.remove(id);
		super.unregisterEvent(id);
	}
}
