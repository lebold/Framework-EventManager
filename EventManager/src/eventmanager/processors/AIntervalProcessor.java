package eventmanager.processors;

import java.util.HashMap;

import eventmanager.events.IEvent;

/**
 * @author Patrick Lebold
 * This class is a template of all processors that handle events based on event-intervals.
 * When registering an event with an interval-processor, you must also indicate how many intervals you wish for
 * the event to be processed.
 */
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
