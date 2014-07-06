package eventmanager.events;

import java.util.ArrayList;

public class CompoundEvent extends AEvent {

	private ArrayList<IEvent> events;
	
	public CompoundEvent(Object id){
		super(id);
		this.events=new ArrayList<IEvent>();
	}

	public CompoundEvent(Object id, ArrayList<IEvent> events){
		super(id);
		this.events=events;
	}
	
	public void registerEvent(IEvent event){
		this.events.add(event);
	}
	
	public void unregisterEvent(Object id){
		for(int n=this.events.size()-1;n>=0;n--){
			IEvent event = this.events.get(n);
			if(event.validate(id))
				this.events.remove(n);
		}
	}
	
	public void run(){
		for(IEvent event:this.events){
			event.run();
		}
	}
}
