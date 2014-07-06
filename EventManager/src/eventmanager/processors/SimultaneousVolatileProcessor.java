package eventmanager.processors;

import eventmanager.events.IEvent;

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
