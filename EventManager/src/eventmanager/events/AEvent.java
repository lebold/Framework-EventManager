package eventmanager.events;

public abstract class AEvent implements IEvent{

	private Object id;
	
	public AEvent(Object id){
		this.id=id;
	}

	public void registerID(Object id) {
		this.id=id;
	}
	
	public Object pullID(){
		return this.id;
	}
	
	public boolean validate(Object id){
		return this.id.equals(id);
	}

	public boolean equals(Object obj){
		if(obj instanceof AEvent){
			AEvent other = (AEvent)obj;
			return other.validate(this.id);
		}
		return false;
	}
}
