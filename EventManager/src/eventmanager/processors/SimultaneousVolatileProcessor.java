package eventmanager.processors;

import eventmanager.events.IEvent;

/**
 * @author Patrick Lebold
 * This class is a brand of IProcessor that processes events in volatile-style.
 * Volatile-style processors remove events after being processed
 * Simultaneous-based processors process all registered events.
 */
public class SimultaneousVolatileProcessor extends AProcessor {

	public SimultaneousVolatileProcessor(){
		super();
	}
	
	@Override
	public void processEvents() {
		for(int n=super.events.size()-1;n>=0;n--){
			IEvent event = super.events.get(n);
			event.run();
			super.unregisterEvent(event.pullID());
		}
	}

}
