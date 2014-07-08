package eventmanager.processors;

import eventmanager.events.IEvent;

/**
 * @author Patrick Lebold
 * This class is a brand of IProcessor that processes events in interval-style.
 * See class-AIntervalProcessor for info on interval-style.
 * Simultaneous-based processors process all registered events.
 */
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
