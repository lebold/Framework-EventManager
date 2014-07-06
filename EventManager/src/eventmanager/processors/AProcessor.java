package eventmanager.processors;

import java.util.ArrayList;

import eventmanager.events.IEvent;

public abstract class AProcessor implements IProcessor {
	
	protected ArrayList<IEvent> events;
	
	public AProcessor(){
		this.events = new ArrayList<IEvent>();
	}

	public void registerEvent(IEvent e){
		this.events.add(e);
	}

	public void unregisterEvent(Object id) {
		for(int n=this.events.size()-1;n>=0;n--){
			IEvent event = events.get(n);
			if(event.validate(id))
				this.events.remove(n);
		}
	}

}
