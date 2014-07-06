package eventmanager.processors;

import eventmanager.events.IEvent;

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
