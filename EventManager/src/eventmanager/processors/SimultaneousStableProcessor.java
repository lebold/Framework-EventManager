package eventmanager.processors;

import eventmanager.events.IEvent;

/**
 * @author Patrick Lebold
 * This class is a brand of IProcessor that processes events in stable-style.
 * Stable-style processors do not remove events by themselves.
 * Simultaneous-based processors process all registered events.
 */
public class SimultaneousStableProcessor extends AProcessor {

	public SimultaneousStableProcessor(){
		super();
	}
	
	public void processEvents() {
		for(IEvent event:super.events){
			event.run();
		}
	}
}
