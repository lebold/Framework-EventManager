package eventmanager.processors;

import java.util.HashMap;

import eventmanager.events.IEvent;

public class SimultaneousIntervalProcessor extends AProcessor {

	private HashMap<Object,Integer> intervalMap;
	
	public SimultaneousIntervalProcessor(){
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

	public void processEvents() {
		for(int n=super.events.size()-1;n>=0;n--){
			IEvent event = super.events.get(n);
			event.run();
			int interval = this.intervalMap.get(event.pullID());
			interval--;
			if(interval<=0)
				unregisterEvent(event.pullID());
			else
				this.intervalMap.put(event.pullID(), interval);
		}
	}
}
