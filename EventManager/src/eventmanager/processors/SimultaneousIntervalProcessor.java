package eventmanager.processors;

import eventmanager.events.IEvent;

public class SimultaneousIntervalProcessor extends AIntervalProcessor {

	
	public SimultaneousIntervalProcessor(){
		super();
	}

	public void processEvents() {
		for(int n=super.events.size()-1;n>=0;n--){
			IEvent event = super.events.get(n);
			event.run();
			int interval = super.intervalMap.get(event.pullID());
			interval--;
			if(interval<=0)
				unregisterEvent(event.pullID());
			else
				super.intervalMap.put(event.pullID(), interval);
		}
	}
}
